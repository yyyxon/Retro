package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.common.dao.MybatisHandler;
import kr.co.sist.login.dao.LoginDAO;
import kr.co.sist.login.domain.LoginDomain;
import kr.co.sist.login.vo.LoginVO;
import kr.co.sist.user.domain.MyInquiryDomain;

public class MyInquiryDAO {
	private static MyInquiryDAO miDAO;
	private static String configPath;
	
	private MyInquiryDAO() {
		configPath="kr/co/sist/common/dao/mybatis-config.xml";
	}
	
	
	public static MyInquiryDAO getInstance() {
		if(miDAO==null) {
			miDAO= new MyInquiryDAO();
		}
		
		return miDAO;
	}//getInstance
	
public List<MyInquiryDomain> selectInquiry(String id)throws PersistenceException {
		List<MyInquiryDomain> list=null;
		MyInquiryDomain mId = new MyInquiryDomain();
		MybatisHandler mbh= MybatisHandler.getInstance();
		SqlSession ss= mbh.getMyBatisHandler(configPath, false);
		list=ss.selectList("kr.co.sist.inquiry.selectInquiry", id);
		
		mbh.closeHandler(ss);
		
		return list;
	}//selectLogin
}
