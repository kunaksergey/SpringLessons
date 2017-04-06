package ua.shield.service;

import org.springframework.data.repository.CrudRepository;
import ua.shield.entity.Shop;

/**
 * Created by sa on 23.03.17.
 */
public interface ShopRepository extends CrudRepository<Shop,Integer> {
}
