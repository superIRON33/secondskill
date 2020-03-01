package com.zbw.secondskill.service;

import com.zbw.secondskill.model.dto.ResultDTO;

/**
 * @InterfaceName OrderService.java
 * @Description 订单Service
 * @Author ZBW
 * @Date 2020-03-01 14:27
 **/
public interface OrderService {

    /**
     * @Param [Integer userId, Integer itemId, Integer amount]
     * @Return com.zbw.secondskill.model.dto.ResultDTO
     * @Description 用户下单接口
     * @Author zbw
     * @Time 2020/3/1 14:28
     */
    ResultDTO createOrder(Integer userId, Integer itemId, Integer amount);
}
