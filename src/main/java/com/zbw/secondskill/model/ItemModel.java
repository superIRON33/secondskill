package com.zbw.secondskill.model;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName ItemModel.java
 * @Description //TODO
 * @Author ZBW
 * @Date 2020年02月29日 16:52
 **/
@Data
public class ItemModel {
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品库存
     */
    private Integer stock;

    /**
     * 商品的描述
     */
    private String description;

    /**
     * 商品的销量
     */
    private Integer sales;

    /**
     * 商品描述图片的url
     */
    private String imgUrl;
}
