
package bu.met.cs.cs673.pm.jaxrs.handlers.factory;

import java.util.Arrays;
import java.util.List;

import org.apache.wink.server.handlers.HandlersFactory;

import bu.met.cs.cs673.pm.jaxrs.handlers.request.AuthorizationRequestHandler;
//import bu.met.cs.cs673.pm.jaxrs.handlers.response.AuthorizationResponseHandler;

public class AuthorizationHandlerFactory extends HandlersFactory
{
    /**
     * @param 
     * @return
     */
    public AuthorizationHandlerFactory()
    {
        
    }

    /**
     * @param 
     * @return 
     */
    @Override
    public List< ? extends org.apache.wink.server.handlers.RequestHandler> 
    getRequestHandlers() 
    {
        return Arrays.asList(new AuthorizationRequestHandler());
    }
    
    /**
     * @param 
     * @return 
        
    @Override
    public List< ? extends org.apache.wink.server.handlers.ResponseHandler> 
    getResponseHandlers() 
    {
        return Arrays.asList(new AuthorizationResponseHandler());
    }*/ 
}
