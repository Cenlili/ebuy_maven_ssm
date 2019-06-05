package service;

import com.lcvc.ebuy_maven_ssm.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static  void  main(String[] args){

    //判断对象相等
    Product product1=new Product(1);
    Product product2=new Product(1);
    System.out.println( product1.equals(product2));
    List<Product> list=new ArrayList<Product>();
    list.add(product1);
    list.add(product2);
    System.out.println(list.contains(new Product(2)));

}
            }