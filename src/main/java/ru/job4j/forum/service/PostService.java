package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.PostRepository;
import ru.job4j.forum.repository.Store;

import java.util.*;

@Service
public class PostService {
    private final PostRepository store;

    public PostService(PostRepository store) {
        this.store = store;
    }

    public List<Post> findAllPosts() {
        List<Post> rsl = new ArrayList<>();
        store.findAll().forEach(rsl::add);
        rsl.sort(Comparator.comparing(Post::getId));
        return rsl;
    }

    public Post findPostById(int id) {
        Optional<Post> post = store.findById(id);
        return post.isPresent() ? post.get() : Post.of(0, "");
    }

    public void savePost(Post post) {
        store.save(post);
    }
}
