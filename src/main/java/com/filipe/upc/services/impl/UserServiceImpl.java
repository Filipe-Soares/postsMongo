package com.filipe.upc.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.filipe.upc.domain.User;
import com.filipe.upc.dto.UserDto;
import com.filipe.upc.repository.UserRepository;
import com.filipe.upc.services.UserService;
import com.filipe.upc.services.exception.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

	private final UserRepository repository;
	
	@Override
	public List<UserDto> findAll() {
		List<User> users = repository.findAll();
		
		return users.stream().map(x -> new UserDto(x)).collect(Collectors.toList());
	}

	@Override
	public UserDto findById(String id) {
		User user = repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
		
		return new UserDto(user);
	}

	@Override
	public UserDto insert(UserDto userDto) {
		UserDto.createUser(userDto);
		User user = repository.save(UserDto.createUser(userDto));
		
		return new UserDto(user);
	}

	@Override
	public void delete(String id) {
		findById(id);
		repository.deleteById(id);		
	}

	@Override
	public UserDto update(UserDto userDto) {
		User userOrigin = repository.findById(userDto.getId())
				.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
		UserDto.updateData(userOrigin, userDto);
		userOrigin = repository.save(userOrigin);
		return new UserDto(userOrigin);
	}

	
	
	

}
