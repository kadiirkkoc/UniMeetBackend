package edu.unimeet.dto;

import java.io.Serializable;

import edu.unimeet.entities.Post;
import edu.unimeet.entities.User;
import lombok.Getter;
@Getter
public class PostViewDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String content;
	private UserViewDTO user;
	private PostViewDTO(String content ,UserViewDTO user) {
        this.user=user;
		this.content = content;
	}
	public static PostViewDTO of(Post post) {
	

        return new PostViewDTO(post.getContent(),UserViewDTO.of(post.getUser()));

    }
	
	

}
