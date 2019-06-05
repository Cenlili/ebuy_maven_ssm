package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.ProductTypeDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public interface ProductTypeService {

    /**
     * 返回所有的产品分类管理
     * @return 以List方式返回
     */
    public List<ProductType> getProductTypeList();
    /**
     * 删除指定账户
     * @param id 被删除的账户id
     * @return true表示删除成功
     */
    public boolean deleteProductType(Integer id);
    /**
     * 添加产品分类
     * @param producttype
     * @return true表示保存成功，false表示保存失败
     */
    public boolean saveProductType(ProductType producttype);

    /**
     * 判断产品分类是否存在重名（用于创建新产品分类的时候）
     * @param name
     * @return true表示存在，false表示存在
     */
    public boolean existsName(String name);

    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return null表示没有找到
     */
    public ProductType getProductType(Integer id);
    
    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     * @param producttype
     * @return false表示修改失败，true表示修改成功
     */
    public boolean updateProductType(ProductType producttype);
}