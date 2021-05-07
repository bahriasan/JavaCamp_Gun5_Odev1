package odev_Gun5Odev1.business.concretes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import odev_Gun5Odev1.business.abstracts.UserService;
import odev_Gun5Odev1.business.abstracts.UserVerificationService;
import odev_Gun5Odev1.dataAccess.abstracts.IUserDao;
import odev_Gun5Odev1.entities.concretes.User;

public class UserManager implements UserService {
	
	private UserVerificationService userVerificationManager;
	private IUserDao userDao;

	public UserManager(UserVerificationService userVerificationManager, IUserDao userDao) {
		this.userVerificationManager=userVerificationManager;
		this.userDao=userDao;
	}
	
	@Override
	public void addUser(User user) {
		//Ýþ Kurallarý
		if(user.getPassword().length()>=6) {//Parola en az 6 karakterden oluþmalýdýr.
			
			Pattern p= Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
			Matcher m=p.matcher(user.getEmail());
			if(m.find()){//E-posta alaný e-posta formatýnda olmalýdýr
				
				for(User _user:userDao.getAll()) {
					if (_user.getEmail()==user.getEmail()){//E-Posta daha önce kullanýlmamýþ olmalýdýr.
						System.out.println("Bu Email Önceden Kullanýlmýþ");
						return;
					}
				}
			
			if(user.getFirstName().length()>=2) {//Ad ve soyad en az iki karakterden oluþmalýdýr.
				
				if(user.getLastName().length()>=2) {//Ad ve soyad en az iki karakterden oluþmalýdýr.
						
						if (this.userVerificationManager.verify(user)) {//Üyelik sonucu kullanýcýya doðrulama e-postasý gönderilmelidir.
							System.out.println("Kullanýcý Bilgileri Doðrulandý");
							this.userDao.add(user); //Doðrulama linki týklandýðýnda üyelik tamamlanmalýdýr.
							
						}else {System.out.println("Doðrulama yapýlamadý");}
					}else {System.out.println("Soyisim en az 2 haneli olmalý");}
				}else {System.out.println("Ýsim en az 2 haneli olmalý");}
			}else {System.out.println("Hatalý email Formatý");}
		}else {System.out.println("Parola En az 6 haneli olmalý");}
		
	}
	
	
	
	

}
