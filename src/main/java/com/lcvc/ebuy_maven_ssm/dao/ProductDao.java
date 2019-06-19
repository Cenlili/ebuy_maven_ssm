package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductDao {

    /**
     * 返回所有的产品管理
     *
     * @return 以List方式返回
     */
    List<Product> getProductList();


    /**
     * 删除指定产品
     * @param id 关键字
     * @return 删除了多少条记录
     */
    int deleteProduct(Integer id);

    /**
     * 添加产品分类
     * @param product
     * @return 添加了多少条记录
     */
    int saveProduct(Product product);

    /**
     * 查找在数据库中和指定产品重名的个数(创建时）
     * @param name
     * @return 返回重名的个数，0表示不重名
     */
    int existsName(@Param(value = "name")String name);

    /**
     * 查找在数据库中和指定用户名重名的个数(修改时)
     * @param name
     * @param id
     * @return 返回重名的个数，0表示不重名
     */
    int existsProduct(@Param(value = "name")String name,@Param(value = "id")Integer id);


    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return null表示没有找到
     */
    Product getProduct(@Param(value = "id")Integer id);

    /**
     * 修改账户的基本信息
     * @param product id不能为空
     * @return 更改了多少条记录
     */
    int updateProduct(Product product);

    /**
     * 分页显示数据库记录
     * @param offset 记录开始位置
     * @param length 偏移量
     * @return
     */
    List<Product> getPartlist(@Param(value = "offset")int offset,@Param(value = "length")int length);

    /**
     * 读取所有产品的记录总数
     * @return
     */
    int total();



    /**
     * 从数据库中读取指定的产品对象
     * @param id
     * @return
     */
    Product get(Integer id);

    /**
     * 返回最新发布的N条产品记录
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
     * 从数据库中读取指定的产品对象
     * @param id
     * @return
     */
    List<Product> getProductByid(Integer id);

    /**
     * 按产品分类返回商品信息
     * @param id
     * @return
     */
    List<Product> getProductTypeList(Integer id);
}


