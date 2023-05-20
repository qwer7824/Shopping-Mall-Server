package com.shoppingmallserver.Item;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,Long> {


    List<Item> findByIdIn(List<Long> ids);

    ItemEntity findItemById(Long id);
}
