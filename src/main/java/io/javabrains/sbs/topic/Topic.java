package io.javabrains.sbs.topic;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.javabrains.sbs.course.Course;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//TODO: Put this in seprate entity project

@Data
@RequiredArgsConstructor
// @IsCorrectTopic
@Entity
@Table(name = "Topic")
public class Topic {
	public Topic() {
	}

	public Topic(String desc, String name) {
		this.description = desc;
		this.name = name;
	}

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NonNull
	private String description;

	@NonNull
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "TopicId", nullable = true, referencedColumnName = "id")
	private List<Course> courses;
}
