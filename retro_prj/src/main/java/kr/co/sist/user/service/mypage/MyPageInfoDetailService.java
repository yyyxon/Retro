package kr.co.sist.user.service.mypage;

import org.springframework.stereotype.Service;

import kr.co.sist.user.dao.MyPageInfoDetailDAO;
import kr.co.sist.user.domain.MyPageEnterDomain;
import kr.co.sist.user.domain.mypage.MypageInfoDomain;
import kr.co.sist.user.vo.ChangePwVO;
import kr.co.sist.user.vo.MyPageIdPwVO;

@Service
public class MyPageInfoDetailService {
	
	private MyPageInfoDetailDAO midDAO;
	
	public MyPageEnterDomain isEnterable(MyPageIdPwVO mpeVO) {
		MyPageEnterDomain mpeDomain = null;
		midDAO = new MyPageInfoDetailDAO();
		
		mpeDomain = midDAO.isEnterable(mpeVO);
		
		return mpeDomain;
	}

	public String changePw(ChangePwVO cpVO) {
		String flagMsg = "비밀번호 변경에 실패하였습니다. 다시 시도해주세요.";
		midDAO = new MyPageInfoDetailDAO();
		
		int result = midDAO.updatePw(cpVO);
		if(result == 1) {
			flagMsg = "비밀번호를 성공적으로 변경하였습니다.";
		}
		
		return flagMsg;
	}
	
	public void byebye(String id) {
		midDAO = new MyPageInfoDetailDAO();
		midDAO.updateByeUser(id);
	}
	
	public MypageInfoDomain searchUserInfo(String id) {
		midDAO = new MyPageInfoDetailDAO();
		return midDAO.selectUserInfo(id);
	}
}
