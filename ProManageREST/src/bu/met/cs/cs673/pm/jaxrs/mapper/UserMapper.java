package bu.met.cs.cs673.pm.jaxrs.mapper;

import java.util.ArrayList;
import java.util.List;

import bu.met.cs.cs673.pm.jaxrs.model.User;

/*
 * Olufemi Odegbile
 */

public class UserMapper {

	public static User mapUser(bu.met.cs.cs673.pm.dto.User userDTO)
	{
		User user = new User();
		
		user.setUsername(userDTO.getUsername());
		user.setUserId(userDTO.getUserId());
		user.setFirstname(userDTO.getFirstname());
		user.setLastname(userDTO.getLastname());
		user.setEmail(userDTO.getEmail());
		// should not show the password for the service
		//	user.setPassword(userDTO.getPassword());
		user.setCreateDate(userDTO.getCreateDate());
		
		return user;
	}
	
	public static List<User> mapUsers(List<bu.met.cs.cs673.pm.dto.User> userDTOList)
	{
		List<User> users = null;
		
		if (userDTOList != null && !userDTOList.isEmpty())
		{
			users = new ArrayList<User>();
			
			for (bu.met.cs.cs673.pm.dto.User dto : userDTOList)
			{
				User user = mapUser(dto);
				users.add(user);
			}
		}
		
		return users;
	}
	
	public static bu.met.cs.cs673.pm.dto.User mapUser(User UserWS)
	{
		bu.met.cs.cs673.pm.dto.User user = new bu.met.cs.cs673.pm.dto.User();
		
		user.setUsername(UserWS.getUsername());
		user.setUserId(UserWS.getUserId());
		user.setFirstname(UserWS.getFirstname());
		user.setLastname(UserWS.getLastname());
		user.setEmail(UserWS.getEmail());
		user.setPassword(UserWS.getPassword());
		user.setCreateDate(UserWS.getCreateDate());
		
		return user;
	}
	
}
