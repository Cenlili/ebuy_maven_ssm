package com.lcvc.ebuy_maven_ssm.web.backstage.product;

import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ProductController {
    @Resource
    private ProductService productService;


    @RequestMapping(value = "backstage/product/toProductPage", method = RequestMethod.GET)
    public String toProductPage(Model model,Integer page) {
        if (page==null){//如果page为null,默认为第一页
            page=1;
        }else {
            if (page<1){
                page=1;
            }else{
                if (page>2){
                    page=2;
                }
            }
        }
        model.addAttribute("list",productService.getProductList(page));
        model.addAttribute("page",page);
        model.addAttribute("maxPage",productService.maxPage());
        return "/jsp/backstage/productmanage/productmanage.jsp";
    }

    //跳转到产品管理页面
    @RequestMapping(value = "backstage/product/toManageProduct", method = RequestMethod.GET)
    public String toManageProduct(HttpServletRequest request) {
        request.setAttribute("list", productService.getProductList());
        return "/jsp/backstage/productmanage/productmanage.jsp";
    }

    //执行删除产品操作
    @ResponseBody
    @RequestMapping(value = "/backstage/product/doDeleteProduct", method = RequestMethod.GET)
    public Map<String,Object> doDeleteProduct(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
             productService.deleteProduct(id);
       map.put("status",1);
       return map;
        }

    //跳转到产品分类添加页面
    @RequestMapping(value = "/backstage/product/toAddProduct", method = RequestMethod.GET)
    public String toAddProduct(HttpServletRequest request){

        return "/jsp/backstage/productmanage/productadd.jsp";
    }


    //执行产品分类添加请求
    @RequestMapping(value = "/backstage/product/doAddProduct", method = RequestMethod.POST)
    public String doAddProduct(Model model, Product product){
        product.setName(product.getName().trim());
        if(product.getName().length()==0){
            model.addAttribute("myMessage","产品创建失败:产品名称不能为空");
      }else if(productService.existsName(product.getName())){
            model.addAttribute("myMessage","产品创建失败:产品名称已存在，请选择其他的产品名");
        }else{
            if(productService.saveProduct(product)){
                model.addAttribute("myMessage","产品创建成功");
            }else{
                model.addAttribute("myMessage","产品创建失败");
            }
        }
        return "/jsp/backstage/productmanage/productadd.jsp";
    }

    //跳转到产品分类编辑页面
    @RequestMapping(value = "/backstage/product/toUpdateProduct", method = RequestMethod.GET)
    public String toUpdateProduct(HttpServletRequest request,Integer id){
        request.setAttribute("product",productService.getProduct(id));
        return "/jsp/backstage/productmanage/productupdate.jsp";
    }

    //执行产品分类编辑请求
    @RequestMapping(value = "/backstage/product/doUpdateProduct", method = RequestMethod.POST)
    public String doUpdateProductType(HttpServletRequest request,Product product){
        product.setName(product.getName().trim());
        if(product.getName().length()==0){
            request.setAttribute("myMessage","产品名称修改失败:产品名称不能为空");
        }else if (product.getPicUrl().length()==0) {
            request.setAttribute("myMessage", "产品名称修改失败:必须上传图片");
        }else{
            if(productService.updateProduct(product)){
                request.setAttribute("myMessage","产品名称修改成功");
            }else{
                request.setAttribute("myMessage","产品名称修改失败");
            }
        }

        return "/jsp/backstage/productmanage/productupdate.jsp";
    }
}





