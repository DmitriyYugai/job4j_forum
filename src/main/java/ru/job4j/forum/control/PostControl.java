package ru.job4j.forum.control;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@Controller
public class PostControl {
    private final PostService posts;

    public PostControl(PostService posts) {
        this.posts = posts;
    }

    @GetMapping("/post")
    public String post(@RequestParam int id, Model model) {
        Post post = posts.findPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post/post";
    }

    @GetMapping("/post/edit")
    public String edit(@RequestParam(required = false) Integer id, Model model) {
        id = id == null ? 0 : id;
        Post post = posts.findPostById(id);
        model.addAttribute("post", post);
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "post/edit";
    }

    @PostMapping("post/save")
    public String save(@ModelAttribute Post post) {
        posts.savePost(post);
        return "redirect:/";
    }
}
