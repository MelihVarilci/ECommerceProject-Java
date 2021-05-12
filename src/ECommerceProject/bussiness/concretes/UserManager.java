package ECommerceProject.bussiness.concretes;

import java.util.List;

import ECommerceProject.bussiness.abstracts.UserService;
import ECommerceProject.dataAccess.abstracts.UserDao;
import ECommerceProject.entities.concretes.User;

public class UserManager implements UserService {
	UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		userDao.add(user);
		System.out.println("Kullanıcı başarılı bir şekilde oluşturulmuştur.");
	}

	@Override
	public void update(User user) {
		userDao.update(user);
		System.out.println("Kullanıcı bilgileri güncellendi.");
	}

	@Override
	public void delete(User user) {
		userDao.delete(user);
		System.out.println("Kullanıcı silindi.");
	}

	@Override
	public User getById(int id) {
		return userDao.getById(id);

	}

	@Override
	public User getByMail(String email) {
		return userDao.getByMail(email);
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		return userDao.getByEmailAndPassword(email, password);
	}

	@Override
	public List<User> getAll() {
		return userDao.getAll();
	}
}
