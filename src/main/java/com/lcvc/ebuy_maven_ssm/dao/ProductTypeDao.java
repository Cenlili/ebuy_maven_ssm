package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductTypeDao {

        /**
     * 返回所有的产品分类管理
     * @return 以List方式返回
     */
    List<ProductType> getProductTypeList();


    /**
     * 删除指定产品分类
     * @param id 关键字
     * @return 删除了多少条记录
     */
    int deleteProductType(Integer id);


    /**
     * 添加产品分类
     * @param producttype
     * @return 添加了多少条记录
     */
    int saveProductType(ProductType producttype);

    /**
     * 查找在数据库中和指定产品分类重名的个数(创建时）
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
   int existsProductType(@Param(value = "name")String name,@Param(value = "id")Integer id);


    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return null表示没有找到
     */
    ProductType getProductType(@Param(value = "id")Integer id);

    /**
     * 修改账户的基本信息
     * @param producttype id不能为空
     * @return 更改了多少条记录
     */
    int updateProductType(ProductType producttype);
}
