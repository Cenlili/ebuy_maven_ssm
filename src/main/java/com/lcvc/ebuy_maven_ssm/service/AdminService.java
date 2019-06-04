package com.lcvc.ebuy_maven_ssm.service;

import com.lcvc.ebuy_maven_ssm.dao.AdminDao;
import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.util.SHA;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public interface AdminService {

    /**
     * 根据账户名和密码去数据库查询，进行登录判断
     * @param username 账户名
     * @param password 密码
     * @return null表示登录失败
     */
    public Admin login(String username, String password);

    /*
	 * 张三丰
	 * 20180330
	 * 将新密码保存到数据库中
	 * @return true表示密码更改成功，false表示密码更改失败
	 */
    public boolean updatePassword(String newPass,Integer id);


    /**
     * 修改账户的基本信息
     * 说明：
     * 1、修改后的账户名不能与其他账户的账户名重名
     * @param admin
     * @return false表示修改失败，true表示修改成功
     */
    public boolean updateAdmin(Admin admin);

    /**
     * 查找在数据库中和指定用户名重名的个数（用于账户创建时）
     * @param username
     * @param id
     * @return true表示存在重名账户，false表示不存在
     */
    public boolean existsAdmin(String username,Integer id);

    /**
     * 返回所有的管理账户集合
     * @return 以List方式返回
     */
    public List<Admin> getAdminList();

    /**
     * 删除指定账户
     * @param id 被删除的账户id
     *@param adminId 执行删除的管理账户
     * @return true表示删除成功
     */
    public boolean deleteAdmin(Integer id,Integer adminId);

    /**
     * 判断账户名是否存在（用于创建新账户的时候）
     * @param username
     * @return true表示存在，false表示存在
     */
    public boolean existsUsername(String username);

    /**
     * 添加管理员信息
     * @param admin
     * @return true表示保存成功，false表示保存失败
     */
    public boolean saveAdmin(Admin admin);

    /**
     * 根据标识符获取对应的管理账户对象
     * @param id
     * @return null表示没有找到
     */
    public Admin getAdmin(Integer id);
}