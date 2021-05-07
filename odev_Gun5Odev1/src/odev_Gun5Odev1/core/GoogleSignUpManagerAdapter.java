package odev_Gun5Odev1.core;

import odev_Gun5Odev1.business.abstracts.UserService;
import odev_Gun5Odev1.dataAccess.abstracts.IUserDao;
import odev_Gun5Odev1.entities.concretes.User;
import odev_Gun5Odev1.googleSignUp.GoogleSignUpManager;

public class GoogleSignUpManagerAdapter implements UserService{
	
	
	
	private IUserDao userDao;
	
	public GoogleSignUpManagerAdapter(IUserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	public void addUser(User user) {
		GoogleSignUpManager googleSignUpManager = new GoogleSignUpManager();
		this.userDao.add(googleSignUpManager.add());
		
		
		
	}




	
}
