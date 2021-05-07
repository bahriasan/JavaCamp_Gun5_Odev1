package odev_Gun5Odev1.business.concretes;

import odev_Gun5Odev1.business.abstracts.UserSignInService;
import odev_Gun5Odev1.dataAccess.abstracts.IUserDao;
import odev_Gun5Odev1.entities.concretes.User;

public class UserSignInManager implements UserSignInService {
	
	private IUserDao userDao;
	
	public UserSignInManager(IUserDao userDao) {
		this.userDao=userDao;
	}
	
	@Override
	public void signIn(String email, String password) {
		
		//1.Metod
		
		for(User user:userDao.getAll()) {
			if(user.getEmail()==email) {
				if(user.getPassword()==password) {
					System.out.println(userDao.get(email).getFirstName()+": Giriþ Yapýldý");
					return;
				}else {
					System.out.println("Parola Hatalý");
					return;
				}
			}
		}
		System.out.println("Baþarýsýz Giriþ: Email Hatalý");
		
		
		//2.Metod
		
		if(userDao.get(email)==null) {
			System.out.println("Bu email Kayýtlý Deðil");
		}else if(userDao.get(email).getPassword()==password) {
			System.out.println(userDao.get(email).getFirstName()+": Giriþ Yapýldý");
		} else {
			System.out.println("Hatalý Parola");
		}
		
	}


		




}
