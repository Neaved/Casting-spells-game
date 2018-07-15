package com.game;

import com.game.items.Item;

import java.util.ArrayList;

import static com.game.Constants.COMMA_AND_SPACE_SYMBOLS;
import static com.game.Constants.DOT_SYMBOL;

public class Inventory {

    private ArrayList<Item> inventory;

    public Inventory() {
        this.inventory = new ArrayList<>();
    }

    public void addToInventory(Item item) {
        inventory.add(item);
    }

    public void removeFromInventory(Item item) {
        inventory.remove(item);
    }

    public boolean isEmpty() {
        return inventory.isEmpty();
    }

    public boolean thereIsNotStaticItems() {
        return thereIsNotStaticItem() && !inventory.isEmpty();
    }

    public ArrayList<Item> getInventoryItems() {
        return inventory;
    }

    public boolean thereIsNotStaticItem() {
        for (Item item : inventory) {
            if (!item.isStatic()) {
                return true;
            }
        }
        return false;
    }

    public Item getItemByName(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return inventory.size() == 1 && thereIsNotStaticItem() ? inventory.get(0).getName() + DOT_SYMBOL : printInventoryStuffNames();
    }

    private String printInventoryStuffNames() {
        StringBuilder itemNames = new StringBuilder();
        for (Item item : inventory) {
            if (!item.isStatic()) {
                itemNames.append(item.getName()).append(COMMA_AND_SPACE_SYMBOLS);
            }
        }
        String itemNamesSt = itemNames.toString();
        return itemNamesSt.substring(0, itemNamesSt.length() - 2) + DOT_SYMBOL;
    }
}
