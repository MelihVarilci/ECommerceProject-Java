package ECommerceProject.otherAuths;

import ECommerceProject.bussiness.abstracts.AuthService;

public class GoogleAuthManager implements AuthService {

	@Override
	public void register(int id, String firstName, String lastName, String email, String password) {
		System.out.println("Google ile kayýt alýndý : " + email);
	}

	@Override
	public void login(String email, String password) {
		System.out.println("Google ile giriþ yapýldý : " + email);
	}
}
