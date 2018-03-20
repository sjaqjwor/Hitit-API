package me.hitit.api.controllers;

import me.hitit.api.controllers.forms.SignInForm;
import me.hitit.api.controllers.forms.UpdateFriendBlockForm;
import me.hitit.api.utils.res.ObjectJsonMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.logging.Logger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FriendControllerTest {
    private static final Logger LOG = Logger.getLogger(FriendControllerTest.class.getSimpleName());

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mm;

    @Before
    public void setUp() {
        this.mm = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getFriends() throws Exception {
        String token = getToken();
        MvcResult mr = mm
                .perform(get("/friends")
                        .param("page", "2")
                        .param("sort", "+name")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token))
                .andDo(print())
                .andExpect(status()
                        .isOk())
                .andReturn();
        LOG.info(mr.getResponse().getContentAsString());
    }

    @Test
    public void getFindFriends() throws Exception {
        String token = getToken();
        MvcResult mr = mm
                .perform(get("/friends/find/{keyword}", "kcj091857@")
                        .param("page", "10")
                        .param("sort", "+name")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        LOG.info(mr.getResponse().getContentAsString());
    }

    @Test
    public void updateFriendBlock() throws Exception {
        String token = getToken();
        UpdateFriendBlockForm ufbf = new UpdateFriendBlockForm();
        ufbf.setCheckBlock(true);
        MvcResult mr = mm
                .perform(put("/friend/block/{fuidx}","28")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token)
                        .content(ObjectJsonMapper.process(ufbf)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        LOG.info(mr.getResponse().getContentAsString());
    }

    public String getToken() throws Exception {
        SignInForm sif = new SignInForm();
        sif.setEmail("seungki1993@naver.com");
        sif.setPassword("13");

        MvcResult mr = mm
                .perform(post("/user/sign/in")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ObjectJsonMapper.process(sif)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String token = mr.getResponse().getContentAsString()
                .split(",")[1]
                .split(":")[2]
                .replaceAll("\"", "");
        return token;
    }
}
