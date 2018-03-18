package io.javabrains.sbs.topic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

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

	@SuppressWarnings("unchecked")
	@Test
	public void getAllTopics_returnok_withvalidrequest() throws Exception {

		Mockito.when(topicService.getAllTopics()).thenReturn(
				CompletableFuture.completedFuture(Optional.of(Arrays.asList(new Topic("id", "desc", "name")))));

		assertNotNull(topicController);

		CompletableFuture<ResponseEntity<?>> response = topicController.getAllTopics();

		assertTrue(response.get().getStatusCodeValue() == 200);

		assertTrue(((List<Topic>) (response.get().getBody())).stream().count() == 1);

		Mockito.verify(topicService).getAllTopics();
	}

	@Test
	public void getAllTopics_returnError_withInvalidrequest() throws Exception {

		Mockito.when(topicService.getAllTopics()).thenReturn(CompletableFuture.completedFuture(Optional.ofNullable(null)));

		assertNotNull(topicController);

		CompletableFuture<ResponseEntity<?>> response = topicController.getAllTopics();

		assertTrue(response.get().getStatusCodeValue() == 500);

		Mockito.verify(topicService).getAllTopics();
	}

}
