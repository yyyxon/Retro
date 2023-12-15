package kr.co.sist.user.controller.sales;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sist.user.service.sales.SalesService;

@Controller
public class SalesController {

	@Autowired
	private SalesService sService;
	
	@GetMapping("/user_sales_frm.do")
	public String userSalesFrm(HttpSession session, Model model) {
		model.addAttribute("saleList", sService.searchAllSales((String)session.getAttribute("id")));
		
		return "user_sales_frm";
	}
}
