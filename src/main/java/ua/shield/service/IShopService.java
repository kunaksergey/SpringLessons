package ua.shield.service;

import ua.shield.Exception.ShopNotFoundException;
import ua.shield.entity.Shop;

import java.util.List;

/**
 * Created by sa on 23.03.17.
 */
public interface IShopService {
    void shopCreated(Shop shop);
    void deleteShop(Integer id) throws ShopNotFoundException;
    List<Shop> findAll();
    void shopUpdate(Shop shop) throws ShopNotFoundException;
    Shop findById(Integer id) throws ShopNotFoundException;

}
