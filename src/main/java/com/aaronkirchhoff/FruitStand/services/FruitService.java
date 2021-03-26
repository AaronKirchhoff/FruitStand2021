package com.aaronkirchhoff.FruitStand.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.aaronkirchhoff.FruitStand.models.Fruit;
import com.aaronkirchhoff.FruitStand.models.User;
import com.aaronkirchhoff.FruitStand.repositories.FruitRepository;


@Service
public class FruitService {
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
	
//	add liker to a fruit. include two paramters to connect many to many relationship, fruit and user. incllude mondeol names, upper cased, then a name for them (commonly same name just lowercase as an attribute name, helps with continuitey),
	public void addLiker(Fruit fruit, User user) {
//		fetch list of likers currently from database.
		List<User> currentLikers = fruit.getLikers();
		currentLikers.add(user);
		this.fRepo.save(fruit);
		
	}

}
