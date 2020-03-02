package com.zbw.secondskill.service;

import com.zbw.secondskill.service.model.PromoModel;

/**
 * @ClassName PromoService.java
 * @Description //秒杀Service
 * @Author ZBW
 * @Date 2020年03月01日 20:43
 **/
public interface PromoService {

    /**
     * @Param [Integer itemId]
     * @Return com.zbw.secondskill.service.model.PromoModel
     * @Description 根据itemid获取即将进行的或正在进行的秒杀活动
     * @Author zbw
     * @Time 2020/3/3 0:18
     */
    PromoModel getPromoByItemId(Integer itemId);
}
