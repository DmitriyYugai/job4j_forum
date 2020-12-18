package ru.job4j.forum.repository;

import org.springframework.stereotype.Repository;
import ru.job4j.forum.model.Post;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class Store {
    private final Map<Integer, Post> posts = new HashMap<>();
    private static final AtomicInteger POST_ID = new AtomicInteger(4);

    public Store() {
        posts.put(1, Post.of(1, "Post1"));
        posts.put(2, Post.of(2, "Post2"));
        posts.put(3, Post.of(3, "Post3"));
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Optional<Post> findPostById(int id) {
        return posts.containsKey(id) ? Optional.of(posts.get(id)) : Optional.empty();
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        posts.put(post.getId(), post);
    }
}
