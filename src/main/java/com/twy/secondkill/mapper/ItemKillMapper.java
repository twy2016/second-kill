package com.twy.secondkill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.twy.secondkill.entity.ItemKill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 待秒杀商品表 Mapper 接口
 * </p>
 *
 * @author gongpeng
 * @since 2021-03-29
 */
public interface ItemKillMapper extends BaseMapper<ItemKill> {

    List<ItemKill> selectAll();

    ItemKill selectByid(@Param("id") Integer id);
}
