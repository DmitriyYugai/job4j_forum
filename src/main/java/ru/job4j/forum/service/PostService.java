package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.Store;

import java.util.Collection;
import java.util.Optional;

@Service
public class PostService {
    private final Store store;

    public PostService(Store store) {
        this.store = store;
    }

    public Collection<Post> findAllPosts() {
        return store.findAllPosts();
    }

    public Post findPostById(int id) {
        Optional<Post> post = store.findPostById(id);
        return post.isPresent() ? post.get() : Post.of(0, "");
    }

    public void savePost(Post post) {
        store.save(post);
    }
}
