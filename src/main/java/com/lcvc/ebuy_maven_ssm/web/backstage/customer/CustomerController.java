package com.lcvc.ebuy_maven_ssm.web.backstage.customer;

import com.lcvc.ebuy_maven_ssm.model.Customer;
import com.lcvc.ebuy_maven_ssm.model.Product;
import com.lcvc.ebuy_maven_ssm.model.ProductType;
import com.lcvc.ebuy_maven_ssm.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CustomerController {
	@Resource
	private CustomerService customerService;

	//跳转到管理员管理页面
	@RequestMapping(value = "/backstage/customer/toManageCustomer", method = RequestMethod.GET)
	public String toManageCustomer(HttpServletRequest request) {
		request.setAttribute("list", customerService.getCustomerList());
		return "/jsp/backstage/customermanage/customermanage.jsp";
	}

	//执行删除产品分类操作
	@RequestMapping(value = "/backstage/customer/doDeleteCustomer", method = RequestMethod.GET)
	public String doDeleteCustomer(HttpServletRequest request, HttpSession session, Integer id) {
		Customer customer = (Customer) session.getAttribute("customer");
		customerService.deleteCustomer(id);
		request.setAttribute("list", customerService.getCustomerList());
		return "/jsp/backstage/customermanage/customermanage.jsp";
	}

	//跳转到产品分类添加页面
	@RequestMapping(value = "/backstage/customer/toAddCustomer", method = RequestMethod.GET)
	public String toAddCustomer(HttpServletRequest request) {
		return "/jsp/backstage/customermanage/customeradd.jsp";
	}


	//执行产品分类添加请求
	@RequestMapping(value = "/backstage/customer/doAddCustomer", method = RequestMethod.POST)
	public String doAddCustomer(HttpServletRequest request, Customer customer) {
		customer.setUsername(customer.getUsername().trim());
		customer.setName(customer.getName().trim());
		if (customer.getUsername().length() == 0) {
			request.setAttribute("myMessage", "客户创建失败:客户名不能为空");
		} else if (customer.getName().length() == 0) {
			request.setAttribute("myMessage", "客户创建失败:姓名不能为空");
		} else if (customerService.existsUsername(customer.getUsername())) {
			request.setAttribute("myMessage", "客户创建失败:客户名已存在，请选择其他的客户名");
			if (customerService.saveCustomer(customer)) {
				request.setAttribute("myMessage", "客户创建成功");
			} else {
				request.setAttribute("myMessage", "客户创建失败");
			}
		}
		return "/jsp/backstage/customermanage/customeradd.jsp";
	}

	//跳转到产品分类编辑页面
	@RequestMapping(value = "/backstage/customer/toUpdateCustomer", method = RequestMethod.GET)
	public String toUpdateCustomer(HttpServletRequest request, Integer id) {
		request.setAttribute("customer", customerService.getCustomer(id));
		return "/jsp/backstage/customermanage/customerupdate.jsp";
	}

	//执行产品分类编辑请求
	@RequestMapping(value = "/backstage/customer/doUpdateCustomer", method = RequestMethod.POST)
	public String doUpdateCustomer(HttpServletRequest request, Customer customer) {
		customer.setUsername(customer.getUsername().trim());
		if (customer.getUsername().length() == 0) {
			request.setAttribute("myMessage", "客户修改失败:客户名不能为空");
			} else if (customerService.existsUsername(customer.getUsername())) {
				request.setAttribute("myMessage", "客户账户名修改失败:客户账户名已存在，请选择其他的客户名");
			} else {
				if (customerService.updateCustomer(customer)) {
					request.setAttribute("myMessage", "客户修改成功");
				} else {
					request.setAttribute("myMessage", "客户名称修改失败");
				}
			}

			return "/jsp/backstage/customermanage/customerupdate.jsp";
		}
	}



