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
		//�� Kurallar�
		if(user.getPassword().length()>=6) {//Parola en az 6 karakterden olu�mal�d�r.
			
			Pattern p= Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",Pattern.CASE_INSENSITIVE);
			Matcher m=p.matcher(user.getEmail());
			if(m.find()){//E-posta alan� e-posta format�nda olmal�d�r
				
				for(User _user:userDao.getAll()) {
					if (_user.getEmail()==user.getEmail()){//E-Posta daha �nce kullan�lmam�� olmal�d�r.
						System.out.println("Bu Email �nceden Kullan�lm��");
						return;
					}
				}
			
			if(user.getFirstName().length()>=2) {//Ad ve soyad en az iki karakterden olu�mal�d�r.
				
				if(user.getLastName().length()>=2) {//Ad ve soyad en az iki karakterden olu�mal�d�r.
						
						if (this.userVerificationManager.verify(user)) {//�yelik sonucu kullan�c�ya do�rulama e-postas� g�nderilmelidir.
							System.out.println("Kullan�c� Bilgileri Do�ruland�");
							this.userDao.add(user); //Do�rulama linki t�kland���nda �yelik tamamlanmal�d�r.
							
						}else {System.out.println("Do�rulama yap�lamad�");}
					}else {System.out.println("Soyisim en az 2 haneli olmal�");}
				}else {System.out.println("�sim en az 2 haneli olmal�");}
			}else {System.out.println("Hatal� email Format�");}
		}else {System.out.println("Parola En az 6 haneli olmal�");}
		
	}
	
	
	
	

}
