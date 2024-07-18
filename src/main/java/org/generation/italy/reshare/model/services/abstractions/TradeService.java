package org.generation.italy.reshare.model.services.abstractions;

import org.generation.italy.reshare.exceptions.EntityNotFoundException;
import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.Item;
import org.generation.italy.reshare.model.ItemTrade;

import java.time.LocalDate;
import java.util.List;

public interface TradeService {
    List<ItemTrade> getAll();
    List<ItemTrade> getAllById(long id);
    List<ItemTrade> getAllByRequestDate(LocalDate requestDate);
    List<ItemTrade> getAllByExchangeDate(LocalDate exchangeDate);
    List<ItemTrade> getAllByItem(String itemName);
    void exchangeItem(long userId1, long userId2);
    void exchangeOfferedItem(long userId1);

    ItemTrade saveItemTrade(ItemTrade it);
}
