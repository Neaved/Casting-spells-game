package com.game;

import com.game.items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.game.Constants.*;

public class Room {
    private String name;

    private String description;
    private Inventory inventory;
    private Map<String, Room> paths;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        inventory = new Inventory();
        paths = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        StringBuilder description = new StringBuilder();
        switch (name) {
            case Constants.LIVING_ROOM_LOC:
                description.append(Constants.DEFAULT_LIVING_ROOM_DESCRIPTION);
                break;
            case Constants.ATTIC_LOC:
                description.append(Constants.DEFAULT_ATTIC_DESCRIPTION);
                break;
            case Constants.GARDEN_LOC:
                description.append(Constants.DEFAULT_GARDEN_DESCRIPTION);
                break;
        }
        if(inventory.thereIsNotStaticItems()) {
            description.append(STUFF);
            description.append(inventory.toString());
        }
        this.description = description.toString();
        return this.description;
    }

    public boolean thereIsStaticItems(){
        return inventory.thereIsStaticItem();
    }

    public void addItemToRoomInventory(Item item) {
        inventory.addToInventory(item);
    }

    public void removeItemFromRoomInventory(Item item) {
        inventory.removeFromInventory(item);
    }

    public Item getItemByName(String itemName) {
        for (Item item : getRoomInventory()) {
            if (itemName.equals(item.getName())) {
                return item;
            }
        }
        return null;
    }

    public ArrayList<Item> getRoomInventory() {
        return inventory.getInventory();
    }

    public void addPaths(String direction, Room room) {
        paths.put(direction, room);
    }

    public Room findNextRoom(String direction) {
        return paths.get(direction);
    }
}
