package com.lcvc.ebuy_maven_ssm.dao;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AdminDao {
    /**
     * 根据账户名和密码去数据库查询
     * @param username 账户名
     * @param password 密码
     * @return null表示没有找到记录
     */
    Admin login(@Param(value = "username") String username, @Param(value = "password") String password);

    /*
	 * 张三丰
	 * 20180330
	 * 将新密码保存到数据库中
	 * @return 更改了多少条记录
	 */
    int updatePassword(@Param(value = "password")String newPass,@Param(value = "id")Integer id);


    /**
     * 修改账户的基本信息
     * @param admin id不能为空
     * @return 更改了多少条记录
     */
    int updateAdmin(Admin admin);


    /**
     * 查找在数据库中和指定用户名重名的个数(修改时)
     * @param username
     * @param id
     * @return 返回重名的个数，0表示不重名
     */
    int existsAdmin(@Param(value = "username")String username,@Param(value = "id")Integer id);

    /**
     * 查找在数据库中和指定用户名重名的个数(创建时）
     * @param username
     * @return 返回重名的个数，0表示不重名
     */
    int existsUsername(@Param(value = "username")String username);


    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    List<Admin> getAdminList();

    /**
     * 删除指定账户
     * @param id 关键字
     * @return 删除了多少条记录
     */
    int deleteAdmin(Integer id);

    /**
     * 添加管理员信息
     * @param admin
     * @return 添加了多少条记录
     */
    int saveAdmin(Admin admin);

    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return null表示没有找到
     */
    Admin getAdmin(int id);
}
