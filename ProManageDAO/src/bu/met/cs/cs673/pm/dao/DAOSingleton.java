package bu.met.cs.cs673.pm.dao;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 
 * Deprecating this class. Use SessionFactorySingleton instead.
 * 
 * @author Luis Marion
 */
@Deprecated
public class DAOSingleton 
{

	private static DAOSingleton INSTANCE;
	private static SqlSessionFactory sqlSessionFactory;
	
	private DAOSingleton()
	{

	}
	
	private static SqlSessionFactory createSessionFactory()
	{
		SqlSessionFactory sqlSessionFactory = null;
		
		try
		{
			//String resource = "ProManageDAO/resources/properties/mybatis-local-config.xml";
			String resource = "bu/met/cs/cs673/pm/dao/mapper/Myconfig.xml";
			//String resource = "com/vaibhav/mybatis/xml/config.xml";
			//InputStream inputStream = Resources.getResourceAsStream(resource);
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
	
	public static DAOSingleton getInstance()
	{
		if (INSTANCE == null)
		{
			INSTANCE = new DAOSingleton();
			sqlSessionFactory = createSessionFactory();
		}
		
		return INSTANCE;
	}
	
	public SqlSessionFactory getSqlSessionFactory()
	{
		return sqlSessionFactory;
	}
	
	public static void main(String[] args) {
			// TODO Auto-generated method stub
		
		SqlSessionFactory factory = DAOSingleton.getInstance().getSqlSessionFactory();
	}
}
