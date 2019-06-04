package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerDao {

    /**
     * 返回所有的管理客户集合
     *
     * @return 以List方式返回
     */
    List<Customer> getCustomerList();


    /**
     * 删除指定客户
     * @param id 关键字
     * @return 删除了多少条记录
     */
    int deleteCustomer(Integer id);

    /**
     * 添加客户
     * @param customer
     * @return 添加了多少条记录
     */
    int saveCustomer(Customer customer);

    /**
     * 查找在数据库中和指定客户重名的个数(创建时）
     * @param username
     * @return 返回重名的个数，0表示不重名
     */
    /*int existsName(@Param(value = "name")String name);*/
    int existsUsername(@Param(value = "username")String username);

    /**
     * 查找在数据库中和指定用户名重名的个数(修改时)
     * @param username
     * @param id
     * @return 返回重名的个数，0表示不重名
     */
    int existsCustomer(@Param(value = "username")String username,@Param(value = "id")Integer id);


    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return null表示没有找到
     */
    Customer getCustomer(@Param(value = "id")Integer id);

    /**
     * 修改账户的基本信息
     * @param customer id不能为空
     * @return 更改了多少条记录
     */
    int updateCustomer(Customer customer);
}
