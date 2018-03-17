package io.javabrains.sbs.topic;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicServiceTests {

	@Autowired
	private TopicServiceImpl topicService;

	@Test
	public void getAllTopics_returnAllRecords() {
		assertNotNull(topicService);
		assertTrue(topicService.getAllTopics().get().stream().count() == 3);
	}
}
