package kr.co.sist.user.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.co.sist.user.domain.MyInquiryDomain;
import kr.co.sist.user.service.MyInquiryService;

@Controller
public class MyInquiryController {
	@GetMapping("/user/inquiry/inquiry_frm.do")
	public String inquery_frm(Model model, HttpSession hs) {
		List<MyInquiryDomain> list = null;
		String id = hs.getId();
		//로그인 후 아이디 가져와야함.
		//System.out.println("--------"+hs.getId());
		MyInquiryService mis= MyInquiryService.getInstance();
		list = mis.searchInquiry("tuna51277");
		
		model.addAttribute("inquiryList", list);
		
		return "user/inquiry/inquiry_frm";
	}
	
	@GetMapping("/user/inquiry/inquiry_detail_frm.do")
	public String inquery_detail_frm(Model model, HttpSession hs, String iCode) {
		List<MyInquiryDomain> list = null;
		String id = hs.getId();
		//로그인 후 아이디 가져와야함.
		//System.out.println("--------"+hs.getId());
		MyInquiryService mis= MyInquiryService.getInstance();
		list = mis.searchInquiry("tuna51277");
		
		model.addAttribute("inquiryList", list);
		
		return "user/inquiry/inquiry_frm";
	}

}
