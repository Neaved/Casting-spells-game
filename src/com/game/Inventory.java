package com.game;

import com.game.items.Item;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.game.Constants.*;

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
        return inventory.stream().anyMatch(Item::isNotStatic);
    }

    public Item getItemByName(String itemName) {
        return inventory
                .stream()
                .filter(item -> item.getName().equals(itemName))
                .findFirst().get();
    }

    @Override
    public String toString() {
        return inventory.size() == 1 && thereIsNotStaticItem() ? inventory.get(0).getName() + DOT_SYMBOL : printInventoryStuffNames();
    }

    private String printInventoryStuffNames() {
        return inventory
                .stream()
                .filter(Item::isNotStatic)
                .map(Item::getName)
                .collect(Collectors.joining(COMMA_SYMBOL, EMPTY_STRING, DOT_SYMBOL));
    }
}
