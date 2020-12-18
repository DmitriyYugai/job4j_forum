package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.repository.AuthorityRepository;

@Service
public class AuthorityService {
    private final AuthorityRepository authorityStore;

    public AuthorityService(AuthorityRepository authorityStore) {
        this.authorityStore = authorityStore;
    }

    public Authority findAuthByName(String name) {
        return authorityStore.findByAuthority(name);
    }
}
