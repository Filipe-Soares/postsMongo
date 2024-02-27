package com.filipe.upc.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.filipe.upc.dto.PostDto;
import com.filipe.upc.services.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostResource {
	
	private final PostService service;
	
//	@GetMapping
//	public ResponseEntity<List<PostDto>> findAll() {
//		List<PostDto> posts = service.findAll();
//		return ResponseEntity.ok().body(posts);
//	}

	@GetMapping("/{id}")
	public ResponseEntity<PostDto> findById(@PathVariable String id) {
		PostDto postDto = service.findById(id);
		return ResponseEntity.ok().body(postDto);
	}
	
//	@PostMapping
//	public ResponseEntity<Void> insert(@RequestBody UserDto userDto) {
//		PostDto postDto = service.insert(userDto);
//		URI uri = ServletUriComponentsBuilder
//				.fromCurrentRequest().path("/{id}").buildAndExpand(postDto.getId()).toUri();
//		return ResponseEntity.created(uri).build();
//	}
	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<PostDto> delete(@PathVariable String id) {
//		service.delete(id);
//		return ResponseEntity.noContent().build();
//	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Void> update(@PathVariable String id, @RequestBody PostDto postDto) {
//		postDto.setId(id);
//		service.update(postDto);
//		return ResponseEntity.noContent().build();
//	}
	
	
}
