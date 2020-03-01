package com.zbw.secondskill.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName OrderModel.java
 * @Description //交易领域模型
 * @Author ZBW
 * @Date 2020年03月01日 14:12
 **/
@Data
public class OrderModel {

    /**
     * 2018102100012828
     */
    private String id;
    /**
     * 购买的用户id
     */
    private Integer userId;
    /**
     * 购买的商品id
     */
    private Integer itemId;

    /**
     * 购买商品的单价
     */
    private BigDecimal itemPrice;

    /**
     * 购买数量
     */
    private Integer amount;
    /**
     * 购买金额
     */
    private BigDecimal orderPrice;

}
