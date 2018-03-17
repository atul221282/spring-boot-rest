package io.javabrains.sbs.topic;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public interface TopicService {

	public Optional<List<Topic>> getAllTopics();

	public Optional<Topic> getTopic(String id);

	public void addTopic(Topic topic);

	public void update(Topic topic) throws Exception;

	public void deleteTopic(String id);
}
