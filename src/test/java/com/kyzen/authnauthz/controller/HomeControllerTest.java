package com.kyzen.authnauthz.controller;

import com.kyzen.authnauthz.config.SecurityConfig;
import com.kyzen.authnauthz.service.TokenService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest({HomeController.class, AuthController.class})
@Import({SecurityConfig.class, TokenService.class})
class HomeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void whenUnauthenticated() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void whenAuthenticated() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/auth/token").with(httpBasic("user", "password")))
                .andExpect(status().isOk())
                .andReturn();
        String token = result.getResponse().getContentAsString();

        mockMvc.perform(get("/api/v1/user").header("Authorization", "Bearer " + token))
                .andExpect(content().string("User: user"));
    }

    @Test
    @WithMockUser
    void withMockUser() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is(404)); // ??
    }
}