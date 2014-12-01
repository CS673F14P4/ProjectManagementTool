
package bu.met.cs.cs673.pm.jaxrs.handlers.request;

import java.security.Principal;
import java.util.Properties;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.apache.wink.server.handlers.HandlersChain;
import org.apache.wink.server.handlers.MessageContext;
import org.apache.wink.server.handlers.RequestHandler;

import bu.met.cs.cs673.pm.jaxrs.security.impl.UserAuthorizationService;


public class AuthorizationRequestHandler implements RequestHandler
{
    //private static Logger logger = LogManager.getLogger("security");
    
    private static UserAuthorizationService authSvc = new UserAuthorizationService();

    /**
     * @param 
     * @return 
     */
    @Override
    public void init(Properties arg0)
    {
        
    }

    /**
     * @param 
     * @return 
     */    
    @Override
    public void handleRequest(MessageContext context, HandlersChain chain)
        throws Throwable 
    {
        SecurityContext security = context.getSecurityContext();
        Principal principal = security.getUserPrincipal();
        
        if (principal != null)
        {
            String username = principal.getName();
            
            System.out.println("user: " + principal.getName());
            System.out.println("roles: " + security.getUserPrincipal());
            
            authorizeUser(username);
            
            //logger.info("user: " + username);
                
            UriInfo uriInfo = context.getUriInfo();
            authorizeParams(username, uriInfo);
        }
        else
        {
            handleUnauthorizedRequest("User principal not found in security context");

        }
        
        chain.doChain(context);
    }

    /**
     * @param 
     * @return 
     */    
    private void authorizeUser(String username)
    {
//        if (!authSvc.isAuthorized(username))
//        {
//            handleUnauthorizedRequest("User '" + username + "' is not authorized");
//        }
    }

    /**
     * @param 
     * @return 
     */    
    private void authorizeParams(String username, UriInfo uriInfo)
    {
    	System.out.println("uri.path: " + uriInfo.getPath());
    	
    	//authorize the path parameters first
        MultivaluedMap<String, String> pathParams = uriInfo.getPathParameters();
        if (!pathParams.isEmpty())
        {
            authorizeParams(username, pathParams);
        }
        
        //authorize the query parameters next
        MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
        if (!queryParams.isEmpty())
        {
            authorizeParams(username, queryParams);
        }
        
        //custom authorization
        String path = uriInfo.getPath();
        if (path.endsWith("member") && pathParams.containsKey("projectid"))
        {
        	String projectId = pathParams.getFirst("projectid");
        	authorizeMember(username, projectId);
        }
    }

    /**
     * @param 
     * @return 
     */    
    private void authorizeParams(String username, MultivaluedMap<String, String> params)
    {

        if (params.containsKey("projectid"))
        {
            String projectid = params.getFirst("projectid");
            authorizeProject(username, projectid);
        }
        
        if (params.containsKey("storyid"))
        {
            String storyid = params.getFirst("storyid");
            //authorizeStory(username, storyid);
        }
        
        if (params.containsKey("taskid"))
        {
            String taskid = params.getFirst("taskid");
            //authorizeTask(username, taskid);
        }
    }

    /**
     * @param 
     * @return 
     */   
    private void authorizeProject(String username, String projectId)
    {
        if (!authSvc.isAuthorizedForProject(username, projectId))
        {
            handleUnauthorizedRequest("User '" + username + "' is not authorized for project [" + projectId + "]");
        }
    }

    private void authorizeMember(String username, String projectId)
    {
    	if(!authSvc.isAuthorizedForMemberOperations(username, projectId))
    	{
    		handleUnauthorizedRequest("User '" + username + "' is not authorized to edit member list for project [" + projectId + "]");
    	}
    }

    /**
     * @param 
     * @return 
        
    private void authorizeStory(String username, String storyId)
    {
        if (!authSvc.isAuthorizedForStory(username, storyId))
        {
            handleUnauthorizedRequest("User '" + username + "' is not authorized for story [" + storyId + "]");
        }
    }
    */ 

    /**
     * @param 
     * @return 
     
    private void authorizeTask(String username, String taskId)
    {
        if (!authSvc.isAuthorizedForTask(username, taskId))
        {
            handleUnauthorizedRequest("User '" + username + "' is not authorized for task [" + taskId + "]");
        }
    }
 */   
    
    /**
     * @param 
     * @return 
     */    
    private void handleUnauthorizedRequest(String message)
    {
        //logger.error(message);
        System.out.println(message);
        throw new javax.ws.rs.WebApplicationException(Response.status(Status.UNAUTHORIZED).build());
    }
    
}
