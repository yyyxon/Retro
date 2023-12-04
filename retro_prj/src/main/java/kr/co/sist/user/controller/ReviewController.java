package kr.co.sist.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewController {
	
	@GetMapping("/purchase_review_write.do")
	public String addBuyComment() {
		return "/user/review/user_purchase_review";
	}

}
