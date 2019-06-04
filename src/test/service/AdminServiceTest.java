package service;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.service.AdminService;
import com.lcvc.ebuy_maven_ssm.test.SpringJunitTest;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

public class AdminServiceTest extends SpringJunitTest {
    @Resource
    private AdminService adminService;

    @Test
    public void testLogin(){
        System.out.println(adminService.login("user","123456"));
    }


    @Test
    public void testSaveAdmin(){
        Admin admin=new Admin();
        admin.setUsername("user23");
        admin.setPassword("123");
        admin.setName("灭霸");
        admin.setCreateTime(new Date());
        System.out.println(adminService.saveAdmin(admin));
    }
}
