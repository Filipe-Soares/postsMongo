package com.filipe.upc.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String text;
	private Date date;
	private AuthorDto author;
	
}
