package me.hitit.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;
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

import com.fasterxml.jackson.core.JsonProcessingException;

import me.hitit.api.controllers.forms.SignUpForm;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
public class UserControllerTest {
	private static final Logger LOG = Logger.getLogger(UserControllerTest.class.getSimpleName());

	@Autowired
	private WebApplicationContext wac;	
	
	private MockMvc mm;
	
	@Before
	public void setUp(){
		this.mm = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	@Rollback(value=false)
	public void signUpTest() throws JsonProcessingException, Exception {
		SignUpForm suf = new SignUpForm();
		suf.setEmail("lsklsk45@naver.com");
		suf.setPhoneNumber("01091476976");
		suf.setName("이승기");
		suf.setPassword("s556320");
		
		MvcResult mr = mm.perform(post("/user/sign/up").contentType(MediaType.APPLICATION_JSON).
				content(JsonFormat.process(suf)))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		
		LOG.info(mr.getResponse().toString());
	}
	

}
