package io.javabrains.sbs.manytomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Album {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@NonNull
	@Column(name = "Title")
	private String title;

	@OneToMany(mappedBy = "tag")
	private List<AlbumTag> albumTags;
}
