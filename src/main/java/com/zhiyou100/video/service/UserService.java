package com.zhiyou100.video.service;

import java.util.List;

import com.zhiyou100.video.model.User;

public interface UserService {

	void registUser(User u);

	List<User> findExistUser(User u);

	void updateUser(User u);

	User findUserById(User u);

	void updateImg(User u);

	List<User> findUserByPassWord(User user);

	List<User> findEmail(User user);

	void updateUserByCaptcha(User user);

	List<User> findUserByEamilAndCaptcha(User u);

	void updateUserPwd(User u);

}
