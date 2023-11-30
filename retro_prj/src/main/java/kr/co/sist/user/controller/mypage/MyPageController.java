package kr.co.sist.user.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import kr.co.sist.user.domain.MyPageEnterDomain;
import kr.co.sist.user.service.mypage.MyPageInfoDetailService;
import kr.co.sist.user.vo.MyPageIdPwVO;

@Controller
public class MyPageController {
	
	@GetMapping("/mypage_enter.do")
	public String myPageEnterFrm() {
		return "user/user_mypage/user_info_enter";
	}
	
	@PostMapping("/mypage_info.do")
	public String myPageEnter(String id, String pw, Model model) {
		MyPageIdPwVO mpeVO = new MyPageIdPwVO(id, pw);
		
		MyPageEnterDomain mpeDomain = new MyPageInfoDetailService().isEnterable(mpeVO);
		model.addAttribute("userInfo", mpeDomain);
		
		System.out.println("/mypage_info.do :: "+mpeDomain);
		
		return "user/user_mypage/mypage_detail_info";
	}
	
	@GetMapping("/changePw_frm.do")
	public String changePwFrm() {
		return "user/user_mypage/change_pass_frm";
	}
	
	@PostMapping("/change_pw.do")
	public String changePw() {
		
		return "";
	}
}
