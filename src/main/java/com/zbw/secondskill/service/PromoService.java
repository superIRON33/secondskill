package com.zbw.secondskill.service;

import com.zbw.secondskill.service.model.PromoModel;

/**
 * @ClassName PromoService.java
 * @Description //秒杀Service
 * @Author ZBW
 * @Date 2020年03月01日 20:43
 **/
public interface PromoService {
    //根据itemid获取即将进行的或正在进行的秒杀活动
    PromoModel getPromoByItemId(Integer itemId);
}
