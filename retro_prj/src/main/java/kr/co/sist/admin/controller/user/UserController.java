package kr.co.sist.admin.controller.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.admin.service.user.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService uService;
	
	@GetMapping("/user_list.do")
	public String userList(Model model) {
		model.addAttribute("userList", uService.seachUserList());
		
		return "admin/usermng/user_list";
	}
	
	@GetMapping("/member_detail.do")
	public String userDetail(Model model, String userId) {
		model.addAttribute("userData", uService.searchOneUser(userId));
		
		return "admin/usermng/user_detail";
	}
	
	@ResponseBody
	@PostMapping("/user_withdraw.do")
	public String userWithdraw(String userId) {
		return uService.UserWithdraw(userId).toJSONString();
	}
	
	@ResponseBody
	@PostMapping("/user_status_change.do")
	public String userStatusChange(String userId) {
		return uService.UserStatusChange(userId).toJSONString();
	}
}
