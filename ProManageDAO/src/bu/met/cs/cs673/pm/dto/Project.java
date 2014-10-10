package bu.met.cs.cs673.pm.dto;

import java.util.Date;
/**
 * 
 * @author Luis Marion
 */
public class Project
{
	private int id;
	private String name;
	private String description;
	private Date start_date;
	private Date end_date;
	private Date create_date;
	private int create_user;
	private Date last_modified_date;
	private int last_modified_user;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public int getCreate_user() {
		return create_user;
	}
	public void setCreate_user(int create_user) {
		this.create_user = create_user;
	}
	public Date getLast_modified_date() {
		return last_modified_date;
	}
	public void setLast_modified_date(Date last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	public int getLast_modified_user() {
		return last_modified_user;
	}
	public void setLast_modified_user(int last_modified_user) {
		this.last_modified_user = last_modified_user;
	}
}
