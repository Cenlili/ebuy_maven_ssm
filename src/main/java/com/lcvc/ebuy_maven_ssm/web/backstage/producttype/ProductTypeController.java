package com.lcvc.ebuy_maven_ssm.web.backstage.producttype;

import com.lcvc.ebuy_maven_ssm.model.Admin;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.ProductTypeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ProductTypeController {
    @Resource
    private ProductTypeService productTypeService;

    //跳转到产品分类管理页面
    @RequestMapping(value = "backstage/producttype/toManageProductType", method = RequestMethod.GET)
    public String toManageProductType(HttpServletRequest request) {
        request.setAttribute("list", productTypeService.getProductTypeList());
        return "/jsp/backstage/producttype/producttypemanage.jsp";
    }

    //执行删除产品分类操作
    @RequestMapping(value = "/backstage/producttype/doDeleteProductType", method = RequestMethod.GET)
    public String doDeleteProductType(HttpServletRequest request, HttpSession session, Integer id) {
        ProductType producttype = (ProductType) session.getAttribute("producttype");
        productTypeService.deleteProductType(id);
        request.setAttribute("list", productTypeService.getProductTypeList());
        return "/jsp/backstage/producttype/producttypemanage.jsp";
    }

    //跳转到产品分类添加页面
    @RequestMapping(value = "/backstage/producttype/toAddProductType", method = RequestMethod.GET)
    public String toAddProductType(HttpServletRequest request){
        return "/jsp/backstage/producttype/producttypeadd.jsp";
    }


    //执行产品分类添加请求
    @RequestMapping(value = "/backstage/producttype/doAddProductType", method = RequestMethod.POST)
    public String doAddProductType(HttpServletRequest request,ProductType producttype){
        producttype.setName(producttype.getName().trim());
        if(producttype.getName().length()==0){
            request.setAttribute("myMessage","产品分类创建失败:账户名不能为空");
        }else if(producttype.getName().length()==0){
            request.setAttribute("myMessage","产品分类创建失败:姓名不能为空");
        }else if(productTypeService.existsName(producttype.getName())){
            request.setAttribute("myMessage","产品分类创建失败:分类名已存在，请选择其他的分类名");
        }else{
            if(productTypeService.saveProductType(producttype)){
                request.setAttribute("myMessage","产品分类创建成功");
            }else{
                request.setAttribute("myMessage","产品分类创建失败");
            }
        }
        return "/jsp/backstage/producttype/producttypeadd.jsp";
    }

    //跳转到产品分类编辑页面
    @RequestMapping(value = "/backstage/producttype/toUpdateProductType", method = RequestMethod.GET)
    public String toUpdateProductType(HttpServletRequest request,Integer id){
        request.setAttribute("producttype",productTypeService.getProductType(id));
        return "/jsp/backstage/producttype/producttypeupdate.jsp";
    }

    //执行产品分类编辑请求
    @RequestMapping(value = "/backstage/producttype/doUpdateProductType", method = RequestMethod.POST)
    public String doUpdateProductType(HttpServletRequest request,ProductType producttype){
        producttype.setName(producttype.getName().trim());
        if(producttype.getName().length()==0){
            request.setAttribute("myMessage","产品分类修改失败:分类名不能为空");
        }else if(productTypeService.existsName(producttype.getName())){
            request.setAttribute("myMessage","产品分类修改失败:分类名不能重名");
        }else{
            if(productTypeService.updateProductType(producttype)){
                request.setAttribute("myMessage","产品分类修改成功");
            }else{
                request.setAttribute("myMessage","产品分类修改失败");
            }
        }

        return "/jsp/backstage/producttype/producttypeupdate.jsp";
    }
}


