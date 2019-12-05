package com.jgd.test.user;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO udao;
	
	public List<UserVO> getUserList(UserVO param) {

		return udao.selectUserList(param);
	}
	
	public List<UserVO> getUserVOList(UserVO param){
		return udao.selectUserVOList(param);
	}

	public Map<String, String> insertUserInfo(UserVO user) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("cnt", udao.insertUserInfo(user)+"");
		return rMap;
	}

	public Map<String, String> updateUserInfo(UserVO user) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("cnt", udao.updateUserInfo(user)+"");
		return rMap;
	}

	public Map<String, String> deleteUserInfo(UserVO user) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("cnt", udao.deleteUserInfo(user)+"");
		return rMap;
	}

	@Override
	public UserVO login(UserVO user) {
		return udao.selectUserInfo(user);
	}
	
}
