package com.lcvc.ebuy_maven_ssm.service.Impl;

import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

    @Resource
    private ProductDao productDao;

    private Map<Product,Integer> map=new HashMap<Product,Integer>();//创建购物车，产品对象->购买的产品数量


    @Override
    public void putProduct(Integer productId, Integer number) {
       Product product=productDao.get(productId); //从数据库中读取产品对象。注意：此处暂时不考虑对象是否存在
        if(map.containsKey(product)){//如果包含相应商品
            map.put(product,map.get(product)+number);//将商品的数量相加
        }else{//如果不包含相应商品
            map.put(product,number);//直接将商品和对应数量放入购物车
        }
    }

    @Override
    public Map<Product,Integer> getShoppingCart(){
        return map;
    }

    @Override
    public void removeProduct(Integer productId) {
        map.remove(new Product(productId));
    }


}
