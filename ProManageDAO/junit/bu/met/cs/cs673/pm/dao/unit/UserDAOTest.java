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

	private User userTest;
	
	@Override
    protected void setUp() throws Exception
    {
		userTest = new User();
        
		userTest.setUsername("usertest");
		userTest.setFirstname("testfname");
		userTest.setLastname("testlname");
        userTest.setEmail("testemail@email.com");
        userTest.setPassword("7d4b83b002a19d46725716874d17391d2278cd2557cb9744ea9404cb3d90a78ad803331a0de27cb9cba4eaaa72f87503c790721cf7c471c2a119375b9300506a"); //xmen
    }
	
	@Test
	public void testGetUser()
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
	
	@Test
	public void testInsertUser()
	{
		UserDAO dao = new UserDAO();
		int id = dao.insert(userTest);
		
		System.out.println("insertedUser: " + id);
		assertTrue(id > 0);
		
		dao.delete(userTest.getUsername());
	}
	
	@Test
	public void testDeleteUser()
	{
		UserDAO dao = new UserDAO();
		int id = dao.insert(userTest);
		
		System.out.println("insertedUser: " + id);
		assertTrue(id > 0);
		
		dao.delete(userTest.getUsername());
		
		User user = dao.getUserByName(userTest.getUsername());
		assertNull(user);
		
	}
}
