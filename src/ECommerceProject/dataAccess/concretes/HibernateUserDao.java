package ECommerceProject.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ECommerceProject.dataAccess.abstracts.UserDao;
import ECommerceProject.entities.concretes.User;

public class HibernateUserDao implements UserDao {
	List<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Hibarnate ile eklendi " + user.getFirstName());

	}

	@Override
	public void update(User user) {
		User userToUpdate = getById(user.getId());
		userToUpdate.setFirstName(user.getFirstName());
		userToUpdate.setLastName(user.getLastName());

	}

	@Override
	public void delete(User user) {
		users.removeIf(usr -> usr.getId() == user.getId());
	}

	@Override
	public User getById(int id) {
		for (User user : users) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	@Override
	public User getByMail(String email) {
		for (User user : users) {
			if (user.getEmail() == email)
				return user;
		}
		return null;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		for (User user : users) {
			if (user.getEmail() == email && user.getPassword() == password)
				return user;
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}
}
