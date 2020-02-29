package com.zbw.secondskill.service.impl;

import com.zbw.secondskill.common.enums.ResultEnum;
import com.zbw.secondskill.common.validator.ValidationResult;
import com.zbw.secondskill.common.validator.ValidatorImpl;
import com.zbw.secondskill.dao.ItemDoMapper;
import com.zbw.secondskill.dao.ItemStockDoMapper;
import com.zbw.secondskill.model.ItemModel;
import com.zbw.secondskill.model.dataobject.ItemDo;
import com.zbw.secondskill.model.dataobject.ItemStockDo;
import com.zbw.secondskill.model.dto.ResultDTO;
import com.zbw.secondskill.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @ClassName ItemServiceImpl.java
 * @Description //商品服务Service
 * @Author ZBW
 * @Date 2020年02月29日 22:56
 **/
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ValidatorImpl validator;

    @Autowired
    private ItemDoMapper itemDoMapper;

    @Autowired
    private ItemStockDoMapper itemStockDoMapper;

    private ItemDo convertItemDOFromItemModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemDo itemDo = new ItemDo();
        BeanUtils.copyProperties(itemModel, itemDo);
        itemDo.setPrice(itemModel.getPrice().doubleValue());
        return itemDo;
    }

    private ItemStockDo convertItemStockDOFromItemModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemStockDo itemStockDo = new ItemStockDo();
        BeanUtils.copyProperties(itemModel, itemStockDo);
        itemStockDo.setItemId(itemModel.getId());
        itemStockDo.setStock(itemModel.getStock());
        return itemStockDo;
    }

    @Override
    @Transactional
    public ResultDTO createItem(ItemModel itemModel) {
        //校验传入参数
        if (validator.validate(itemModel).isHasErrors()) {
            return new ResultDTO(ResultEnum.ILLEGAL_PARAMETER);
        }
        ItemDo itemDo = this.convertItemDOFromItemModel(itemModel);
        //写入数据库
        itemDoMapper.insertSelective(itemDo);
        itemModel.setId(itemDo.getId());

        ItemStockDo itemStockDo = this.convertItemStockDOFromItemModel(itemModel);
        itemStockDoMapper.insertSelective(itemStockDo);
        //创建返回完成的对象
        Object itemDo1 = itemDoMapper.selectByPrimaryKey(itemModel.getId());
        if (itemDo1 != null) {
            ResultDTO resultDTO = new ResultDTO(ResultEnum.SUCCESS);
            resultDTO.setData(itemDo1);
            return resultDTO;
        } else {
            return new ResultDTO(ResultEnum.CREATE_ITEM_FAIL);
        }

    }

    @Override
    public ResultDTO listItem() {
        return null;
    }

    @Override
    public ResultDTO getItemById(Integer id) {
        ItemDo itemDo = itemDoMapper.selectByPrimaryKey(id);
        if (itemDo == null) {
            return new ResultDTO(ResultEnum.ID_INVALID);
        }
        ItemStockDo itemStockDo = itemStockDoMapper.selectByItemId(itemDo.getId());
        ItemModel itemModel = convertModelFromDataObject(itemDo, itemStockDo);
        ResultDTO resultDTO = new ResultDTO(ResultEnum.SUCCESS);
        resultDTO.setData(resultDTO);
        return resultDTO;
    }

    private ItemModel convertModelFromDataObject(ItemDo itemDo, ItemStockDo itemStockDo) {
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(itemDo, itemModel);
        itemModel.setPrice(new BigDecimal(itemDo.getPrice()));
        itemModel.setStock(itemStockDo.getStock());
        return itemModel;
    }
}
