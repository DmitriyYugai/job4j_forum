package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.repository.Store;

import java.util.Collection;

@Service
public class PostService {
    private final Store store;

    public PostService(Store store) {
        this.store = store;
    }

    public Collection<Post> findAllPosts() {
        return store.findAllPosts();
    }
}
