package com.aaronkirchhoff.FruitStand.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.aaronkirchhoff.FruitStand.models.Picture;
import com.aaronkirchhoff.FruitStand.models.User;

public interface PictureRepository extends CrudRepository <Picture, Long>{
//	need custom query, to search for specific users pics
	List<Picture> findAllByOwner(User owner);

}
