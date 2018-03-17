/**
 * 
 */
package io.javabrains.sbs.topic;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author AtulChaudhary
 *
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = TopicController.class, secure = false)
public class TopicControllerTest {

	@Autowired
	private TopicController controller;

	@MockBean
	private TopicService topicService;

	@Test
	public void contexLoads() throws Exception {
		assertNotNull(controller);
		}
}
