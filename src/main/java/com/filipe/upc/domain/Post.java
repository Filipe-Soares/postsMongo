package com.filipe.upc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.filipe.upc.dto.AuthorDto;
import com.filipe.upc.dto.CommentDto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Document(collection = "post")
public class Post implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Date date;
	private String title;
	private String body;
	private AuthorDto Author;
	
	private List<CommentDto> comments = new ArrayList<>();

	public Post(String id, Date date, String title, String body, AuthorDto author) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		Author = author;
	}
 	
}
