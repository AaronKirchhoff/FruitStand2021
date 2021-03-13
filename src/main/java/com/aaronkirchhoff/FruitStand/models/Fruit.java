package com.aaronkirchhoff.FruitStand.models;

import java.util.Date;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="fruits")
public class Fruit {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank(message="this field needs to be filled in.")
	@Size(max=50)
	private String name;
	@NotBlank(message="this field needs to be filled in.")
	@Size(max=15)
	private String color;
	
	@NotBlank(message="this field needs to be filled in.")
	@Size(max=200)
	private String content;
	
	private String image_url;

	
	
	@NotBlank(message="this field needs to be filled in.")
	@Size(max=15)
	private String size;
	@NotBlank(message="this field needs to be filled in.")
	@Size(max=8)
	private String domesticOrImport;
		
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
    private Date createdAt;
    private Date updatedAt;
    
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
    
    // many to many field, 3/11/21 ok lets add some new text?
    @ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="likes",
			joinColumns = @JoinColumn(name= "fruits_id"),
			inverseJoinColumns = @JoinColumn(name= "user_id")
			)
    private List<User> likers;
    
    @ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author")
	private User author;
    
//    old constructor with no fields
	public Fruit() {
	}
	
	
// constructor
	public Fruit(@NotBlank(message = "this field needs to be filled in.") @Size(max = 50) String name,
			@NotBlank(message = "this field needs to be filled in.") @Size(max = 15) String color,
			@NotBlank(message = "this field needs to be filled in.") @Size(max = 200) String content, String image_url,
			@NotBlank(message = "this field needs to be filled in.") @Size(max = 15) String size,
			@NotBlank(message = "this field needs to be filled in.") @Size(max = 8) String domesticOrImport,
			Date createdAt, User author) {
		super();
		this.name = name;
		this.color = color;
		this.content = content;
		this.image_url = image_url;
		this.size = size;
		this.domesticOrImport = domesticOrImport;
		this.createdAt = createdAt;
		this.author = author;
	}





	public List<User> getLikers() {
		return likers;
	}


	public void setLikers(List<User> likers) {
		this.likers = likers;
	}


	public String getImage_url() {
		return image_url;
	}





	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}





	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getDomesticOrImport() {
		return domesticOrImport;
	}


	public void setDomesticOrImport(String domesticOrImport) {
		this.domesticOrImport = domesticOrImport;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}
	
	

    
}
