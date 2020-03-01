package com.zbw.secondskill.service;

import com.zbw.secondskill.model.ItemModel;
import com.zbw.secondskill.model.dto.ResultDTO;

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
     * @Return com.zbw.secondskill.model.dto.ResultDTO
     * @Description 创建商品
     * @Author zbw
     * @Time 2020/2/29 22:52
     */
    ResultDTO createItem(ItemModel itemModel);

    /**
     * @Param []
     * @Return com.zbw.secondskill.model.dto.ResultDTO
     * @Description 商品列表浏览
     * @Author zbw
     * @Time 2020/2/29 22:53
     */
    ResultDTO listItem();

    /**
     * @Param []
     * @Return com.zbw.secondskill.model.dto.ResultDTO
     * @Description 查看商品详情
     * @Author zbw
     * @Time 2020/2/29 22:53
     */
    ResultDTO getItemById(Integer id);

    /**
     * @Param [Integer itemId, Integer amount]
     * @Return boolean
     * @Description 减库存
     * @Author zbw
     * @Time 2020/3/1 17:18
     */
    boolean decreaseStock(Integer itemId, Integer amount);

    /**
     * @Param [Integer itemId, Integer amount]
     * @Return void
     * @Description 增加销量
     * @Author zbw
     * @Time 2020/3/1 20:13
     */
    void increaseSales(Integer itemId, Integer amount);
}
