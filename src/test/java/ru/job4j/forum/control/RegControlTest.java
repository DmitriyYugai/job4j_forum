package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.UserService;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
class RegControlTest {
    @MockBean
    private UserService users;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser
    void whenSaveUser() throws Exception {
        this.mockMvc.perform(post("/reg")
                .param("username","user")
                .param("password", "root"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<User> argument = ArgumentCaptor.forClass(User.class);
        verify(users).saveUser(argument.capture());
        assertThat(argument.getValue().getUsername(), is("user"));
        assertTrue(passwordEncoder.matches("root", argument.getValue().getPassword()));
    }

    @Test
    @WithMockUser
    void whenGetRegPage() throws Exception {
        mockMvc.perform(get("/reg"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("reg"));
    }
}