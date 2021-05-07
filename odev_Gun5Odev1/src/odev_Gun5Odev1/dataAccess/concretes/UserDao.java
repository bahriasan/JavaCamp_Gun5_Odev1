package odev_Gun5Odev1.dataAccess.concretes;

import java.util.Arrays;
import java.util.List;

import odev_Gun5Odev1.dataAccess.abstracts.IUserDao;
import odev_Gun5Odev1.entities.concretes.User;

public class UserDao implements IUserDao{

	@Override
	public void add(User user) {
		System.out.println(user.getFirstName()+" DataBase'e eklendi");
		
	}

	@Override
	public List<User> getAll() {
		// Simulated database return
		List<User> users=Arrays.asList( new User("Bahri","Asan","bahriasan.mh@gmail.com","123456"),
				new User("Tuba","Asan","tubaasan@gmail.com","345678"));
		
		return users ;
	}

	@Override
	public User get(String email) {
		
		User user_ = null;
		
		List<User> users=Arrays.asList(new User("Bahri", "Asan", "bahriasan.mh@gail.com","123456"), 
				new User("Tuba","Asan","tubaasan@gmail.com","345678")); 
		
		for(User user:users) {
			if(user.getEmail()==email) {
				user_=user;
			}
		}
		return user_;
		
	}

	
}
