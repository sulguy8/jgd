package com.jgd.test.user;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService us; //	UserService us = new UserServiceImpl(); 이것과 같음.

	@RequestMapping(value = "/user/ajax", method=RequestMethod.GET) // 조회
	public @ResponseBody List<UserVO> getUserList(@ModelAttribute UserVO param){
		
		log.debug("나는 겟! param : {}", param);
		return us.getUserVOList(param);
	}
	
	@RequestMapping(value = "/user/ajax/view", method=RequestMethod.GET) // 조회
	public @ResponseBody List<UserVO> getUser(@ModelAttribute UserVO param){
		log.debug("나는 뷰! param : {}", param);

		return us.getUserList(param);
	}
	
	@RequestMapping(value = "/user/login", method=RequestMethod.POST) // 로그인
	public @ResponseBody UserVO login(@RequestBody UserVO user, HttpSession hs){
		log.debug("나는 로그인! param : {}", user);
		user = us.login(user);
		log.debug("select user : {}", user);
		if(user!=null) {
			hs.setAttribute("user", user);
		}
		return user;
	}
	
	@RequestMapping(value = "/user/ajax", method=RequestMethod.POST) // 인서트
	public @ResponseBody Map<String,String> insertUser(@ModelAttribute UserVO user){
		
		log.debug("insert user : {}", user);
		return us.insertUserInfo(user);
	}
	
	@RequestMapping(value = "/user/ajax", method=RequestMethod.PUT) 
	public @ResponseBody Map<String,String> updateUser(@RequestBody UserVO user){
		
		log.debug("나는 업데이트 user : {}", user);
		return us.updateUserInfo(user);
	}	
	
	@RequestMapping(value = "/user/ajax", method=RequestMethod.DELETE)
	public @ResponseBody Map<String,String> deleteUser(@RequestBody UserVO param){
		log.debug("param : {}", param);
		return us.deleteUserInfo(param);
	}	
	
}
