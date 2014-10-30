package bu.met.cs.cs673.pm.jaxrs.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import bu.met.cs.cs673.pm.jaxrs.resource.ProjectResource;

public class ProManageApplication extends Application
{
    @Override
    public Set<Class<?>> getClasses() 
    {
        Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(ProjectResource.class);

        return classes;
    }
}
