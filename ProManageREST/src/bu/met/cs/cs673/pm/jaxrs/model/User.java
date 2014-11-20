package bu.met.cs.cs673.pm.jaxrs.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User {

	private String name;
	private int id;
	private String role;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
