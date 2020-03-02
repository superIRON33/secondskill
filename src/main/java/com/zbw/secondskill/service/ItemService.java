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

    /**
     * @Param [ItemModel itemModel]
     * @Return com.zbw.secondskill.service.model.ItemModel
     * @Description //创建商品
     * @Author zbw
     * @Time 2020/3/3 0:15
     */
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    /**
     * @Param []
     * @Return List<com.zbw.secondskill.service.model.ItemModel>
     * @Description 商品列表浏览
     * @Author zbw
     * @Time 2020/3/3 0:15
     */
    List<ItemModel> listItem();

    /**
     * @Param Integer id
     * @Return com.zbw.secondskill.service.model.ItemModel
     * @Description 商品详情浏览
     * @Author zbw
     * @Time 2020/3/3 0:16
     */
    ItemModel getItemById(Integer id);

    /**
     * @Param [Integer itemId,Integer amount]
     * @Return boolean
     * @Description 库存扣减
     * @Author zbw
     * @Time 2020/3/3 0:16
     */
    boolean decreaseStock(Integer itemId,Integer amount)throws BusinessException;

    /**
     * @Param [Integer itemId,Integer amount]
     * @Return void
     * @Description 商品销量增加
     * @Author zbw
     * @Time 2020/3/3 0:17
     */
    void increaseSales(Integer itemId,Integer amount)throws BusinessException;
}
