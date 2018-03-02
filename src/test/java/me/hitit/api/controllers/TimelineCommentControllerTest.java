package me.hitit.api.controllers;

import me.hitit.api.controllers.forms.AddTimelineCommentsForm;
import me.hitit.api.controllers.forms.SignInForm;
import me.hitit.api.controllers.forms.UpdateTimelineCommentForm;
import me.hitit.api.utils.res.ObjectJsonMapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
// @Transactional
public class TimelineCommentControllerTest {
    private static final Logger LOG = Logger.getLogger(TimelineCommentControllerTest.class.getSimpleName());

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mm;

    @Before
    public void setUp() {
        this.mm = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void getTimelineCommentsTest() throws Exception {
        String token = getToken();
        MvcResult mr = mm
                .perform(get("/timeline/{tidx}/comments", 1).param("page", "10").param("sort", "+ts,+idx")
                        .contentType(MediaType.APPLICATION_JSON).header("Authorization", token))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        LOG.info(mr.getResponse().toString());
    }

    @Test
    public void addtimelineCommentTest() throws Exception {
        String token = getToken();
        AddTimelineCommentsForm atcf = new AddTimelineCommentsForm();
        atcf.setContents("누굴까아아아아123");
        atcf.setTidx(new Long(1));
        MvcResult mr = mm
                .perform(post("/timeline/comment").contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token).content(ObjectJsonMapper.process(atcf)))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        LOG.info(mr.getResponse().toString());
    }

    @Test
    public void updateTimelineCommentTest() throws Exception {
        String token = getToken();
        UpdateTimelineCommentForm utcf = new UpdateTimelineCommentForm();
        utcf.setContents("몰러356666");
        MvcResult mr = mm
                .perform(put("/timeline/{tidx}/comment/{tcidx}", 1, 5).contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token).content(ObjectJsonMapper.process(utcf)))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        LOG.info(mr.getResponse().toString());
    }

    @Test
    @Rollback(value = false)
    public void deleteTimelineCommentTest() throws Exception {
        String token = getToken();

        MvcResult mr = mm
                .perform(delete("/timeline/{tidx}/comment/{tcidx}", 1, 7).contentType(MediaType.APPLICATION_JSON)
                        .header("Authorization", token))
                .andDo(print()).andExpect(status().isOk()).andReturn();

        LOG.info(mr.getResponse().toString());
    }

    public String getToken() throws Exception {
        SignInForm sif = new SignInForm();
        sif.setEmail("seungki1993@naver.com");
        sif.setPassword("13");

        MvcResult mr = mm
                .perform(post("/user/sign/in").contentType(MediaType.APPLICATION_JSON).content(ObjectJsonMapper.process(sif)))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        String token = mr.getResponse().getContentAsString().split(",")[1].split(":")[2].replaceAll("\"", "");
        return token;
    }
}
