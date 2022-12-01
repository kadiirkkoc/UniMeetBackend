package edu.unimeet.business.manager;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.unimeet.business.service.PostService;
import edu.unimeet.dto.PostCreateDTO;
import edu.unimeet.dto.PostViewDTO;
import edu.unimeet.dto.UserViewDTO;
import edu.unimeet.entities.Post;
import edu.unimeet.repository.PostRepository;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class PostManager implements PostService{
	private final PostRepository postRepositor;
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public PostViewDTO getPostById(int id) {
		final Post post = postRepositor.findById(id).orElseThrow();
		return PostViewDTO.of(post);
	}

	@Override
	public PostViewDTO createPost(PostCreateDTO postCreateDTO) {
		final Post post = new Post(postCreateDTO.getContent());
		postRepositor.save(post);
		return PostViewDTO.of(post);
	}

	@Override
	public List<PostViewDTO> getAll() {
		// TODO Auto-generated method stub
		return postRepositor.findAll().stream().map(PostViewDTO::of).collect(Collectors.toList());
	}

}
