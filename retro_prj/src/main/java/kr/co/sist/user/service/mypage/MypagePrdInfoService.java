package kr.co.sist.user.service.mypage;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.user.dao.MypagePrdInfoDAO;
import kr.co.sist.user.domain.mypage.MypagePrdDomain;

/**
 * @author marklim
 * 사용자 마이페이지 메인 화면에서 보여지는 상품목록을 검색한다.
 */
@Service
public class MypagePrdInfoService {

	@Autowired
	private MypagePrdInfoDAO mpDAO;
	
	/**
	 * 사용자의 모든 상품을 검색
	 * @param id
	 * @return List&lt;MypagePrdDomain&gt;
	 */
	public List<MypagePrdDomain> searchAllPrd(String id) {
		return mpDAO.selectAllPrd(id);
	}
	
	/**
	 * 판매중인 상품 검색
	 * @param id
	 * @return List&lt;MypagePrdDomain&gt;
	 */
	public JSONObject searchPrdOnProcess(String id) {
		JSONObject jsonObj = new JSONObject();
		List<MypagePrdDomain> list = mpDAO.selectAllPrd(id);
		
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonTemp = null;
		for(MypagePrdDomain mpDomain : list) {
			jsonTemp = new JSONObject();
			jsonTemp.put("pcode", mpDomain.getPcode());
			jsonTemp.put("pname", mpDomain.getPname());
			jsonTemp.put("price", mpDomain.getPrice());
			jsonTemp.put("loc", mpDomain.getLoc());
			jsonTemp.put("input_date", mpDomain.getInput_date());
			
			jsonArr.add(jsonTemp);
		}
		
		jsonObj.put("data", jsonArr);
		jsonObj.put("dataSize", jsonArr.size());
		jsonObj.put("dataFlag", jsonArr.size() > 0 ? true : false);
		
		return jsonObj;
	}
	
	/**
	 * 판매완료한 상품 검색
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject searchCompletedPrd(String id) {
		JSONObject jsonObj = new JSONObject();
		List<MypagePrdDomain> list = mpDAO.selectAllPrd(id);
		
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonTemp = null;
		for(MypagePrdDomain mpDomain : list) {
			jsonTemp = new JSONObject();
			jsonTemp.put("pcode", mpDomain.getPcode());
			jsonTemp.put("pname", mpDomain.getPname());
			jsonTemp.put("price", mpDomain.getPrice());
			jsonTemp.put("loc", mpDomain.getLoc());
			jsonTemp.put("input_date", mpDomain.getInput_date());
			
			jsonArr.add(jsonTemp);
		}
		
		jsonObj.put("data", jsonArr);
		jsonObj.put("dataSize", jsonArr.size());
		jsonObj.put("dataFlag", jsonArr.size() > 0 ? true : false);
		
		return jsonObj;
	}
	
	/**
	 * 예약중인 상품을 검색
	 * @param id
	 * @return JSONObject
	 */
	public JSONObject searchReservationPrd(String id) {
		JSONObject jsonObj = new JSONObject();
		List<MypagePrdDomain> list = mpDAO.selectAllPrd(id);
		
		JSONArray jsonArr = new JSONArray();
		JSONObject jsonTemp = null;
		for(MypagePrdDomain mpDomain : list) {
			jsonTemp = new JSONObject();
			jsonTemp.put("pcode", mpDomain.getPcode());
			jsonTemp.put("pname", mpDomain.getPname());
			jsonTemp.put("price", mpDomain.getPrice());
			jsonTemp.put("loc", mpDomain.getLoc());
			jsonTemp.put("input_date", mpDomain.getInput_date());
			
			jsonArr.add(jsonTemp);
		}
		
		jsonObj.put("data", jsonArr);
		jsonObj.put("dataSize", jsonArr.size());
		jsonObj.put("dataFlag", jsonArr.size() > 0 ? true : false);
		
		return jsonObj;
	}
}
