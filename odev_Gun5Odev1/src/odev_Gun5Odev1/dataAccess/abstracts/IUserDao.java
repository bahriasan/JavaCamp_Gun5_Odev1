package odev_Gun5Odev1.dataAccess.abstracts;

import java.util.List;

import odev_Gun5Odev1.entities.concretes.User;

public interface IUserDao {
	void add(User user);
	
	List<User> getAll();
	
	User get(String email);

}
