package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class Store {
    private final Map<Integer, Post> posts = new HashMap<>();

    public Store() {
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }
}
