package odev_Gun5Odev1;

import odev_Gun5Odev1.business.abstracts.UserService;
import odev_Gun5Odev1.business.abstracts.UserSignInService;
import odev_Gun5Odev1.business.concretes.UserManager;
import odev_Gun5Odev1.business.concretes.UserSignInManager;
import odev_Gun5Odev1.business.concretes.UserVerificationManager;
import odev_Gun5Odev1.core.GoogleSignUpManagerAdapter;
import odev_Gun5Odev1.dataAccess.concretes.UserDao;
import odev_Gun5Odev1.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		//SignUp new User Manually
		User user1 = new User("Bahri", "Asan","bahriasan@gmail.com","123456");
		UserService userManager1 = new UserManager(new UserVerificationManager(), new UserDao());
		userManager1.addUser(user1);
		
		System.out.println("***************************************");
		
		//SignUp with Google Account
		UserService userManager2 = new GoogleSignUpManagerAdapter(new UserDao());
		userManager2.addUser(null);
		
		System.out.println("***************************************");
		
		//SignIn
		UserSignInService userSignIn = new UserSignInManager(new UserDao());
		userSignIn.signIn("tubaasan@gmail.com","345678");
	}

}
