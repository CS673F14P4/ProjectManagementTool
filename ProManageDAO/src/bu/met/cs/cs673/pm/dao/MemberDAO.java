package bu.met.cs.cs673.pm.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bu.met.cs.cs673.pm.dto.Member;

/**
 * 
 * @author Luis Marion
 */
public class MemberDAO 
{

	public int insertMember(Member member)
	{
		int success = -1;
		
		if (member != null)
		{
			SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
			SqlSession session = factory.openSession();
				
			try 
			{
				success = session.insert("insertMember", member);
				session.commit();
			} 
			finally 
			{
			  session.close();
			}
		}
	
		return success;
	}
	
	public int deleteMember(Member member)
	{
		int success = -1;
		
		if (member != null)
		{
			SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
			SqlSession session = factory.openSession();
				
			try 
			{
				success = session.delete("deleteMember", member);
				session.commit();
			} 
			finally 
			{
			  session.close();
			}
		}
	
		return success;
	}

	public Member getMember(Member searchMember)
	{
		Member member = new Member();
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try 
		{
			member = (Member) session.selectOne("getMember", searchMember);
		} 
		finally 
		{
		  session.close();
		}
		
		return member;
	}
	
}
