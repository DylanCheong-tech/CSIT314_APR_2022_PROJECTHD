public class Account {
	private static int tempID = 1;
	private int accountId;
	private String username;
	private String password;
	private String name;
	private Role role;
	private String dateJoined;
	
	public Account() {
		this.accountId = tempID;
		tempID++;
	}
	
	public Account(String username, String password, String name, Role role, String dateJoined) {
		this.accountId = tempID;
		tempID++;
		this.username = username;
		this.password = password;
		this.name = name;
		this.role = role;
		this.dateJoined = dateJoined;
	}
	
	public Account(Account account) {
		this.accountId = account.accountId;
		this.username = account.username;
		this.password = account.password;
		this.name = account.name;
		this.role = account.role;
		this.dateJoined = account.dateJoined;
	}
	
	
	
}