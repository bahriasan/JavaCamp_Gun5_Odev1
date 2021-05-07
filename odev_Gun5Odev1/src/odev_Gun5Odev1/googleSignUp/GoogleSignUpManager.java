package odev_Gun5Odev1.googleSignUp;

import odev_Gun5Odev1.entities.concretes.User;

public class GoogleSignUpManager {
	
	public User add() {
		User user = new User("Tuba", "Asan", "tubaasan@gmail.com","123456");
		System.out.println(user.getFirstName()+" Ýsimli Kullanýcý Google ile Eklendi");
		return user;
	}

}
