package bu.met.cs.cs673.pm.jaxrs.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import bu.met.cs.cs673.pm.dao.MemberDAO;
import bu.met.cs.cs673.pm.dto.Member;

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

}
