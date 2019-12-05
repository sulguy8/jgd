package com.jgd.test.user;

import java.util.List;

public interface UserDAO {
	public List<UserVO> selectUserList(UserVO param);
	public List<UserVO> selectUserVOList(UserVO param);
	public int insertUserInfo(UserVO user);
	public int updateUserInfo(UserVO user);
	public int deleteUserInfo(UserVO user);
	public UserVO selectUserInfo(UserVO user);
}
