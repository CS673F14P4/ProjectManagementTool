package bu.met.cs.cs673.pm.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisConnectionFactoryUser {
	
	private static MyBatisConnectionFactoryUser INSTANCE;
	private static SqlSessionFactory sqlSessionFactory;
	
	private MyBatisConnectionFactoryUser()
	{

	}
	
	private static SqlSessionFactory createSessionFactory()
	{
		SqlSessionFactory sqlSessionFactory = null;
		
		try
		{
			String resource = "bu/met/cs/cs673/pm/dao/mapper/Myconfig.xml";
			Reader inputStream = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			System.out.println("Ok");
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
		}
		
		return sqlSessionFactory;
	}
	
	public static MyBatisConnectionFactoryUser getInstance()
	{
		if (INSTANCE == null)
		{
			INSTANCE = new MyBatisConnectionFactoryUser();
			sqlSessionFactory = createSessionFactory();
		}
		
		return INSTANCE;
	}
	
	public SqlSessionFactory getSqlSessionFactory()
	{
		return sqlSessionFactory;
	}
	
}
