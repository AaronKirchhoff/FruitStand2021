package com.aaronkirchhoff.FruitStand.models;

import java.util.Date;






import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;



@Entity
@Table(name="users")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank(message="this field needs to be filled in.")
	@Size(max=15)
	private String firstName;
	@NotBlank(message="this field needs to be filled in.")
	@Size(max=30)
	private String lastName;
	@Email(message="Please provide a valid email.")
	@NotBlank(message="this field needs to be filled in.")
	private String email;
	@NotBlank(message="This field cannot be blank.")
	@Size(min=8, message="Must be greater than 8 characters.")
	private String password;
	@Transient
	@NotBlank(message="This field cannot be blank.")
	private String confirmPassword;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
    private Date createdAt;
	@DateTimeFormat(pattern = "yyy-MM-DD HH:mm:ss")
    private Date updatedAt;
    
    @PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
	@OneToMany(mappedBy="author", fetch=FetchType.LAZY)
	private List<Fruit> fruitPosted;
	
//	pictures! 4/1/21
	@OneToMany(mappedBy ="owner", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Picture> pics;
	
//	many to many, thrid entity created here, 3/28
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="cart",
			joinColumns = @JoinColumn(name= "thisuser_id"),
			inverseJoinColumns = @JoinColumn(name= "thisfruit_id")
			)
	private List<Fruit> shoppingCart;



	// many to many field, made on 3/11/21 let hope this works
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(
			name="likes",
			joinColumns = @JoinColumn(name= "user_id"),
			inverseJoinColumns = @JoinColumn(name= "fruits_id")
			)
	private List<Fruit> likedFruit;
	

	public User() {

}

	public List<Picture> getPics() {
		return pics;
	}



	public void setPics(List<Picture> pics) {
		this.pics = pics;
	}

	public List<Fruit> getShoppingCart() {
		return shoppingCart;
	}



	public void setShoppingCart(List<Fruit> shoppingCart) {
		this.shoppingCart = shoppingCart;
	}



	public List<Fruit> getFruitPosted() {
		return fruitPosted;
	}



	public void setFruitPosted(List<Fruit> fruitPosted) {
		this.fruitPosted = fruitPosted;
	}


	public List<Fruit> getLikedFruit() {
		return likedFruit;
	}



	public void setLikedFruit(List<Fruit> likedFruit) {
		this.likedFruit = likedFruit;
	}



	public Date getCreatedAt() {
		return createdAt;
	}



	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}



	public Date getUpdatedAt() {
		return updatedAt;
	}



	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}



	public List<Fruit> getIdeasPosted() {
		return fruitPosted;
	}



	public void setIdeasPosted(List<Fruit> fruityPosted) {
		this.fruitPosted = fruityPosted;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConfirmPassword() {
		return confirmPassword;
	}



	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	
	
	
	
}
	
	
	
	