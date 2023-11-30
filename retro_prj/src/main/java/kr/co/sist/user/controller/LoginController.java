package kr.co.sist.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sist.user.domain.LoginDomain;
import kr.co.sist.user.service.LoginService;
import kr.co.sist.user.vo.LoginVO;
@SessionAttributes({"id","nickname"})
@Controller
public class LoginController {
	
	@GetMapping("/user/login_frm.do")
	public String loginfrm() {
		/*
		 * LoginService ls= LoginService.getInstance();
		 * 
		 * LoginDomain ld= new LoginDomain(); ld=ls.selectLogin(lVO);
		 * 
		 * model.addAttribute("id",ld.getId());
		 * model.addAttribute("nickname",ld.getNickname());
		 */
		
		return "user/login_frm";
	}
	@GetMapping("/user/find_id_frm.do")
	public String findIdFrm() {
		
		return "user/find_id_frm";
	}
	
	@GetMapping("/user/find_pw_frm.do")
	public String findPwFrm() {
		
		return "user/find_pw_frm";
	}
	
	@GetMapping("/user/find_id_success.do")
	public String findIdSuccess() {
		
		return "user/find_id_success";
	}

	@GetMapping("/user/find_pw_success.do")
	public String findpwSuccess() {
		
		return "user/find_pw_success";
	}
	@PostMapping("/user/login_process.do")
	public String loginSuccessProcess(Model model,LoginVO lVO) {
//		LoginVO lVO = new LoginVO();
//		lVO.setId(id);
//		lVO.setPw(pw);
		String url="user/main";
		LoginService ls = LoginService.getInstance();
		LoginDomain ld = ls.selectLogin(lVO);
		System.out.println("----------1123"+url);
		if(ld!=null) {
			model.addAttribute("id", ld.getId());
			model.addAttribute("nickname",ld.getNickname());
			url="user/main";
			System.out.println(url);
		}
	
		return url;
		
		
	}
}
