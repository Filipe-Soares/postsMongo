package com.filipe.upc.dto;

import java.io.Serializable;
import java.util.List;

import com.filipe.upc.domain.Post;
import com.filipe.upc.domain.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private List<Post> posts;
	
	public UserDto(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		posts = user.getPosts();
	}
	
	public static User createUser(UserDto userDto) {
		return User.builder()
				.id(userDto.getId())
				.name(userDto.getName())
				.email(userDto.getEmail()).build();
	}
	
	public static void updateData(User userOrigin, UserDto userDto) {
		userOrigin.setName(userDto.getName());
		userOrigin.setEmail(userDto.getEmail());
	}
	
}
