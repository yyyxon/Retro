package kr.co.sist.user.service.mypage;

import kr.co.sist.user.dao.EnterMyPageInfoDAO;
import kr.co.sist.user.domain.MyPageEnterDomain;
import kr.co.sist.user.vo.MyPageIdPwVO;

public class MyPageInfoDetailService {
	
	public MyPageEnterDomain isEnterable(MyPageIdPwVO mpeVO) {
		MyPageEnterDomain mpeDomain = null;
		
		mpeDomain = EnterMyPageInfoDAO.getInstance().isEnterable(mpeVO);
		
		return mpeDomain;
	}

}
