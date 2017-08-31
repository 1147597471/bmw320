package com.zhiyou100.video.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.video.mapper.UserMapper;
import com.zhiyou100.video.model.User;
import com.zhiyou100.video.model.UserExample;
import com.zhiyou100.video.service.UserService;
import com.zhiyou100.video.utils.MailUtil;
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper um;
	@Override
	public void registUser(User u) {
		um.insert(u);
		
	}
	@Override
	public List<User> findExistUser(User u) {
		UserExample ex = new UserExample();
		ex.createCriteria().andEmailEqualTo(u.getEmail()).andPasswordEqualTo(u.getPassword());
		return um.selectByExample(ex);
	}
	@Override
	public void updateUser(User u) {
		um.updateByPrimaryKeySelective(u);
		
	}
	@Override
	public User findUserById(User u) {
		return um.selectByPrimaryKey(u.getId());
	}
	@Override
	public void updateImg(User u) {
		um.updateByPrimaryKeySelective(u);
	}
	@Override
	public List<User> findUserByPassWord(User user) {
		UserExample ex = new UserExample();
		ex.createCriteria().andPasswordEqualTo(user.getPassword()).andIdEqualTo(user.getId());
		return um.selectByExample(ex);
	}
	@Override
	public List<User> findEmail(User user) {
		UserExample ex = new UserExample();
		ex.createCriteria().andEmailEqualTo(user.getEmail());
		return um.selectByExample(ex);
	}
	@Override
	public void updateUserByCaptcha(User user) {
		try {
			MailUtil.send("1147597471@qq.com","密码验证",user.getCaptcha());
		} catch (Exception e) {
			e.printStackTrace();
		}
		UserExample ex = new UserExample();
		ex.createCriteria().andEmailEqualTo(user.getEmail());
		um.updateByExampleSelective(user, ex);
	}
	@Override
	public List<User> findUserByEamilAndCaptcha(User u) {
		UserExample ex = new UserExample();
		ex.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
		return um.selectByExample(ex);
	}
	@Override
	public void updateUserPwd(User u) {
		UserExample ex = new UserExample();
		ex.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
		um.updateByExampleSelective(u, ex);
	}

}
