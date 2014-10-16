package bu.met.cs.cs673.pm.dao.unit;

import bu.met.cs.cs673.pm.dto.Project;
import bu.met.cs.cs673.pm.dto.Story;
import junit.framework.TestCase;

public class StoryDAOtest extends TestCase {
	
	private Story test;
	 
	protected void setUp() throws Exception
	    {
	        test = new Story();
	        
	        test.setTitle("unitTestProject");
	        test.setDescription("This is a unit test project");
	        test.setCreateUser(1);
	        test.setLastModifiedUser(1);
	    }

}
