package org.generation.italy.reshare.controller;

import org.generation.italy.reshare.dto.AppUserDto;
import org.generation.italy.reshare.dto.ItemDto;
import org.generation.italy.reshare.dto.RegisterDto;
import org.generation.italy.reshare.model.AppUser;
import org.generation.italy.reshare.model.Category;
import org.generation.italy.reshare.model.City;
import org.generation.italy.reshare.model.Item;
import org.generation.italy.reshare.model.services.abstractions.AppUserService;
import org.generation.italy.reshare.model.services.abstractions.ItemService;
import org.generation.italy.reshare.model.services.abstractions.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    private ItemService itemService;
    private  AppUserService userService;

    @Autowired
    public ItemController(ItemService itemService, AppUserService userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    @PostMapping("/add-item")
    public ItemDto addNewItem(@RequestBody ItemDto itemDto) {
        Category category = itemService.findCategoryByName(itemDto.getCategoryName());
        AppUser owner = userService.getUserByEmail(itemDto.getOwnerEmail());
        Item item = itemDto.toItem(category, owner);
        Item savedItem = itemService.saveItem(item);
        return new ItemDto(savedItem);
    }
}
