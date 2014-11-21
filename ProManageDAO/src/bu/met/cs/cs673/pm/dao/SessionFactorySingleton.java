package bu.met.cs.cs673.pm.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * @author Luis Marion
 */
public class SessionFactorySingleton 
{

	private static SessionFactorySingleton INSTANCE;
	private static SqlSessionFactory sqlSessionFactory;
	
	private SessionFactorySingleton()
	{

	}
	
	private static SqlSessionFactory createSessionFactory()
	{
		SqlSessionFactory sqlSessionFactory = null;
		
		try
		{
			String resource = "properties/mybatis-local-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
	
	public static SessionFactorySingleton getInstance()
	{
		if (INSTANCE == null)
		{
			INSTANCE = new SessionFactorySingleton();
			sqlSessionFactory = createSessionFactory();
		}
		
		return INSTANCE;
	}
	
	public SqlSessionFactory getSqlSessionFactory()
	{
		return sqlSessionFactory;
	}
}
