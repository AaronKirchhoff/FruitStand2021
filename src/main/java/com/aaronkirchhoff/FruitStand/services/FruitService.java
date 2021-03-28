package com.aaronkirchhoff.FruitStand.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaronkirchhoff.FruitStand.models.Fruit;
import com.aaronkirchhoff.FruitStand.models.User;
import com.aaronkirchhoff.FruitStand.repositories.FruitRepository;
import com.aaronkirchhoff.FruitStand.repositories.UserRepository;


@Service
public class FruitService {
	@Autowired
	private UserRepository uRepo;
	
	private final FruitRepository fRepo;
	
	
	public FruitService(FruitRepository fRepo) {
		this.fRepo = fRepo;
	}
	
	
	public List<Fruit> getFruits() {
		return this.fRepo.findAll();
	}
	
	public Fruit createFruit(Fruit fruit) {
		return fRepo.save(fruit);

	}
	
	public Fruit findFruit(Long id) {
		return this.fRepo.findById(id).orElse(null);
	}
	
	public Fruit updateFruit(Long id, Fruit updateMyFruit) {
        return this.fRepo.save(updateMyFruit);

	}
	
	public void deleteFruit(Long id) {
		this.fRepo.deleteById(id);
	}
	
//	hope this is right, no erros, but I want a user to create a list of fruit. 3/27/21, i have a list called cart, but when i click the +cart button, it does not add a new fruit to the list? no idea what im doing at this point...
	public void addToCart(Fruit fruit, User user) {
		List<Fruit> fruitInCart = user.getShoppingCart();
		fruitInCart.add(fruit);
		this.uRepo.save(user);
	}
	
	public void removeFromCart(Fruit fruit,User user) {
		List<Fruit> fruitInCart = user.getShoppingCart();
		fruitInCart.remove(fruit);
		this.uRepo.save(user);
	}
	
//	add liker to a fruit. include two paramters to connect many to many relationship, fruit and user. incllude mondeol names, upper cased, then a name for them (commonly same name just lowercase as an attribute name, helps with continuitey),
	public void addLiker(Fruit fruit, User user) {
//		fetch list of likers currently from database.
		List<User> currentLikers = fruit.getLikers();
		currentLikers.add(user);
		this.fRepo.save(fruit);
		
	}

//	remove liker from the array list of liked fruits
	public void removeLiker(Fruit fruit, User user) {
//		fetch list of likers currently from database.
		List<User> currentLikers = fruit.getLikers();
		currentLikers.remove(user);
		this.fRepo.save(fruit);
		
	}
}
