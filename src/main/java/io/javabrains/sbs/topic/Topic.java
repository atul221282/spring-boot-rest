package io.javabrains.sbs.topic;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//TODO: Put this in seprate entity project

@Data
@RequiredArgsConstructor
@IsCorrectTopic
@Entity
@Table(name = "Topic")
public class Topic {
	public Topic() {
	}

	@NonNull
	@Id
	private String id;
	@NonNull
	private String description;
	@NonNull
	private String name;
}
