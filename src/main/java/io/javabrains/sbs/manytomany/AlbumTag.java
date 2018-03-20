package io.javabrains.sbs.manytomany;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class AlbumTag {

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Long Id;

	@ManyToOne
	@JoinColumn(name = "AlbumId")
	private Album album;

	@ManyToOne
	@JoinColumn(name = "TagId")
	private Tags tag;

	@NonNull
	@Column(nullable = false, name = "CreatedDate")
	private Date createdDate;
}
