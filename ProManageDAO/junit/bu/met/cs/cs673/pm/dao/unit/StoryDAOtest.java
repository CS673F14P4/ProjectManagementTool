package bu.met.cs.cs673.pm.dao.unit;

import junit.framework.TestCase;

import org.junit.Test;


import bu.met.cs.cs673.pm.dao.StoryDAO;
import bu.met.cs.cs673.pm.dto.Story;

/**
 * ProjectDAOTest
 * 
 * 
 * @author Luis Marion
 */
public class StoryDAOTest extends TestCase 
{

	private Story story;
	
	@Override
    protected void setUp() throws Exception
    {
        story = new Story();
        
        story.setTitle("storyTest");
        story.setCreateUser(1);
        story.setId(1);
        story.setPriority(1);
        story.setLastModifiedUser(1);
        story.setLastModifiedDate(new java.util.Date());
        story.setCreateDate(new java.util.Date());
        
    }

	@Test
	public void testCreateProject()
	{
		StoryDAO dao = new StoryDAO();
		int storyId = dao.createStory(story);
		
		System.out.println("id: " + storyId);
		
		assertTrue(storyId > 0);
		
		boolean success = dao.deleteStory(storyId);
		assertTrue(success);
	}
	

	@Test
	public void testGetProject()
	{
		StoryDAO dao = new StoryDAO();
		Story story = dao.getStory(1);
		
		System.out.println("project: " + story.getTitle());
		
		assertNotNull(story);
	}
	
	
}
