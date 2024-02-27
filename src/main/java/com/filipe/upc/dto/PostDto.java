package com.filipe.upc.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.filipe.upc.domain.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Date date;
	private String title;
	private String body;
	
	private List<CommentDto> comments = new ArrayList<>();
	
	public PostDto(Post post) {
		id = post.getId();
		date = post.getDate();
		title = post.getTitle();
		body = post.getBody();
	}
	
//	public static Post createUser(PostDto postDto) {
//		return new Post(postDto.getId(), postDto.getDate(), postDto.getTitle(), postDto.getBody());
//	}
	
	public static void updateData(Post postOrigin, PostDto postDto) {
		postOrigin.setDate(postDto.getDate());
		postOrigin.setTitle(postDto.getTitle());
		postOrigin.setBody(postDto.getBody());
	}
	
}
