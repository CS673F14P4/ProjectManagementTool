package bu.met.cs.cs673.pm.util;

import bu.met.cs.cs673.pm.dao.UserDAO;
import bu.met.cs.cs673.pm.dto.User;

/**
 * UserUtil
 * 
 * Utilities class for users
 * 
 * @author Luis Marion
 */
public class UserUtil 
{
	/**
	 * getUserId
	 * 
	 * Helper method that returns the userid given the username. 
	 * 
	 * TODO: currently this is going to the db each time, this should likely just be cached,
	 * or the lazy way would be to use username as the PK in the db.
	 * 
	 * @param username
	 * @return
	 */
	public static int getUserId(String username)
	{
		UserDAO dao = new UserDAO();
		User user = dao.getUserByName(username);
		
		int userId = user.getUserId();
		
		return userId;
	}
}
