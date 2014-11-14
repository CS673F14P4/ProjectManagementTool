
package bu.met.cs.cs673.pm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



import bu.met.cs.cs673.pm.dto.Story;

/*
 * 
 * Daniel Abramowitz
 * Last edit 10/15/2015
 */
public class StoryDAO {
	
	public int createStory(Story story)
	{
		int success = -1;
		
		if (story == null)
		{
			success = -1;
		}
		else
		{
			SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
			SqlSession session = factory.openSession();
			
			try 
			{
				success = session.insert("createStory", story);
				session.commit();
			} 
			finally 
			{
			  session.close();
			}
		}
	
	
		if (success > 0)
		{
			success = story.getIdstory();
		}
		
		return success;
	
	
}
	//retrieves story at certain value
	public Story getStory(int id)
	{
		Story selected=null;
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try 
		{
			selected = session.selectOne("getStory", id);
			session.commit();
		} 
		finally 
		{
		  session.close();
		}
		
		return selected;
	}
	
	//should remove specific story
	public boolean deleteStory(int id)
	{
		int deleted=-1;
		boolean delete=false;
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		
		
		try 
		{
			deleted = session.delete("deleteStory", id);
			session.commit();
		} 
		finally 
		{
		  session.close();
		}
		if(deleted>0)
			delete=true;
		
		return delete;
	}

	//Should return list of stories by project id#
	public List<Story> storyByProject(int idproject) {
		List<Story> storyList=null; 
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try
		{
			storyList= session.selectList("storyByProject", idproject);
		}
		finally
		{
			session.close();
		}
		return storyList;
	}

	
}

