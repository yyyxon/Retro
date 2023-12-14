package kr.co.sist.user.service;

import java.util.List;

import kr.co.sist.user.dao.MyInquiryDAO;
import kr.co.sist.user.domain.MyInquiryDomain;

public class MyInquiryService {
	private static MyInquiryService mIs;
	
	private MyInquiryService() {
		
	}
	
	public static MyInquiryService getInstance() {
		if(mIs==null) {
			mIs = new MyInquiryService();
		}
		return mIs;
	}
	
	public List<MyInquiryDomain> searchInquiry(String id) {
		List<MyInquiryDomain> list =null;
		MyInquiryDAO miDAO = MyInquiryDAO.getInstance();
		list = miDAO.selectInquiry(id);
		return list;
	}
	
}
