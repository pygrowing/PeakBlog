package com.pygrow.xblog.myblog.repository;
/**
* @author E先生
* @version 创建时间：2018年7月9日 下午5:42:59
* @ClassName 用户的接口
* @Description 类描述
*/

import java.util.List;

import com.pygrow.xblog.myblog.entity.User;

public interface UserRepository {

	User saveOrUpdateUser(User user);
	
	void deleteUser(int id);
	
	User getUserById(int id);
	
	List<User> listUser();
}
