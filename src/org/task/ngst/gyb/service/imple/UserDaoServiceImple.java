package org.task.ngst.gyb.service.imple;

import java.util.List;

import org.task.ngst.gyb.dao.imple.UserDaoImple;
import org.task.ngst.gyb.entity.User;
import org.task.ngst.gyb.service.UserDaoService;

public class UserDaoServiceImple implements UserDaoService{
	
	private static UserDaoImple udi = null; 
	static{
		udi = new UserDaoImple();
	}
	
	@Override
	public void addUser(User u) {
		// TODO Auto-generated method stub
		udi.insertUser(u);
	}

	@Override
	public void modifyUser(User u) {
		// TODO Auto-generated method stub
		udi.updateUser(u);
	}

	@Override
	public void deleteUser(Integer id) {
		// TODO Auto-generated method stub
		udi.deleteUser(id);
	}

	@Override
	public User getUserById(Integer uid) {
		// TODO Auto-generated method stub
		User u = udi.queryUserById(uid);
		return u;
	}

	@Override
	public List<User> getUserByName(String name) {
		// TODO Auto-generated method stub
		return udi.queryUserByName(name);
	}

	@Override
	public List<User> getUserByClass(String uclass) {
		// TODO Auto-generated method stub
		return udi.queryUserByClass(uclass);
	}

	@Override
	public List<User> getryUserByGrade(Integer ugrade) {
		// TODO Auto-generated method stub
		return udi.queryUserByGrade(ugrade);
	}

	@Override
	public List<User> getUserByCategory(Integer ucategory) {
		// TODO Auto-generated method stub
		return udi.queryUserByCategory(ucategory);
	}

	@Override
	public List<User> getUserBySex(String usex) {
		// TODO Auto-generated method stub
		return udi.queryUserBySex(usex);
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return udi.queryAllUser();
	}

}
