package com.lcvc.ebuy_maven_ssm.service.Impl;

import com.lcvc.ebuy_maven_ssm.dao.ProductDao;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceIpml implements ProductService{
    @Resource
    private ProductDao productDao;

    /**
     * 返回所有的产品分类管理
     * @return 以List方式返回
     */
    @Override
    public List<Product> getProductList(){
        return productDao.getProductList();
    }

    /**
     * 删除指定账户
     * @param id 被删除的账户id
     * @return true表示删除成功
     */
    @Override
    public boolean deleteProduct(Integer id){
        boolean status=false;//存储修改结果
        int n=productDao.deleteProduct(id);
        if(n==1){
            status=true;
        }
        return status;
    }

    /**
     * 添加产品分类
     * @param product
     * @return true表示保存成功，false表示保存失败
     */
    @Override
    public boolean saveProduct(Product product){
        boolean judge=false;
        int i=productDao.saveProduct(product);
        if(i>0){
            judge=true;
        }
        return judge;
    }
    /**
     * 判断产品是否存在重名（用于创建新产品的时候）
     * @param name
     * @return true表示存在，false表示存在
     */
    @Override
    public boolean existsName(String name){
        if(productDao.existsName(name)==0){
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
    @Override
    public Product getProduct(Integer id){
        Product product=null;
        if(id!=null){
            product=productDao.getProduct(id);
        }
        return product;
    }

    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     * @param product
     * @return false表示修改失败，true表示修改成功
     */
    @Override
    public boolean updateProduct(Product product){
        boolean status=false;//存储修改结果
        if(productDao.existsProduct(product.getName(),product.getId())==0){//如果不重名
            if(productDao.updateProduct(product)==1){
                status=true;
            }else{
                status=false;
            }
        }
        return status;
    }
    @Override
    public List<Product> getProductList(Integer page){
        int pagesize=10;//每页显示10条记录
        int offset=(page-1)*pagesize+1;//每页开始的记录数位置（仅在业务层使用，不考虑数据库）
        return  productDao.getPartlist(offset-1,pagesize);//数据库记录位置从0算起
    }
    @Override
    public int maxPage(){
        int maxPage=0;
        int pagesize=10;
        int total=productDao.total();
        if (total%pagesize==0){
            maxPage=total/pagesize;
        }else{
            maxPage=total/pagesize+1;
        }
        return maxPage;
    }
    @Override
    public List<Product> getNewTopProductList(Integer pageSize){
        return productDao.getNewTopProductList(8);
    }

    @Override
    public List<Product> getHotProductList(Integer pageSize){
        return productDao.getHotProductList(8);
    }

    @Override
    public List<Product> getProductByid(Integer id) {
        return productDao.getProductByid(id);
    }

    @Override
    public List<Product> getProductTypeList(Integer id){
        return productDao.getProductTypeList(id);
    }


}
