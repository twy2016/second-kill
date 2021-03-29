package com.twy.secondkill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.twy.secondkill.entity.ItemKill;

/**
 * <p>
 * 待秒杀商品表 服务类
 * </p>
 *
 * @author gongpeng
 * @since 2021-03-29
 */
public interface ItemKillService extends IService<ItemKill> {

    Boolean KillItem(Integer killid, Integer userid);
}
