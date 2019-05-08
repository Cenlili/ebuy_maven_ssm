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
public class ProductTypeService {
    @Resource
    private ProductTypeDao productTypeDao;

    /**
     * 返回所有的产品分类管理
     * @return 以List方式返回
     */
    public List<ProductType> getProductTypeList(){
        return productTypeDao.getProductTypeList();
    }

    /**
     * 删除指定账户
     * @param id 被删除的账户id
     * @return true表示删除成功
     */
    public boolean deleteProductType(Integer id){
        boolean status=false;//存储修改结果
                int n=productTypeDao.deleteProductType(id);
                if(n==1){
                    status=true;
                }
        return status;
    }

    /**
     * 添加产品分类
     * @param producttype
     * @return true表示保存成功，false表示保存失败
     */
    public boolean saveProductType(ProductType producttype){
        boolean judge=false;
        int i=productTypeDao.saveProductType(producttype);
        if(i>0){
            judge=true;
        }
        return judge;
    }

    /**
     * 判断产品分类是否存在重名（用于创建新产品分类的时候）
     * @param name
     * @return true表示存在，false表示存在
     */
    public boolean existsName(String name){
        if(productTypeDao.existsName(name)==0){
            return false;
        }else{
            return true;
        }
    }


    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return null表示没有找到
     */
    public ProductType getProductType(Integer id){
        ProductType producttype=null;
        if(id!=null){
            producttype=productTypeDao.getProductType(id);
        }
        return producttype;
    }
    
    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     * @param producttype
     * @return false表示修改失败，true表示修改成功
     */
    public boolean updateProductType(ProductType producttype){
        boolean status=false;//存储修改结果
        if(productTypeDao.existsProductType(producttype.getName(),producttype.getId())==0){//如果不重名
            if(productTypeDao.updateProductType(producttype)==1){
                status=true;
            }else{
                status=false;
            }
        }
        return status;
    }
}