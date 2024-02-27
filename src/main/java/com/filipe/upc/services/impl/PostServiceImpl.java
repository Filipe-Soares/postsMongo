package com.filipe.upc.services.impl;

import org.springframework.stereotype.Service;

import com.filipe.upc.domain.Post;
import com.filipe.upc.dto.PostDto;
import com.filipe.upc.repository.PostRepository;
import com.filipe.upc.services.PostService;
import com.filipe.upc.services.exception.ObjectNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{

	private final PostRepository repository;
	

	@Override
	public PostDto findById(String id) {
		Post post = repository.findById(id)
				.orElseThrow(() -> new ObjectNotFoundException("Post não encontrado"));
		
		return new PostDto(post);
	}

//	@Override
//	public UserDto insert(UserDto userDto) {
//		UserDto.createUser(userDto);
//		User user = repository.save(UserDto.createUser(userDto));
//		
//		return new UserDto(user);
//	}
//
//	@Override
//	public void delete(String id) {
//		findById(id);
//		repository.deleteById(id);		
//	}
//
//	@Override
//	public UserDto update(UserDto userDto) {
//		User userOrigin = repository.findById(userDto.getId())
//				.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado"));
//		UserDto.updateData(userOrigin, userDto);
//		userOrigin = repository.save(userOrigin);
//		return new UserDto(userOrigin);
//	}

	
	
	

}
