package io.javabrains.sbs.topic;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Optional;

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
	public void getAllTopics_returnAllRecords() throws Exception {
		topicService = Mockito.mock(TopicServiceImpl.class);
		Mockito.when(topicService.getAllTopics()).thenReturn(Optional.of(Arrays.asList(new Topic("1", "d", "n"))));
		assertTrue(topicService.getAllTopics().get().stream().count() == 1);
	}

}
