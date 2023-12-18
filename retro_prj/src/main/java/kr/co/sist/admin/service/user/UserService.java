package kr.co.sist.admin.service.user;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.sist.admin.dao.user.UserDAO;
import kr.co.sist.admin.domain.user.UserDomain;

@Service
public class UserService {

	@Autowired
	private UserDAO uDAO;
	
	public List<UserDomain> seachUserList() {
		return uDAO.selectAllUser();
	}
	
	public UserDomain searchOneUser(String id) {
		return uDAO.selectOneUser(id);
	}
	
	public JSONObject UserStatusChange(String id) {
		JSONObject json = new JSONObject();
		json.put("flag", uDAO.updateUserStatus(id) == 1 ? true : false);
		
		return json;
	}
	
	public JSONObject UserWithdraw(String id) {
		JSONObject json = new JSONObject();
		json.put("flag", uDAO.updateUser(id) == 1 ? true : false);

		return json;
	}
}
