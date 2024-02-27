package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	private String userName;
	private String password;
	private String email;
	private String fullName;
	private String gender;
	public User(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}


}
