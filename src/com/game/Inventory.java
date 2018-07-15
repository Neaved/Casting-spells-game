package com.game;

import com.game.items.Item;

import java.util.ArrayList;

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

    public boolean thereIsNotStaticItems() {
        return thereIsNotStaticItem() && !inventory.isEmpty();
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public boolean thereIsStaticItem() {
        for (Item item : inventory) {
            if (item.isStatic()) {
                return true;
            }
        }
        return false;
    }

    public boolean thereIsNotStaticItem() {
        for (Item item : inventory) {
            if (!item.isStatic()) {
                return true;
            }
        }
        return false;
    }

    public Item getItem(String itemName) {

        for (Item item : inventory) {
            if (item.getName().equals(itemName)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder items = new StringBuilder();
        if (inventory.size() == 1 && thereIsNotStaticItem()) {
            items.append(inventory.get(0).getName());
        } else {
            for (Item item : inventory) {
                if (!item.isStatic()) {
                    items.append(" ").append(item.getName());
                }
            }
        }
        return items.toString();
    }
}
