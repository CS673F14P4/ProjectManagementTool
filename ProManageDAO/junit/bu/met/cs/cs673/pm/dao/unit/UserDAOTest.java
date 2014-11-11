package bu.met.cs.cs673.pm.dao.unit;

import junit.framework.TestCase;

import org.junit.Test;

import bu.met.cs.cs673.pm.dao.UserDAO;
import bu.met.cs.cs673.pm.dto.User;

/*
 * Olufemi Odegbile
 */

public class UserDAOTest extends TestCase {


	@Test
	public void testGetProject()
	{
		UserDAO dao = new UserDAO();
		User user = dao.getUserByName("cyclops");
		
		System.out.println("user: " + user.getUsername() + "  " + user.getUserId());
		assertNotNull(user);
	}
}
