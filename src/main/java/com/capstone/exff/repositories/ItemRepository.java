package com.capstone.exff.repositories;

import com.capstone.exff.entities.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {

    @Override
    <S extends ItemEntity> S save(S s);

    @Query("select i from ItemEntity i where i.name like concat('%', :itemName, '%')")
    List<ItemEntity> findItemsByItemName(String itemName);
}