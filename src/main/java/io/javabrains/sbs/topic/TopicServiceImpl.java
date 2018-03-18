package io.javabrains.sbs.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class TopicServiceImpl implements TopicService {

	private List<Topic> topics;

	public TopicServiceImpl() {
		System.out.println("Service Init");
		Topic t1 = new Topic("spring", "Spring Framework", "Spring Framework");
		Topic t2 = new Topic("java", "Core Java", "Core Java Description");
		Topic t3 = new Topic("javascript", "Javascript", "Javascript Description");
		topics = new ArrayList<>(Arrays.asList(t1, t2, t3));
	}

	
	public Optional<List<Topic>> getAllTopics() {
		return Optional.of(topics);
	}

	@Override
	@Async
	public CompletableFuture<Optional<Topic>> getTopic(String id) {
		return CompletableFuture.completedFuture(id.isEmpty() ? Optional.empty()
				: getAllTopics().get().stream().filter(tp -> tp.getId().equals(id)).findFirst());
	}

	@Override
	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	@Override
	public void update(Topic topic) throws Exception {
		CompletableFuture<Optional<Topic>> toUpdate = getTopic(topic.getId());

		if (!toUpdate.get().isPresent())
			throw new Exception("No topic found");

		int index = getAllTopics().get().lastIndexOf(toUpdate.get().get());

		topics.set(index, topic);
	}

	@Override
	public void deleteTopic(String id) {
		topics.removeIf(x -> x.getId().equals(id));
	}

	@Override
	public Optional<Topic> getTopicByName(String name) {
		return topics.stream().filter(x -> x.getName().equals(name)).findFirst();
	}
}
