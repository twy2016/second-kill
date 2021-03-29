package com.twy.secondkill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 秒杀成功订单表
 * </p>
 *
 * @author gongpeng
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "ItemKillSuccess对象", description = "秒杀成功订单表")
public class ItemKillSuccess implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "秒杀成功生成的订单编号")
    @TableId(value = "code", type = IdType.ASSIGN_ID)
    private String code;

    @ApiModelProperty(value = "商品id")
    private Integer itemId;

    @ApiModelProperty(value = "秒杀id")
    private Integer killId;

    @ApiModelProperty(value = "用户id")
    private String userId;

    @ApiModelProperty(value = "秒杀结果: -1无效  0成功(未付款)  1已付款  2已取消")
    private Integer status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;


}
