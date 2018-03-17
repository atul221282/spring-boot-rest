package io.javabrains.sbs.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
public class TopicServiceImpl implements TopicService {

	private List<Topic> topics;
	
	public TopicServiceImpl() {
		Topic t1 = new Topic("spring", "Spring Framework", "Spring Framework");
		Topic t2 = new Topic("java", "Core Java", "Core Java Description");
		Topic t3 = new Topic("javascript", "Javascript", "Javascript Description");
		topics = new ArrayList<>(Arrays.asList(t1, t2, t3));
	}

	public Optional<List<Topic>> getAllTopics() {
		return Optional.of(topics);
	}

	public Optional<Topic> getTopic(String id) {
		return id.isEmpty() ? Optional.empty()
				: getAllTopics().get().stream().filter(tp -> tp.getId().equals(id)).findFirst();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public void update(Topic topic) throws Exception {

		Optional<Topic> toUpdate = getTopic(topic.getId());

		if (!toUpdate.isPresent()) {
			throw new Exception("No topic found");
		}

		int index = getAllTopics().get().lastIndexOf(toUpdate.get());

		topics.set(index, topic);

		System.out.println(topic);
		System.out.println(topics.get(index));
	}

	public void deleteTopic(String id) {
		// TODO Auto-generated method stub
		topics.removeIf(x -> x.getId().equals(id));
	}
}
