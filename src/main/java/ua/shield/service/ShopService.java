package ua.shield.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.shield.Exception.ShopNotFoundException;
import ua.shield.entity.Shop;

import java.util.List;

/**
 * Created by sa on 23.03.17.
 */
@Service
public class ShopService implements IShopService {
    private ShopRepository shopRepository;
    @Override
    public void shopCreated(Shop shop) {
        shopRepository.save(shop);
    }

    @Override
    public void deleteShop(Integer id) throws ShopNotFoundException {
        if(!shopRepository.exists(id)) throw  new ShopNotFoundException();
         shopRepository.delete(id);
    }

    @Override
    public List<Shop> findAll() {
        return (List<Shop>) shopRepository.findAll();
    }

    @Override
    public void shopUpdate(Shop shop) throws ShopNotFoundException {
        shopRepository.save(shop);

    }

    @Override
    public Shop findById(Integer id) throws ShopNotFoundException {
        if(!shopRepository.exists(id)) throw new ShopNotFoundException();
        return shopRepository.findOne(id);
    }

    @Autowired
    public void setShopRepository(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }
}
