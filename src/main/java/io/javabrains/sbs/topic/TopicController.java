package io.javabrains.sbs.topic;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController()
@RequestMapping("api/topics")
public class TopicController {

	private final TopicService topicService;

	@Autowired
	public TopicController(TopicService topicService) {
		this.topicService = topicService;
	}

	@RequestMapping()
	public ResponseEntity<?> getAllTopics() {
		Optional<List<Topic>> optTopics = topicService.getAllTopics();

		return optTopics.isPresent() ? ResponseEntity.ok(optTopics.get()) : ResponseEntity.status(500).build();
	}

	@RequestMapping("{id}")
	public ResponseEntity<?> getTopic(@PathVariable String id) {
		Optional<Topic> topicOption = topicService.getTopic(id);

		return topicOption.isPresent() ? ResponseEntity.ok(topicOption.get())
				: ResponseEntity.badRequest().body(Arrays.asList("Some Error"));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addTopic(@RequestBody Topic topic) {

		topicService.addTopic(topic);

		URI uri = UriComponentsBuilder.newInstance().scheme("http").host("localhost")
				.path("/api/topics/" + topic.getId()).build().toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<?> updateTopic(@PathVariable String id, @RequestBody Topic topic) throws Exception {

		Optional<Topic> toUpdate = topicService.getTopic(id);

		if (!toUpdate.isPresent()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Arrays.asList("Some Error"));
		}

		topicService.update(topic);

		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteTopic(@PathVariable String id) {
		topicService.deleteTopic(id);
		return ResponseEntity.noContent().build();
	}

}
