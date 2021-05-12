package ECommerceProject;

import ECommerceProject.bussiness.abstracts.AuthService;
import ECommerceProject.bussiness.abstracts.UserService;
import ECommerceProject.bussiness.concretes.AuthManager;
import ECommerceProject.bussiness.concretes.UserManager;
import ECommerceProject.core.concretes.UserValidationManager;
import ECommerceProject.core.verifications.EmailVerificationManager;
import ECommerceProject.dataAccess.concretes.HibernateUserDao;
import ECommerceProject.otherAuths.GoogleAuthManager;

public class Main {

	public static void main(String[] args) {
		UserService userService = new UserManager(new HibernateUserDao());

		AuthService authService = new AuthManager(userService, new UserValidationManager(),
				new EmailVerificationManager());

		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓REGİSTER↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		authService.register(1, "Melih", "Varılcı", "varilci.melih@gmail.com", "123456"); // BAŞARILI
		System.out.println("\n###########################################################\n");
		authService.register(2, "Melih", "Varılcı", "varilci", "123456"); // Başarısız E-POSTA
		System.out.println("\n###########################################################\n");
		authService.register(3, "Melih", "Varılcı", "melih.varilci@gmail.com", "1234"); // Başarısız Şifre
		System.out.println("\n###########################################################\n");
		authService.register(4, "M", "V", "mlh.vrlc@gmail.com", "1234"); // Başarısız Şifre
		System.out.println("\n###########################################################\n");
		authService.register(5, "Melih", "Varılcı", "varilci.melih@gmail.com", "123456"); // E-Posta MEVCUT

		System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓LOGİN↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
		authService.login("varilci.melih@gmail.com", "123456");// Başarılı
		System.out.println("\n###########################################################\n");
		authService.login("mlh.vrlc@gmail.com", "1234567"); // Kullanıcı Mevcut Değil
		System.out.println("\n###########################################################\n");
		authService.login("", ""); // Başarısız e-posta ve parola zorunlu

		AuthService googleAuthService = new GoogleAuthManager();
		googleAuthService.register(6, "Melih", "Varılcı", "varilci.melih@gmail.com", "123456"); // BAŞARILI
		System.out.println("\n###########################################################\n");
		googleAuthService.login("varilci.melih@gmail.com", "123456");

	}

}
