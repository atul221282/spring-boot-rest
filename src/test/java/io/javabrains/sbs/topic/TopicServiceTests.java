package io.javabrains.sbs.topic;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceTests {

	private TopicServiceImpl topicService;

	@Test
	public void getAllTopics_returnAllRecords() throws InterruptedException, ExecutionException {
		topicService = Mockito.mock(TopicServiceImpl.class);

		Mockito.when(topicService.getAllTopics()).thenReturn(
			CompletableFuture.completedFuture(Optional.of(Arrays.asList(new Topic("d", "n")))));

		List<Topic> list = topicService.getAllTopics().get().get().stream().collect(Collectors.toList());

		assertTrue(list.size() == 1);
	}

}
