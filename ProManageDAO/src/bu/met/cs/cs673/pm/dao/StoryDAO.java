package bu.met.cs.cs673.pm.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import bu.met.cs.cs673.pm.dto.Story;

/*
 * 
 * Daniel Abramowitz
 * Last edit 10/15/2015
 */
public class StoryDAO {
	
	public int createProject(Story story)
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
				success = session.insert("insertStory", story);
				session.commit();
			} 
			finally 
			{
			  session.close();
			}
		}
	
	
		if (success > 0)
		{
			success = story.getId();
		}
		
		return success;
	
	
}
	
	public Story getProject(int id)
	{
		Story selected=null;
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try 
		{
			selected = session.selectOne("selectStory", id);
			session.commit();
		} 
		finally 
		{
		  session.close();
		}
		
		return selected;
	}
	
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
}
