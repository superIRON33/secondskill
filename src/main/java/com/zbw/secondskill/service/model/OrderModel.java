package com.zbw.secondskill.service.model;

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
     * 2020102100012800
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
     * 若非空，则表示是以秒杀商品方式下单
     */
    private Integer promoId;

    /**
     * 购买商品的单价,若promoId非空，则表示秒杀商品价格
     */
    private BigDecimal itemPrice;

    /**
     * 购买数量
     */
    private Integer amount;

    /**
     * 购买金额,若promoId非空，则表示秒杀商品价格
     */
    private BigDecimal orderPrice;

}
