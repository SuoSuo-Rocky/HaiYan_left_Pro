package org.shiwei.mapper;

import org.shiwei.entity.Login;

public interface LoginMapper {
	
     Login queryLoginBystuId(int stuid);
     
     void addLogin(Login login);
	

}
