package com.zbw.secondskill.service.impl;

import com.zbw.secondskill.common.enums.ResultEnum;
import com.zbw.secondskill.dao.ItemDoMapper;
import com.zbw.secondskill.dao.OrderDOMapper;
import com.zbw.secondskill.dao.SequenceDOMapper;
import com.zbw.secondskill.dao.UserDoMapper;
import com.zbw.secondskill.model.OrderModel;
import com.zbw.secondskill.model.dataobject.ItemDo;
import com.zbw.secondskill.model.dataobject.OrderDO;
import com.zbw.secondskill.model.dataobject.SequenceDO;
import com.zbw.secondskill.model.dataobject.UserDo;
import com.zbw.secondskill.model.dto.ResultDTO;
import com.zbw.secondskill.service.ItemService;
import com.zbw.secondskill.service.OrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName OrderServiceImpl.java
 * @Description //订单service实现类
 * @Author ZBW
 * @Date 2020年03月01日 14:29
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ItemDoMapper itemDoMapper;

    @Autowired
    private UserDoMapper userDoMapper;

    @Autowired
    private ItemService itemService;

    @Autowired
    private OrderDOMapper orderDOMapper;

    @Autowired
    private SequenceDOMapper sequenceDOMapper;

    @Override
    @Transactional
    public ResultDTO createOrder(Integer userId, Integer itemId, Integer amount) {
        //1.校验下单状态，下单的商品是不是还存在，用户是否合法，购买数量是否正确
        ItemDo itemDo = itemDoMapper.selectByPrimaryKey(itemId);
        if (itemDo == null) {
            return new ResultDTO(ResultEnum.ITEM_NOT_EXIST);
        }
        UserDo userDo = userDoMapper.selectByPrimaryKey(userId);
        if (userDo == null) {
            return new ResultDTO(ResultEnum.USER_NOT_EXIST);
        }
        if (amount <= 0 || amount >99) {
            return new ResultDTO(ResultEnum.AMOUNT_ERROR);
        }
        //2.落单减库存
        boolean result = itemService.decreaseStock(itemId, amount);
        if (!result) {
            return new ResultDTO(ResultEnum.STOCK_NOT_ENOUGH);
        }
        //3.订单入库
        OrderModel orderModel = new OrderModel();
        orderModel.setItemId(itemId);
        orderModel.setUserId(userId);
        orderModel.setAmount(amount);
        orderModel.setItemPrice(new BigDecimal(itemDo.getPrice()));
        orderModel.setOrderPrice(new BigDecimal(itemDo.getPrice()).multiply(new BigDecimal(amount)));

        //生成订单号
        orderModel.setId(generatorOrderNo());
        OrderDO orderDO = this.convertFromOrderModel(orderModel);
        orderDOMapper.insertSelective(orderDO);
        //增加商品销量
        itemService.increaseSales(itemId, amount);
        //4.返回数据
        ResultDTO resultDTO = new ResultDTO(ResultEnum.SUCCESS);
        resultDTO.setData(orderModel);
        return resultDTO;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private String generatorOrderNo() {
        StringBuilder stringBuilder = new StringBuilder();
        //订单号有16位
        //前8位为时间信息，年月日
        LocalDateTime now = LocalDateTime.now();
        String nowDate = now.format(DateTimeFormatter.ISO_DATE).replace("-","");
        stringBuilder.append(nowDate);
        //中间6位为自增序列
        //获取当前sequence
        int sequence = 0;
        SequenceDO sequenceDO = sequenceDOMapper.getSequenceByName("order_info");
        sequence = sequenceDO.getCurrentValue();
        sequenceDO.setCurrentValue(sequenceDO.getCurrentValue() + sequenceDO.getStep());
        sequenceDOMapper.updateByPrimaryKeySelective(sequenceDO);
        String sequenceStr = String.valueOf(sequence);
        for (int i = 0; i < 6 - sequenceStr.length(); i++) {
            stringBuilder.append(0);
        }
        stringBuilder.append(sequenceStr);
        //最后2位位分库分表列
        stringBuilder.append("00");
        return stringBuilder.toString();
    }

    private OrderDO convertFromOrderModel(OrderModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderDO orderDO = new OrderDO();
        BeanUtils.copyProperties(orderModel, orderDO);
        orderDO.setItemPrice(orderModel.getItemPrice().doubleValue());
        orderDO.setOrderPrice(orderModel.getOrderPrice().doubleValue());
        return orderDO;
    }
}
