package kr.co.sist.user.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.co.sist.common.dao.MybatisHandler;
import kr.co.sist.user.domain.ProductDomain;
import kr.co.sist.user.vo.ProductVO;

public class ProductDAO {

	private static ProductDAO pDAO;
	private String configPath;

	private ProductDAO() {
		configPath = "kr/co/sist/common/dao/mybatis-config.xml";
	}

	public static ProductDAO getInstance() {
		if (pDAO == null) {
			pDAO = new ProductDAO();
		} // end if
		return pDAO;
	}// getInstance

	/**
	 * 카테고리 검색
	 * @return
	 * @throws PersistenceException
	 */
	public int addProduct(ProductVO pVO) throws PersistenceException {
		int result= 0;

		MybatisHandler mbh=MybatisHandler.getInstance();
		SqlSession ss=mbh.getMyBatisHandler(configPath, false);
		result=ss.insert("user.product.insertProduct",pVO);
		
		mbh.closeHandler(ss);
			
		return result;
	}//selectCategory
	
	public static void main(String[] args) {
		ProductDAO pd=ProductDAO.getInstance();
		ProductVO pVO=new ProductVO();
		pVO.setC3code("C102");
		pVO.setContext("안녕하세요");
		pVO.setDeliver("N");
		pVO.setId("1011kiy111");
		pVO.setLoc("자양동");
		pVO.setPcode("P00039");
		pVO.setPname("롱치마");
		pVO.setPrice(10000);
		pVO.setStatus("S");
		pd.addProduct(pVO);
	}//main


}// class
