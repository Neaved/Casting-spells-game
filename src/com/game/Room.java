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
        StringBuilder description = new StringBuilder(getRoomDescription());
        setDescription(description.append(getInventoryStuffNames()).toString());
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String getRoomDescription() {
        switch (name) {
            case LIVING_ROOM_LOC:
                return DEFAULT_LIVING_ROOM_DESCRIPTION;
            case ATTIC_LOC:
                return DEFAULT_ATTIC_DESCRIPTION;
            case GARDEN_LOC:
                return DEFAULT_GARDEN_DESCRIPTION;
        }
        return EMPTY_STRING;
    }

    private String getInventoryStuffNames() {
        return inventory.thereIsNotStaticItems() ? STUFF + inventory.toString() : EMPTY_STRING;
    }

    public void addItemToRoomInventory(Item item) {
        inventory.addToInventory(item);
    }

    public void removeItemFromRoomInventory(Item item) {
        inventory.removeFromInventory(item);
    }

    public Item getRoomItemByName(String itemName) {
        return inventory.getItemByName(itemName);
    }

    public ArrayList<Item> getRoomInventoryItems() {
        return inventory.getInventoryItems();
    }

    public void addPaths(String direction, Room room) {
        paths.put(direction, room);
    }

    public Room findNextRoom(String direction) {
        return paths.get(direction);
    }
}
