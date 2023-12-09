package kr.co.sist.user.controller.mypage;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.user.domain.mypage.MypagePrdDomain;
import kr.co.sist.user.service.mypage.MypagePrdInfoService;

@Controller
public class MypagePrdInfoController {
	
	@Autowired
	private MypagePrdInfoService mpiService;

	/**
	 * 마이페이지 메인화면 호출
	 * @param session
	 * @param id
	 * @return jsp명
	 */
	@ResponseBody
	@GetMapping("/")
	public String mypageMainFrm(HttpSession session, String id, Model model) {
		List<MypagePrdDomain> list = mpiService.searchAllPrd(id);
		model.addAttribute("allPrd", list);
		
		return "user/user_mypage/user_mypage_frm";
	}
	
	@ResponseBody
	@GetMapping("/mypage_prd_onsale.do")
	public String ajaxSearchOnProcess(HttpSession session, String id) {
		JSONObject jsonObj = mpiService.searchPrdOnProcess(id);
		return jsonObj.toJSONString();
	}
	
	@ResponseBody
	@GetMapping("/mypage_prd_completed.do")
	public String ajaxSearchCompleted(HttpSession session, String id) {
		JSONObject jsonObj = mpiService.searchCompletedPrd(id);
		return jsonObj.toJSONString();
	}
	
	@ResponseBody
	@GetMapping("/mypage_prd_reservation.do")
	public String ajaxSearchReservation(HttpSession session, String id) {
		JSONObject jsonObj = mpiService.searchReservationPrd(id);
		return jsonObj.toJSONString();
	}
}
