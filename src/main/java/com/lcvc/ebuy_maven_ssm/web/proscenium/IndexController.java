package com.lcvc.ebuy_maven_ssm.web.proscenium;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/proscenium")
public class IndexController {


    /*
     * 显示登录页面，该登录页面是使用Ajax进行登录
     */
    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String toIndex() {
        return "/jsp/proscenium/index.jsp";
    }
}
