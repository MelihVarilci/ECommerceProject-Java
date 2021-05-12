package ECommerceProject.bussiness.concretes;

import ECommerceProject.bussiness.abstracts.AuthService;
import ECommerceProject.bussiness.abstracts.UserService;
import ECommerceProject.core.abstracts.UserValidationService;
import ECommerceProject.core.verifications.VerificationService;
import ECommerceProject.entities.concretes.User;

public class AuthManager implements AuthService {
	UserService userService;
	UserValidationService userValidationService;
	VerificationService verificationService;

	public AuthManager() {

	}

	public AuthManager(UserService userService, UserValidationService userValidationService,
			VerificationService verificationService) {
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.verificationService = verificationService;
	}

	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		User userToRegister = new User(id, firstName, lastName, email, password);

		if (!this.userValidationService.registerValidate(userToRegister)) {
			System.out.println("Kullanıcı bilgilerinizi kontrol ediniz!");
			return;
		}

		if (!checkIfUserExists(email)) {
			System.out.println("Kayıt olma işlemi başarsız. Bu email ile bir başka üye mevcut.");
			return;
		}

		if (!this.verificationService.verificate(userToRegister)) {
			System.out.println("Doğrulama işlemi iptal edildi.");
		}

		userService.add(userToRegister);
	}

	@Override
	public void login(String email, String password) {

		if (!this.userValidationService.loginValidate(email, password)) {
			System.out.println("Kullanıcı bilgilerinizi kontrol ediniz!");
			return;
		}

		User userToLogin = userService.getByEmailAndPassword(email, password);

		if (userToLogin == null) {
			System.out.println("Girii başarısız. E-Posta veya şifre bilginiz yanlış.");
			return;
		}

		if (!checkIfUserVerified(userToLogin)) {
			System.out.println("Giriş başarısız. Üyeliğinizi doğrulamadınız.");
			return;
		}

		System.out
				.println("Giriş başarılı. Hoşgeldiniz " + userToLogin.getFirstName() + " " + userToLogin.getLastName());

	}

	private boolean checkIfUserExists(String email) {
		return this.userService.getByMail(email) == null;
	}

	private boolean checkIfUserVerified(User user) {
		return user.isVerified();
	}
}
