package bu.met.cs.cs673.pm.jaxrs.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import bu.met.cs.cs673.pm.dao.MemberDAO;
import bu.met.cs.cs673.pm.dao.UserDAO;
import bu.met.cs.cs673.pm.dto.Member;
import bu.met.cs.cs673.pm.jaxrs.mapper.UserMapper;
import bu.met.cs.cs673.pm.jaxrs.model.User;

@Path("/project/{projectid}/member")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MemberResource 
{
	/**
	 * addMember()
	 * 
	 * Adds the corresponding user to the project
	 * 
	 * @param projectid
	 * @param userid
	 * @param rolename
	 * @return
	 */
	@POST
	public boolean addMember(@PathParam("projectid") int projectid,
			@QueryParam("userid") int userid,
			@QueryParam("rolename") String rolename)
	{
		boolean success = false;
		
		if (projectid > 0 &&
			userid > 0 &&
			rolename != null &&
			!"".equals(rolename.trim()))
		{
			Member member = new Member(projectid, userid, rolename);
			
			MemberDAO dao = new MemberDAO();
			int val = dao.insertMember(member);
			
			if (val > 0)
			{
				success = true;
			}
		}
		
		return success;
	}
	
	/**
	 * deleteMember
	 * 
	 * Deletes the corresponding user from the project
	 * 
	 * @param projectid
	 * @param userid
	 * @return
	 */
	@DELETE
	public boolean deleteMember(@PathParam("projectid") int projectid,
			@QueryParam("userid") int userid)
	{
		boolean success = false;

		if (projectid > 0 &&
			userid > 0)
		{
			Member member = new Member(projectid, userid, null);
			
			MemberDAO dao = new MemberDAO();
			int val = dao.deleteMember(member);
			
			if (val > 0)
			{
				success = true;
			}
		}
		
		return success;
	}
	
	@GET
	public List<User> getMembers(@PathParam("projectid") int projectid) 
	{

		List<User> users = new ArrayList<User>();

		UserDAO userDAO = new UserDAO();
		List<bu.met.cs.cs673.pm.dto.User> usersByProject = 
				userDAO.getUserByProject(projectid);
		
		users = UserMapper.mapUsers(usersByProject);

		return users;
	}

}
