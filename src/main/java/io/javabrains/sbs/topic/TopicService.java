package io.javabrains.sbs.topic;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public interface TopicService {

	public Optional<List<Topic>> getAllTopics();

	public CompletableFuture<Optional<Topic>> getTopic(String id);

	public void addTopic(Topic topic);

	public void update(Topic topic) throws Exception;

	public void deleteTopic(String id);

	public Optional<Topic> getTopicByName(String name);
}
