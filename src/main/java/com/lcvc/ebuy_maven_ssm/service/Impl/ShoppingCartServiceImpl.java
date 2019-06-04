package com.lcvc.ebuy_maven_ssm.service.Impl;

import com.lcvc.ebuy_maven_ssm.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    private Map<Integer,Integer> map=new HashMap<Integer,Integer>();

    @Override
    public void putProduct(Integer productId,Integer number){
     if (map.containsKey(productId)){//如果包含相应商品
         map.put(productId,map.get(productId)+number);//将商品数量相加
     }else{//如果不包含相应商品
         map.put(productId,number);//直接将商品和对应数量放入购物车
     }
    }

    @Override
    public  Map<Integer,Integer> getShoppingCart(){
        return  map;
    }
}
