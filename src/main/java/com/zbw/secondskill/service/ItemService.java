package com.zbw.secondskill.service;

import com.zbw.secondskill.error.BusinessException;
import com.zbw.secondskill.service.model.ItemModel;

import java.util.List;

/**
 * @ClassName ItemService.java
 * @Description //商品服务Service接口
 * @Author ZBW
 * @Date 2020年02月29日 22:50
 **/
public interface ItemService {

    //创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    //商品列表浏览
    List<ItemModel> listItem();

    //商品详情浏览
    ItemModel getItemById(Integer id);

    //库存扣减
    boolean decreaseStock(Integer itemId,Integer amount)throws BusinessException;

    //商品销量增加
    void increaseSales(Integer itemId,Integer amount)throws BusinessException;
}
