package com.twy.secondkill.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.twy.secondkill.entity.Item;
import com.twy.secondkill.entity.ItemKill;
import com.twy.secondkill.mapper.ItemKillMapper;
import com.twy.secondkill.mapper.ItemMapper;
import com.twy.secondkill.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author gongpeng
 * @since 2021-03-29
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, Item> implements ItemService {

    @Autowired
    private ItemKillMapper itemKillMapper;

    @Override
    public List<ItemKill> getKillItems() {
        return itemKillMapper.selectAll();
    }

    @Override
    public ItemKill getKillDetail(Integer id) throws Exception {
        ItemKill itemKill = itemKillMapper.selectByid(id);
        if (itemKill == null) {
            throw new Exception("秒杀详情记录不存在");
        }
        return itemKill;
    }
}
