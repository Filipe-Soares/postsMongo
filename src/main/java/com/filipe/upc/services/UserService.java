package com.filipe.upc.services;

import java.util.List;

import com.filipe.upc.dto.UserDto;

public interface UserService {

	public List<UserDto> findAll();
	
	UserDto findById(String id);
	
	UserDto insert(UserDto userDto);
 	
	void delete(String id);
	
	UserDto update(UserDto userDto);
}
