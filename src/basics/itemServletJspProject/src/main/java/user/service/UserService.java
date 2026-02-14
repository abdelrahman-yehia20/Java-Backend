package user.service;

import user.model.User;

public interface UserService {
	
	boolean createUser(User user);
	User login (String email, String password);
	User getUserByEmail(String email);

}
