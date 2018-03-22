package me.hitit.api.controllers;

import me.hitit.api.controllers.forms.SignInForm;
import me.hitit.api.controllers.forms.SignUpForm;
import me.hitit.api.controllers.forms.UpdateUserPasswordForm;
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
public class UserControllerTest {
    private static final Logger LOG = Logger.getLogger(UserControllerTest.class.getSimpleName());

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mm;

    @Before
    public void setUp() {
        this.mm = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void signUpTest() throws Exception {
        SignUpForm suf = new SignUpForm();
        suf.setEmail("seungki1993@naver.com");
        suf.setPhoneNumber("01050904341");
        suf.setName("승기");
        suf.setPassword("s556320");
        MvcResult mr = mm
                .perform(post("/user/sign/up")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ObjectJsonMapper.process(suf)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        LOG.info(mr.getResponse().toString());
    }

    @Test
    public void signIn() throws Exception {
        SignInForm sif = new SignInForm();
        sif.setEmail("seungki1993@naver.com");
        sif.setPassword("13");

        MvcResult mr = mm
                .perform(post("/user/sign/in")
                        .content(ObjectJsonMapper.process(sif))
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        LOG.info(mr.getResponse().toString());
    }

    @Test
    public void getUser() throws Exception {
        String token = getToken();
        MvcResult mr = mm
                .perform(get("/user/{udix}", 18)
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        LOG.info(mr.getResponse().getContentAsString());
    }

    @Test
    public void updateUserPassword() throws Exception {
        String token = getToken();
        UpdateUserPasswordForm uupf = new UpdateUserPasswordForm();
        uupf.setPassword("13");
        MvcResult mr = mm
                .perform(put("/user/{uidx}", "23")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token)
                        .content(ObjectJsonMapper.process(uupf)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        LOG.info(mr.getResponse().getContentAsString());
    }

    @Test
    public void checkEmail() throws Exception {
        String token = getToken();
        MvcResult mr = mm
                .perform(get("/user/check/email/{email:.+}", "yeeeah_j@n1aver.com")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        LOG.info(mr.getResponse().getContentAsString());
    }

    @Test
    public void checkPhoneNumber() throws Exception {
        String token = getToken();
        MvcResult mr = mm
                .perform(get("/user/check/phoneNumber/{phoneNumber}", "010914769f76")
                        .contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token))
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
                        .contentType(MediaType.APPLICATION_JSON).content(ObjectJsonMapper.process(sif)))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String token = mr.getResponse().getContentAsString().split(",")[1].split(":")[2].replaceAll("\"", "");
        return token;
    }
}