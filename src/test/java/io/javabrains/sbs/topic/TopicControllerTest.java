package io.javabrains.sbs.topic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TopicController.class, secure = false)
public class TopicControllerTest {

	@MockBean
	private TopicService topicService;

	@Autowired
	private MockMvc mvc;

	@Autowired
	private TopicController topicController;

	@Test
	public void contexLoads() throws Exception {

		Mockito.when(topicService.getAllTopics()).thenReturn(Arrays.asList(new Topic("id", "desc", "name")));

		assertNotNull(topicController);

		ResponseEntity<List<Topic>> response = topicController.getAllTopics();

		assertTrue(response.getStatusCodeValue() == 200);

		assertTrue(response.getBody().stream().count() == 1);

		//assertTrue(false);

		Mockito.verify(topicService).getAllTopics();
	}

}
