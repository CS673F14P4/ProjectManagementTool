package bu.met.cs.cs673.pm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import bu.met.cs.cs673.pm.dto.User;

/*
 * Olufemi Odegbile
 */

public class UserDAO {

	/**
	 * Returns the list of all User instances from the database.
	 * 
	 * @return the list of all User instances from the database.
	 */

	public List<User> selectAll() {
		List<User> list = null;
		SqlSessionFactory factory = SessionFactorySingleton.getInstance()
				.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		try {
			list = session.selectList("User.selectAll");
		} finally {
			session.close();
		}

		if (list.isEmpty()) {
			System.out.println("There is no user");
		} else {
			int i = 1;
			while (i <= list.size()) {
				System.out.println("User ID: " + list.get(i - 1).getUserId()
						+ "  Email: " + list.get(i - 1).getEmail()
						+ "  Username: " + list.get(i - 1).getUsername()
						+ "  User firstname: " + list.get(i - 1).getFirstname()
						+ "  User lastname: " + list.get(i - 1).getLastname());
				i++;
			}
		}
		return list;
	}

	/**
	 * Insert an instance of Person into the database.
	 * 
	 * @param person
	 *            the instance to be persisted.
	 */

	public int insert(User user) {
		int id = -1;
		SqlSessionFactory factory = SessionFactorySingleton.getInstance()
				.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		try {
			id = session.insert("User.insert", user);
		} finally {
			session.commit();
			session.close();
		}
		return id;
	}

	/**
	 * Delete an instance of User from the database.
	 * 
	 * @param id
	 *            value of the instance to be deleted.
	 */
	public void delete(String username) {

		SqlSessionFactory factory = SessionFactorySingleton.getInstance()
				.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		try {
			session.delete("User.delete", username);
		} finally {
			session.commit();
			session.close();
		}
	}

	/**
	 * Update an instance of User into the database.
	 * 
	 * @param person
	 *            the instance to be persisted.
	 */
	public void update(User user) {
		int id = -1;
		SqlSessionFactory factory = SessionFactorySingleton.getInstance()
				.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		try {
			id = session.update("User.update", user);

		} finally {
			session.commit();
			session.close();
		}
	}

	/**
	 * Select instance of User from the database.
	 * 
	 * @param person
	 *            the instance to be persisted.
	 */
	public User getUserByName(String username) {
		User user = null;

		SqlSessionFactory factory = SessionFactorySingleton.getInstance()
				.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		try {
			user = (User) session.selectOne("selectByName", username);

		} finally {
			session.close();
		}
		return user;
	}

	/**
	 * Return a list of users that are members of a project
	 * 
	 * @param idproject
	 *            the project id
	 * @return
	 */
	public List<User> getUserByProject(int idproject) {
		
		List<User> userList = null; 
		
		SqlSessionFactory factory = SessionFactorySingleton.getInstance().getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		try
		{
			userList= session.selectList("getUserByProject", idproject);
		}
		finally
		{
			session.close();
		}
		return userList;
	}
}
