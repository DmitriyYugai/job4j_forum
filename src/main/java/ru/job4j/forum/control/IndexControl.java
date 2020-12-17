package ru.job4j.forum.control;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexControl {
    @GetMapping({"/", "/index"})
    public String index() {
        return "index";
    }
}
