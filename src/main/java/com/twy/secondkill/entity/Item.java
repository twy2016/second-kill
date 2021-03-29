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
 * 商品表
 * </p>
 *
 * @author gongpeng
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Item对象", description = "商品表")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品名")
    private String name;

    @ApiModelProperty(value = "商品编号")
    private String code;

    @ApiModelProperty(value = "库存")
    private Long stock;

    @ApiModelProperty(value = "采购时间")
    private Date purchaseTime;

    @ApiModelProperty(value = "是否有效（1=是；0=否）")
    private Integer isActive;

    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
