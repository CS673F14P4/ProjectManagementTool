package bu.met.cs.cs673.pm.jaxrs.resource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import bu.met.cs.cs673.pm.dao.UserDAO;
import bu.met.cs.cs673.pm.jaxrs.mapper.UserMapper;
import bu.met.cs.cs673.pm.jaxrs.model.User;

/*
 * Olufemi Odegbile
 */

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

	@GET
	@Path("{username}")
	public User getUser(@PathParam("username") String username) {
		System.out.println(">>> getUser");

		User user = null;

		UserDAO dao = new UserDAO();
		bu.met.cs.cs673.pm.dto.User userDTO = dao.getUserByName(username);
		// bu.met.cs.cs673.pm.dto.User userDTO =
		// dao.getUser(Integer.parseInt(id));
		if(userDTO != null){
			System.out.println("<<< not null");
			user = UserMapper.mapUser(userDTO);
		} else{
			System.out.println("<<< null");
			//user = new User(10, null, "femi", null, null, null, null, null);
		}
		System.out.println("<<< getUser");

		return user;
	}

	@Path("/logout")
	@GET
	public void logout(@Context HttpServletRequest req) throws ServletException {
		req.logout();
	}

	@PUT
	public boolean addProject(@QueryParam("userid") int userid,
			@QueryParam("username") String description,
			@QueryParam("lastname") String lastname,
			@QueryParam("firstname") String firstname,
			@QueryParam("password") String password,
			@QueryParam("email") String email)

	{
		boolean success = false;

		return success;
	}
}
