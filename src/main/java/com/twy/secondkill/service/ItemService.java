package com.twy.secondkill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.twy.secondkill.entity.Item;
import com.twy.secondkill.entity.ItemKill;

import java.util.List;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author gongpeng
 * @since 2021-03-29
 */
public interface ItemService extends IService<Item> {

    List<ItemKill> getKillItems();

    ItemKill getKillDetail(Integer id) throws Exception;
}
