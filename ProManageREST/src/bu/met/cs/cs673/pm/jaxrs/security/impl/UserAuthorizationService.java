
package bu.met.cs.cs673.pm.jaxrs.security.impl;

import java.util.List;

import bu.met.cs.cs673.pm.dao.ProjectDAO;
import bu.met.cs.cs673.pm.dao.UserDAO;
import bu.met.cs.cs673.pm.dto.Project;
import bu.met.cs.cs673.pm.dto.User;



/*
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
        	UserDAO udao = new UserDAO();
        	
            User user = udao.getUserByName(username);
            
            ProjectDAO pdao = new ProjectDAO();
            
			List<Project> projects = pdao.getProjects(user.getUserId());
            
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
}