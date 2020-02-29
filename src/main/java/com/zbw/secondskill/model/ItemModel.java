package com.zbw.secondskill.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @ClassName ItemModel.java
 * @Description //商品领域模型
 * @Author ZBW
 * @Date 2020年02月29日 16:52
 **/
@Data
@NoArgsConstructor
public class ItemModel {
    private Integer id;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空")
    private String title;

    /**
     * 商品价格
     */
    @NotNull(message = "商品价格不能为空")
    @Min(value = 0, message = "商品价格不能为空")
    private BigDecimal price;

    /**
     * 商品库存
     */
    @NotNull(message = "库存不能为空")
    private Integer stock;

    /**
     * 商品的描述
     */
    @NotBlank(message = "商品描述不能为空")
    private String description;

    /**
     * 商品的销量
     */
    private Integer sales;

    /**
     * 商品描述图片的url
     */
    @NotBlank(message = "商品图片信息不能为空")
    private String imgUrl;

    public ItemModel(String title, BigDecimal price, Integer stock, String description, String imgUrl) {
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.description = description;
        this.imgUrl = imgUrl;
    }
}
