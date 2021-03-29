package com.twy.secondkill.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 待秒杀商品表
 * </p>
 *
 * @author gongpeng
 * @since 2021-03-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "ItemKill对象", description = "待秒杀商品表")
public class ItemKill implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品id")
    private Integer itemId;

    @ApiModelProperty(value = "商品名称")
    @TableField(exist = false)
    private String itemName;

    @ApiModelProperty(value = "可被秒杀的总数")
    private Integer total;

    @ApiModelProperty(value = "是否可以进行秒杀")
    @TableField(exist = false)
    private Integer canKill;

    @ApiModelProperty(value = "秒杀开始时间")
    private Date startTime;

    @ApiModelProperty(value = "秒杀结束时间")
    private Date endTime;

    @ApiModelProperty(value = "是否有效（1=是；0=否）")
    private Integer isActive;

    @ApiModelProperty(value = "创建的时间")
    private Date createTime;


}
