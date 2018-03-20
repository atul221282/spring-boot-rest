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
public class Tags {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long id;

	@NonNull
	@Column(name = "Code")
	private String code;

	@OneToMany(mappedBy = "album")
	private List<AlbumTag> albumTags;
}
