package io.javabrains.sbs.topic;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.javabrains.sbs.course.Course;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

//TODO: Put this in seprate entity project

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Topic")
public class Topic {

	public Topic(String description, String name) {
		this.description = description;
		this.name = name;
	}

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@NonNull
	@Column(name = "Description")
	private String description;

	@NonNull
	@Column(name = "Name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "TopicId", nullable = true, referencedColumnName = "Id")
	@JsonManagedReference
	private List<Course> courses;

}
