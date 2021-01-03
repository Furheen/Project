package cdt.com.Backend.DAO;

import cdt.com.Backend.model.UserDetails;

public interface UserDAO {
	public boolean registerUser(UserDetails userDetail);
	public boolean updateUser(UserDetails userDetail);
	public UserDetails getUser(String username);
}
