package com.lcvc.ebuy_maven_ssm.service;


import com.lcvc.ebuy_maven_ssm.dao.CustomerDao;
import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;


    /**
     * 返回所有的管理账户集合
     *
     * @return 以List方式返回
     */
    public List<Customer> getCustomerList() {
        return customerDao.getCustomerList();
    }


    /**
     * 删除指定客户
     *
     * @param id 被删除的客户id
     * @return true表示删除成功
     */
    public boolean deleteCustomer(Integer id) {
        boolean status = false;//存储修改结果
        int n = customerDao.deleteCustomer(id);
        if (n == 1) {
            status = true;
        }
        return status;
    }

    /**
     * 添加产品分类
     *
     * @param customer
     * @return true表示保存成功，false表示保存失败
     */
    public boolean saveCustomer(Customer customer) {
        boolean judge = false;
        int i = customerDao.saveCustomer(customer);
        if (i > 0) {
            judge = true;
        }
        return judge;
    }

    /**
     * 判断客户姓名是否存在重名（用于创建新产品的时候）
     *
     * @param name
     * @return true表示存在，false表示存在
     */
  /*  public boolean existsName(String name) {
        if (customerDao.existsName(name) == 0) {
            return false;
        } else {
            return true;
        }
    }*/

    /**
     * 判断客户账户名是否存在重名（用于创建新产品的时候）
     *
     * @param username
     * @return true表示存在，false表示存在
     */
    public boolean existsUsername(String username) {
        if (customerDao.existsUsername(username) == 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 根据标识符获取对应的管理客户对象
     *
     * @param id
     * @return null表示没有找到
     */
    public Customer getCustomer(Integer id){
        Customer customer=null;
        if(id!=null){
            customer=customerDao.getCustomer(id);
        }
        return customer;
    }


    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     * @param customer
     * @return false表示修改失败，true表示修改成功
     */
    public boolean updateCustomer(Customer customer){
        boolean status=false;//存储修改结果
        if(customerDao.existsCustomer(customer.getUsername(),customer.getId())==0){//如果不重名
            if(customerDao.updateCustomer(customer)==1){
                status=true;
            }else{
                status=false;
            }
        }
        return status;
    }
}


