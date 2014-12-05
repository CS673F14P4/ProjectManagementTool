package bu.met.cs.cs673.pm.dao.unit;

import java.util.List;

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
	
	@Test
	public void testGetUserByProject(){
		UserDAO dao = new UserDAO();
		List<User> userByProject = dao.getUserByProject(1);
		for (User user : userByProject) {
			System.out.println(user.getUserId());
		}
		assertNotNull(userByProject);
	}
}
