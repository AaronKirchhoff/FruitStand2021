package com.aaronkirchhoff.FruitStand.repositories;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.FruitStand.models.Fruit;
import com.aaronkirchhoff.FruitStand.models.User;

public interface FruitRepository extends CrudRepository<Fruit, Long> {
	List<Fruit> findAll();
	
//	List<Fruit> findAllByUser(User fruitPosted);
	


}
