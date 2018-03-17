package io.javabrains.sbs.topic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TopicController.class, secure = false)
public class TopicControllerTests {

	@MockBean
	private TopicService topicService;

	@Autowired
	private TopicController topicController;

	@Test
	public void getAllTopics_returnok_withvalidrequest() throws Exception {

		Mockito.when(topicService.getAllTopics())
				.thenReturn(Optional.of(Arrays.asList(new Topic("id", "desc", "name"))));

		assertNotNull(topicController);

		ResponseEntity<List<Topic>> response = (ResponseEntity<List<Topic>>) topicController.getAllTopics();

		assertTrue(response.getStatusCodeValue() == 200);

		assertTrue(response.getBody().stream().count() == 1);

		Mockito.verify(topicService).getAllTopics();
	}

	@Test
	public void getAllTopics_returnok_withInvalidrequest() throws Exception {

		Mockito.when(topicService.getAllTopics())
				.thenReturn(Optional.ofNullable(null));

		assertNotNull(topicController);

		ResponseEntity response = topicController.getAllTopics();

		assertTrue(response.getStatusCodeValue() == 500);

		Mockito.verify(topicService).getAllTopics();
	}

}
