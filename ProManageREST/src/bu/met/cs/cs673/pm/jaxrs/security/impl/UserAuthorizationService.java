
package bu.met.cs.cs673.pm.jaxrs.security.impl;

import java.util.List;

import bu.met.cs.cs673.pm.dao.MemberDAO;
import bu.met.cs.cs673.pm.dao.ProjectDAO;
import bu.met.cs.cs673.pm.dto.Member;
import bu.met.cs.cs673.pm.dto.Project;
import bu.met.cs.cs673.pm.util.UserUtil;


/**
 * UserAuthorizationService
 *
 * User authorization service is responsible for authorizing the logged in user against the rest resource operations.
 * A user should only be able to perform operations against projects/stories/tasks to which he/she is the leader or member.
 *
 * @author Luis Marion
 */
public class UserAuthorizationService
{
    //private static Logger logger = LogManager.getLogger("security");
	
	private static String PROJECT_LEADER_ROLE = "project_leader";
    
    /**
     * Determines if the specified user is authorized to request the specified project.
     * 
     * @param username
     * @param projectId
     * @return <code>true</code> if the user is authorized, <code>false</code> otherwise
     */
    public boolean isAuthorizedForProject(String username, String projectId)
    {
        boolean isAuthorized = false;
        
        try
        {
        	int userid = UserUtil.getUserId(username);
            
            ProjectDAO pdao = new ProjectDAO();
            
			List<Project> projects = pdao.getProjects(userid);
            
			int id = Integer.parseInt(projectId);
			
			for (Project p : projects)
			{
				if (id == p.getId())
				{
					isAuthorized = true;
					break;
				}
			}
        }
        catch (Exception ex)
        {
            //logger.error("Error authorizing user '" + username + "' for project [" + projectId + "].", ex);
        }
            
        System.out.println("user: " + username + ", isAuthorized: " + isAuthorized + ", project: "+ projectId);
        
        return isAuthorized;
    }
    
    /**
     * isAuthorizedForMemberOperations()
     * 
     * Determines if the specified user is authorized to manage the member lists for the given project. Only the project
     * leader should have this ability.
     * 
     * @param username
     * @param projectId
     * @return
     */
    public boolean isAuthorizedForMemberOperations(String username, String projectId)
    {
    	boolean isAuthorized = false;
        
    	try
        {
        	int userId = UserUtil.getUserId(username);
        	int pId = Integer.parseInt(projectId);
            
            MemberDAO mdao = new MemberDAO();
            
            Member searchMember = new Member(pId, userId, null); 
            Member member = mdao.getMember(searchMember);
            
            if (PROJECT_LEADER_ROLE.equals(member.getRoleName()))
            {
            	isAuthorized = true;
            }
        }
        catch (Exception ex)
        {
            //logger.error("Error authorizing user '" + username + "' for project [" + projectId + "].", ex);
        }
            
        System.out.println("MEMBER_OP_AUTH::: user: " + username + ", isAuthorized: " + isAuthorized + ", project: "+ projectId);    	
    	
    	return isAuthorized;
    }
}