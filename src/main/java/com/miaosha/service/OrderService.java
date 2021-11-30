package com.miaosha.service;

import com.miaosha.error.BusinessException;
import com.miaosha.service.model.OrderModel;

public interface OrderService {

    // 订单处理秒杀活动
    // 方式1：通过前端url传过来的秒杀活动id，然后下单接口校验对应的id是否属于对应商品、活动是否已经开始
    /*
     * 方式1更好些
     *  原因1：一个商品可能对应不同的秒杀活动，如在不同的app上可能存在不同的秒杀活动，使用前端传过来的promoId有利于定位
     *  原因2：对于存在秒杀活动的商品（前端有promoId传过来的商品）进行校验，则方式2对平销的商品也会多一次判断
     */
    // 方式2：直接在下单接口内判断对应的商品是否存在秒杀活动，若存在进行中的则以秒杀价格下单
    OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException;


}
