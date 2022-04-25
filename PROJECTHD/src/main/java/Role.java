public class Role {
	private static int tempID = 1;
	private int roleId;
	private String name;
	private String description;
	
	public Role() {
		this.roleId = tempID;
		tempID++;
	}
	
	public Role(String name, String description) {
		this.roleId = tempID;
		tempID++;
		this.name = name;
		this.description = description;
	}
	
	public Role(Role role) {
		this.roleId = role.roleId;
		this.name = role.name;
		this.description = role.description;
	}

}
