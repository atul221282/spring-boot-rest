package io.javabrains.sbs.topic;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//TODO: Put this in seprate entity project

@Data
@RequiredArgsConstructor
public class Topic {
	public Topic() {}
	@NonNull
	private String id;
	@NonNull
	private String description;
	@NonNull
	private String name;
}
