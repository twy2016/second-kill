package com.twy.secondkill.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twy.secondkill.entity.ItemKill;
import com.twy.secondkill.entity.ItemKillSuccess;
import com.twy.secondkill.entity.OrderStatus;
import com.twy.secondkill.mapper.ItemKillMapper;
import com.twy.secondkill.mapper.ItemKillSuccessMapper;
import com.twy.secondkill.service.ItemKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * <p>
 * 待秒杀商品表 服务实现类
 * </p>
 *
 * @author gongpeng
 * @since 2021-03-29
 */
@Service
public class ItemKillServiceImpl extends ServiceImpl<ItemKillMapper, ItemKill> implements ItemKillService {

    @Autowired
    private ItemKillMapper itemKillMapper;
    @Autowired
    private ItemKillSuccessMapper itemKillSuccessMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean KillItem(Integer killid, Integer userid) {
        Boolean result = false;
        Integer count = itemKillSuccessMapper.selectCount(Wrappers.<ItemKillSuccess>lambdaQuery()
                .eq(ItemKillSuccess::getKillId, killid)
                .eq(ItemKillSuccess::getUserId, userid)
                .eq(ItemKillSuccess::getStatus, 0));
        if (count == 0) {
            //获取商品详情
            ItemKill itemKill = itemKillMapper.selectByid(killid);
            if (itemKill != null && itemKill.getCanKill() == 1) {
                boolean res = this.update(Wrappers.<ItemKill>lambdaUpdate().eq(ItemKill::getId, killid)
                        .setSql(true, "total=total-1"));
                if (res) {
                    commonRecordKillSuccessInfo(itemKill, userid);
                    result = true;
                }
            }
        } else {
            System.out.println("您已经抢购过该商品");
        }
        return result;
    }

    private void commonRecordKillSuccessInfo(ItemKill itemKill, Integer userid) {
        ItemKillSuccess entity = new ItemKillSuccess();
//        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
//        String orderNo = String.valueOf(snowflake.nextId());
//        entity.setCode(orderNo);
        entity.setItemId(itemKill.getItemId());
        entity.setKillId(itemKill.getId());
        entity.setUserId(userid.toString());
        entity.setStatus(OrderStatus.SuccessNotPayed.getCode());
        entity.setCreateTime(new Date());
        Integer count = itemKillSuccessMapper.selectCount(Wrappers.<ItemKillSuccess>lambdaQuery()
                .eq(ItemKillSuccess::getKillId, itemKill.getId())
                .eq(ItemKillSuccess::getUserId, userid)
                .eq(ItemKillSuccess::getStatus, 0));
        if (count == 0) {
            itemKillSuccessMapper.insert(entity);
        }
    }
}
