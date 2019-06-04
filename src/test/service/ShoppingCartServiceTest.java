package service;

import com.lcvc.ebuy_maven_ssm.service.ShoppingCartService;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;

public class ShoppingCartServiceTest extends SpringJunitTest{
    @Resource
    private ShoppingCartService shoppingCartService;

    @Test
    public  void  testCart(){
        shoppingCartService.putProduct(1,5);
        shoppingCartService.putProduct(2,6);
        shoppingCartService.putProduct(1,2);
        shoppingCartService.putProduct(3,5);
        shoppingCartService.putProduct(4,5);
        shoppingCartService.putProduct(3,7);
        System.out.println(shoppingCartService.getShoppingCart());
    }
}
