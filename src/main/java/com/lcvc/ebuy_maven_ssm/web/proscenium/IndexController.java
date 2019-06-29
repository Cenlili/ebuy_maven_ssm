package com.lcvc.ebuy_maven_ssm.web.proscenium;

import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.service.CustomerService;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Resource
    private ProductTypeService productTypeService;

    @Resource
    private ProductService productService;

    @Resource
    private CustomerService customerService;


    /*
	 * 用于判断登录
	 */
    @ResponseBody
    @RequestMapping(value = "/proscenium/doLogin", method = RequestMethod.POST)
    public Map<String,Object> doLogin(String username, String password, HttpSession session) {
        Map<String,Object> map=new HashMap<String,Object>();
        Customer customer=customerService.login(username,password);
        if(customer!=null){
            session.setAttribute("customer", customer);
            map.put("status",1);//	自定义值：status。如果为1表示登录成功，若干为0表示登录失败
        }else{
            map.put("status",0);//	自定义值：status。如果为1表示登录成功，若干为0表示登录失败
            //return "/jsp/backstage/login.jsp";
            map.put("myMessage","登录失败，密码错误");
        }
        return  map;
    }

    @RequestMapping(value = "/proscenium/toProductTypePage", method = RequestMethod.GET)
    public String toProductTypePage(Model model,Integer page) {
        if (page==null){//如果page为null,默认为第一页
            page=1;
        }else {
            if (page<1){
                page=1;
            }
        }

        model.addAttribute("productTypes",productService.getProductTypePage(page));
        model.addAttribute("page",page);
        model.addAttribute("maxPage",productService.maxPage());
        return "/jsp/shop/shoplists.jsp";
    }

    /*
     * 显示登录页面，该登录页面是使用Ajax进行登录
     */
    @RequestMapping(value = "/proscenium/toIndex", method = RequestMethod.GET)
    public String toIndex(Model model) {
        model.addAttribute("productType",productTypeService.getProductTypeList());
        model.addAttribute("newProducts",productService.getNewTopProductList(8));
        model.addAttribute("hotProducts",productService.getHotProductList(8));
        return "jsp/shop/index.jsp";
    }

    @RequestMapping(value = "/proscenium/toDetailProduct", method = RequestMethod.GET)
    public String toDetailProduct(Model model,Integer id) {
        model.addAttribute("detailProduct",productService.getProductByid(id));
        return "jsp/shop/shopdetial.jsp";
    }

    @RequestMapping(value = "/proscenium/toProductType", method = RequestMethod.GET)
    public String toProductType(Model model,Integer id) {
        model.addAttribute("productTypes",productService.getProductTypeList(id));
        model.addAttribute("productTypesed",productTypeService.getProductType(id));
        return "jsp/shop/shoplists.jsp";
    }

    @RequestMapping(value = "/proscenium/toNewShop", method = RequestMethod.GET)
    public String toNewShop(Model model) {
        model.addAttribute("newShops",productService.getNewTopProductList(8));
        return "jsp/shop/shopnew.jsp";
    }

    @RequestMapping(value = "/proscenium/toHotShop", method = RequestMethod.GET)
    public String toHotShop(Model model) {
        model.addAttribute("hotShops",productService.getHotProductList(8));
        return "jsp/shop/shophot.jsp";
    }

    //注册页面
    @RequestMapping(value = "/proscenium/toLogon", method = RequestMethod.GET)
    public String toLogon(){
        return "/jsp/shop/signup.jsp";
    }
    @RequestMapping(value = "/proscenium/doLogon", method = RequestMethod.POST)
    public String doLogon(Model model,String username, Customer customer) {
        Customer customer1=new Customer();
        customer1.setCreateTime(new Date());
        if (customer.getUsername().trim().length()==0) {
            model.addAttribute("myMessage", "账户名不能为空，请重新输入 ");
        }else if(customer.getPassword().trim().length()==0) {
            model.addAttribute("myMessage", "密码不能为空，请重新输入");
        }  else if(customer.getTel().trim().length()==0){
            model.addAttribute("myMessage","联系方式不能为空，请重新输入");
        } else if (customerService.existsUsername(customer.getUsername())) {
            model.addAttribute("myMessage", "账户名不能重名，请重新输入");
        } else {
            customerService.saveCustomer(customer);
            model.addAttribute("myMessage", "注册成功！！！");
        }
        return "/jsp/shop/signup.jsp";
    }



}

