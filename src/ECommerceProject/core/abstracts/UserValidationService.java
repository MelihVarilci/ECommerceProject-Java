package ECommerceProject.core.abstracts;

import ECommerceProject.entities.concretes.User;

public interface UserValidationService {
	boolean registerValidate(User user);

	boolean loginValidate(String email, String password);
}
