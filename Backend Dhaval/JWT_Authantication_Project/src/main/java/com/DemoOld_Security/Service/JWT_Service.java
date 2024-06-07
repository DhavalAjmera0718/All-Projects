package com.DemoOld_Security.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.DemoOld_Security.Entity.user;

@Service
public class JWT_Service {

	private List<user> storeUsers = new ArrayList<>();

	public JWT_Service() {
		super();
		storeUsers.add(new user(UUID.randomUUID().toString(), "Dhaval","@gmail.com"));
		storeUsers.add(new user(UUID.randomUUID().toString(), "kashyap","@gmail.com"));
		storeUsers.add(new user(UUID.randomUUID().toString(), "Dhoni","@gmail.com"));
		storeUsers.add(new user(UUID.randomUUID().toString(), "Goku","@gmail.com"));

		
	}
	public List<user> Get_All_user()
	{
		return this.storeUsers;
	}
	
	
	
	
}
