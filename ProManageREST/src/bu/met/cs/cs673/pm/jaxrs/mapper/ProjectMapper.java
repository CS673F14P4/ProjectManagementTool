package bu.met.cs.cs673.pm.jaxrs.mapper;

import bu.met.cs.cs673.pm.jaxrs.model.Project;

public class ProjectMapper 
{

	public static Project mapProject(bu.met.cs.cs673.pm.dto.Project projectDTO)
	{
		Project project = new Project();
		
		project.setName(projectDTO.getName());
		project.setDescription(projectDTO.getDescription());
		project.setStartDate(projectDTO.getStartDate());
		project.setEndDate(projectDTO.getEndDate());
		//project.setOwner(projectDTO.getCreateUser());
		
		return project;
	}
	
	public static bu.met.cs.cs673.pm.dto.Project mapProject(Project projectWS)
	{
		bu.met.cs.cs673.pm.dto.Project project = new bu.met.cs.cs673.pm.dto.Project();

		project.setName(projectWS.getName());
		project.setDescription(projectWS.getDescription());
		project.setStartDate(projectWS.getStartDate());
		project.setEndDate(projectWS.getEndDate());
		
		return project;
	}
}
