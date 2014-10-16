package bu.met.cs.cs673.pm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



//import com.hmkcode.vo.Person;
import java.sql.Timestamp;
import java.util.Date;
import bu.met.cs.cs673.pm.dto.User;

public class UserDAO {
	
	private SqlSessionFactory sqlSessionFactory = null;
	 
    public UserDAO(){
    	
    }
    
    /**
     * Returns the list of all User instances from the database.
     * @return the list of all User instances from the database.
     */
    
    @SuppressWarnings("unchecked")
    public  List<User> selectAll(){
        List<User> list = null;
        SqlSessionFactory factory = MyBatisConnectionFactoryUser.getInstance().getSqlSessionFactory();
        SqlSession session = factory.openSession();
 
        try {
            list = session.selectList("User.selectAll");
        } finally {
            session.close();
        }
        
        if (list.isEmpty()){
        	System.out.println("There is no user");
        } else {
        	int i = 1;
        	while (i <= list.size()){
        		System.out.println("User ID: " + list.get(i-1).getUserId() + "  Email: " + list.get(i-1).getEmail()
        				+ "  Username: " + list.get(i-1).getUsername() + "  User firstname: " + list.get(i-1).getFirstname()
        				+ "  User lastname: " + list.get(i-1).getLastname());
        		i++;
        	}
        }
        return list;
    }

    
    /**
     * Insert an instance of Person into the database.
     * @param person the instance to be persisted.
     */
    
    public int insert(User user){
        int id = -1;
        SqlSessionFactory factory = MyBatisConnectionFactoryUser.getInstance().getSqlSessionFactory();
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
     * @param id value of the instance to be deleted.
     */
    public void delete(String username){
    	 
    	SqlSessionFactory factory = MyBatisConnectionFactoryUser.getInstance().getSqlSessionFactory();
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
     * @param person the instance to be persisted.
     */
      public void update(User user){
         int id = -1;
         SqlSessionFactory factory = MyBatisConnectionFactoryUser.getInstance().getSqlSessionFactory();
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
       * @param person the instance to be persisted.
       */
      public User selectById(String username){
          User user = null;
          
          SqlSessionFactory factory = MyBatisConnectionFactoryUser.getInstance().getSqlSessionFactory();
          SqlSession session = factory.openSession();
          try {
              user = (User) session.selectOne("User.selectById", username);
   
          } finally {
              session.close();
          }
          return user;
      }
      

	public static void main(String[] args) {
		
		/* How to insert user into the table
		///User femi = new User(1002, "ffemgodim2@gmail.com", "ffemgodim2", "2234", "OOlufemi", "OOdegbile");
		//User femi = new User(1002, "ffemgodim2@gmail.com", "ffemgodim2", "2234", "OOlufemi", "OOdegbile", new Timestamp(date.getTime()));
		Date date = new Date();
		User femi = new User(1003, "fffemgodim2@gmail.com", "fffemgodim2", "3234", "Olufemii", "Odegbilee", new Timestamp(date.getTime()));
		
		SqlSessionFactory factory = MyBatisConnectionFactoryUser.getInstance().getSqlSessionFactory();
		int id = new UserDAO(MyBatisConnectionFactoryUser.getInstance().getSqlSessionFactory()).insert(femi);
		/*/
		
		/*How to delete user in the table
		String usernameToDelete = "ffemgodim2";
		new UserDAO(MyBatisConnectionFactoryUser.getInstance().getSqlSessionFactory()).delete(usernameToDelete);
		*/
		
		/*How to update user profile
		 User femi = new User(1002, "ffemgodim2@gmail.com", "ffemgodim2", "2234", "OUOolufemi", "OOodegbile");
		new UserDAO(MyBatisConnectionFactoryUser.getInstance().getSqlSessionFactory()).update(femi);
		//*/
		
		//*How to select one user from table
		String usernameToSelect= "fffemgodim2";
		 User femi = new UserDAO().selectById(usernameToSelect);
		 if (femi == null){
	          System.out.println("Such username does not exist: "+usernameToSelect);
		 } else {
			 System.out.println("Such username does exist: "+usernameToSelect);
		 }
		// */
		
		/*How to print all users in the table
		
		 //List list = new UserDAO(MyBatisConnectionFactoryUser.getInstance().getSqlSessionFactory()).selectAll();
		 List list = new UserDAO().selectAll();
	     	System.out.println("The number of users: "+ list.size());
		// */
}
	
	
}
