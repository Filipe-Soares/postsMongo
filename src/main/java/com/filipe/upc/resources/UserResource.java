package com.filipe.upc.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.filipe.upc.domain.Post;
import com.filipe.upc.dto.UserDto;
import com.filipe.upc.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserResource {
	
	private final UserService service;
	
	@GetMapping
	public ResponseEntity<List<UserDto>> findAll() {
		List<UserDto> users = service.findAll();
		return ResponseEntity.ok().body(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDto> findById(@PathVariable String id) {
		UserDto user = service.findById(id);
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@RequestBody UserDto userDto) {
		UserDto user = service.insert(userDto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<UserDto> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody UserDto userDto) {
		userDto.setId(id);
		service.update(userDto);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}/posts")
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		UserDto user = service.findById(id);
		return ResponseEntity.ok().body(user.getPosts());
	}
	
}
