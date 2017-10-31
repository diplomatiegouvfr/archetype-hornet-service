#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.security.profile;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private List<Role> roles;

    public User() {
        super();
    }
    
	public User(final String username) {
    	super();
        this.username = username;
    }
	
	public String getUsername() {
		return username;
	}
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public List<Role> getRoles() {
		return roles;
	}
	
	public void addRoles(final String roleName) {
		if (this.roles == null) {
			this.roles = new ArrayList<>();
		}
		this.roles.add(new Role(roleName));
	}
	

}