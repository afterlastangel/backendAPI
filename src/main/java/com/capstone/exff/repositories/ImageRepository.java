package com.capstone.exff.repositories;

import com.capstone.exff.entities.ImageEntity;
import com.capstone.exff.entities.ItemEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImageRepository extends CrudRepository<ImageEntity, Integer>{

    @Query("select i from ImageEntity i where i.itemId = :itemId")
    List<ImageEntity> getImagesByIdItem(int itemId);

    @Override
    <S extends ImageEntity> Iterable<S> saveAll(Iterable<S> iterable);

    @Query("select i.itemId from ImageEntity i where i.id = :imageId")
    int getItemIdByImageId(int imageId);

    @Query("select i.donationPostId from ImageEntity i where i.id = :imageId")
    int getDonationPostIdByImageId(int imageId);
}
