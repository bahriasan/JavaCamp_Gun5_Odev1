package odev_Gun5Odev1.business.concretes;

import odev_Gun5Odev1.business.abstracts.UserVerificationService;
import odev_Gun5Odev1.entities.concretes.User;

public class UserVerificationManager implements UserVerificationService{

	@Override
	public boolean verify(User user) {
		System.out.println(user.getEmail()+" adresine do�rulama kodu g�nderildi.");
		return  true;
		
	}

}
