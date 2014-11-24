package bu.met.cs.cs673.pm.jaxrs.wrapper;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import bu.met.cs.cs673.pm.jaxrs.model.User;

@XmlRootElement(name="wrapper")
public class UserWrapper {
	
	private List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}
