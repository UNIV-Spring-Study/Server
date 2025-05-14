package com.example.everytime.Service;

import com.example.everytime.Dto.PostDto;
import com.example.everytime.Entity.Post;
import com.example.everytime.Repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostDto createPost(PostDto dto) {
        Post post = new Post();
        post.setTitle(dto.title());
        post.setContent(dto.content());
        postRepository.save(post);
        return toDto(post);
    }

    public List<PostDto> getAllPosts() {
        return postRepository.findAllWithLikeAndScrapCount()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        return toDto(post);
    }

    @Transactional
    public PostDto updatePost(Long id, PostDto dto) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(dto.title());
        post.setContent(dto.content());
        return toDto(post);
    }

    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        post.setDeleted(true);
    }

    private PostDto toDto(Post post) {
        return new PostDto(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt(),
                post.getUpdatedAt(),
                post.isDeleted(),
                post.getLikes().size(),
                post.getScraps().size()
        );
    }
}