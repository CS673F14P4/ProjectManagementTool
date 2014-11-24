package bu.met.cs.cs673.pm.jaxrs.mapper;

import java.util.ArrayList;
import java.util.List;

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
	
	public static List<Project> mapProjects(List<bu.met.cs.cs673.pm.dto.Project> projectList)
	{
		List<Project> projects = null;
		
		if (projectList != null && projectList.size() > 0)
		{
			projects = new ArrayList<Project>();
			
			for (bu.met.cs.cs673.pm.dto.Project dto : projectList)
			{
				Project project = mapProject(dto);
				projects.add(project);
			}
		}
		
		return projects;
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
