package io.javabrains.sbs.topic;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//TODO: Put this in seprate entity project

@Data
@RequiredArgsConstructor
@IsCorrectTopic
@Entity
public class Topic {
	public Topic() {}
	@NonNull
	@Id
	private String id;
	@NonNull
	private String description;
	@NonNull
	private String name;
}
