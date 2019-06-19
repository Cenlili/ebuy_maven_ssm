package com.lcvc.ebuy_maven_ssm.web.proscenium;

import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.service.ProductService;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

@Controller
public class IndexController {

    @Resource
    private ProductTypeService productTypeService;

    @Resource
    private ProductService productService;


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
}
