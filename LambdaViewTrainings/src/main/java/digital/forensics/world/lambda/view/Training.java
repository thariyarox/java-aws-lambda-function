package digital.forensics.world.lambda.view;

public class Training {
	
	int id;
	String name;
	String scheduled_date;
	String scheduled_time;
	String resource_person;
	String location;
	
	public Training() {
		
	}
	
	public Training(int id, String name, String scheduled_date, String scheduled_time, String resource_person,
			String location) {
		
		this.id = id;
		this.name = name;
		this.scheduled_date = scheduled_date;
		this.scheduled_time = scheduled_time;
		this.resource_person = resource_person;
		this.location = location;
	}


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
	public String getScheduled_date() {
		return scheduled_date;
	}
	public void setScheduled_date(String scheduled_date) {
		this.scheduled_date = scheduled_date;
	}
	public String getScheduled_time() {
		return scheduled_time;
	}
	public void setScheduled_time(String scheduled_time) {
		this.scheduled_time = scheduled_time;
	}
	public String getResource_person() {
		return resource_person;
	}
	public void setResource_person(String resource_person) {
		this.resource_person = resource_person;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
