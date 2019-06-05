package service;

import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.service.ShoppingCartService;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ShoppingCartServiceTest extends SpringJunitTest{
    @Resource
    private ShoppingCartService shoppingCartService;

    @Test
    public  void  testCart(){
        shoppingCartService.putProduct(71,5);
        shoppingCartService.putProduct(72,6);
        shoppingCartService.putProduct(71,2);
        shoppingCartService.putProduct(73,5);
        shoppingCartService.putProduct(74,5);
        shoppingCartService.putProduct(73,7);
        Map<Product, Integer> map=shoppingCartService.getShoppingCart();//获取购物车对象
        Set keys=map.keySet();//map.keySet()返回map集合的键集合
        Iterator it=keys.iterator();
        float total=0;//总价
        while(it.hasNext()){//it.hasNext()表示如果还有下一条记录
            Product product=(Product)it.next();//it.next()表示下一条记录具体的值
            Integer number=map.get(product);//map.get(key)表示获取主键对应的值
            System.out.print(product.getName()+"\t");//输出产品名称
            System.out.print(product.getPrice()+"\t");//输出产品单价
            System.out.print(number+"\t");//输出产品数量
            System.out.println(product.getPrice()*number);//输出产品总价
            total=total+product.getPrice()*number;
        }
        System.out.println("购物车总价" +total);
    }

}

