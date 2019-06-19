package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public interface ProductService {

    /**
     * 返回所有的产品分类管理
     * @return 以List方式返回
     */
    public List<Product> getProductList();

    /**
     * 删除指定账户
     * @param id 被删除的账户id
     * @return true表示删除成功
     */
    public boolean deleteProduct(Integer id);

    /**
     * 添加产品分类
     * @param product
     * @return true表示保存成功，false表示保存失败
     */
    public boolean saveProduct(Product product);
    /**
     * 判断产品是否存在重名（用于创建新产品的时候）
     * @param name
     * @return true表示存在，false表示存在
     */
    public boolean existsName(String name);


    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return null表示没有找到
     */
    public Product getProduct(Integer id);

    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     * @param product
     * @return false表示修改失败，true表示修改成功
     */
    public boolean updateProduct(Product product);

    /**
     * 分页返回记录
     * @param page 表示第几页
     * @return
     */
     List<Product> getProductList(Integer page);

    /**
     * 返回列表的最大值
     * @return
     */
    int maxPage();


    /**
     * 返回最新发布的N条记录
     * @param pageSize
     * @return
     */
    List<Product> getNewTopProductList(Integer pageSize);

   /**
     * 返回点击量最多的热门产品记录
     * @param pageSize
     * @return
             */
    List<Product> getHotProductList(Integer pageSize);

    /**
     * 按id返回商品信息
     * @param id
     * @return
     */
    List <Product> getProductByid(Integer id);

    /**
     * 按产品分类返回商品信息
     * @param id
     * @return
     */
    List<Product> getProductTypeList(Integer id);

    }

