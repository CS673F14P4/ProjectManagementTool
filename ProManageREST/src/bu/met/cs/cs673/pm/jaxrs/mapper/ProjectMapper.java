package bu.met.cs.cs673.pm.jaxrs.mapper;

import bu.met.cs.cs673.pm.jaxrs.model.Project;

public class ProjectMapper 
{

	public static Project mapProject(bu.met.cs.cs673.pm.dto.Project projectDTO)
	{
		Project project = new Project();
		
		project.setName(projectDTO.getName());
		project.setDescription(projectDTO.getName());
		project.setStartDate(projectDTO.getStartDate());
		project.setEndDate(projectDTO.getEndDate());
		//project.setOwner(projectDTO.getCreateUser());
		
		return project;
	}
	
	public static bu.met.cs.cs673.pm.dto.Project mapProject(Project project)
	{
		bu.met.cs.cs673.pm.dto.Project projectDTO = new bu.met.cs.cs673.pm.dto.Project();
		
		return projectDTO;
		
	}
}
