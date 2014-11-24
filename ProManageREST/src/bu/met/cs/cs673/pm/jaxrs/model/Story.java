package bu.met.cs.cs673.pm.jaxrs.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

/*
 * Daniel Aramowitz
 */

@XmlRootElement(name = "story")
public class Story {

	private int id;
	private String name;
	private int projectid;
	private int status;
	private Date dueDate;
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getProjectid() {
		return projectid;
	}

	public void setProjectid(int projectid) {
		this.projectid = projectid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
