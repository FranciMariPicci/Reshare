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

    ItemTrade saveItemTrade(ItemTrade it);

    List<ItemTrade> getByHomeUserIdAndAccepted(long homeUserId, Boolean accepted);
}
