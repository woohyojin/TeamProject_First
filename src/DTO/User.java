package DTO;

public class User {
	private int pryNumber;
	private String idName;
	private String password;
	private String name;
	private String age;
	private String email;
	
	public User() {
		this(0,"","","","","");
	}

	public User(int pryNumber, String idName, String password,
			String name, String age, String email) {
		super();
		this.pryNumber = pryNumber;
		this.idName = idName;
		this.password = password;
		this.name = name;
		this.age = age; 
		this.email = email;
	}

	public int getPryNumber() {
		return pryNumber;
	}

	public void setPryNumber(int pryNumber) {
		this.pryNumber = pryNumber;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [pryNumber=" + pryNumber + ", idName=" + idName + ", password=" + password + ", name=" + name
				+ ", age=" + age + ", email=" + email + "]";
	}
}
