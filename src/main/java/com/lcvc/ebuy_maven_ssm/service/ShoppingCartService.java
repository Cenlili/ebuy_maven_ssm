package com.lcvc.ebuy_maven_ssm.service;

import java.util.Map;

public interface ShoppingCartService {

    /**
     * 添加商品到购物车当中
     * @param productId 商品的主键
     * @param number 商品的数量
     */
    void  putProduct(Integer productId,Integer number);


    /**
     * 获取购物车中的信息
     * @return
     */
    Map<Integer,Integer> getShoppingCart();
}
