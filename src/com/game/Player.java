package com.game;

import com.game.items.Bucket;
import com.game.items.Chain;
import com.game.items.Item;
import com.game.items.Wizard;

import java.util.ArrayList;

import static com.game.Constants.*;

public class Player {

    private Room room;
    private Inventory inventory;

    public Player() {
        inventory = new Inventory();
    }

    public void goToAnotherRoomCommand(String direction){
        Room nextRoom = room.findNextRoom(direction);
        if (nextRoom != null) {
            this.room = nextRoom;
            System.out.println(room.getDescription());
        } else {
            System.out.println(INVALID_MOVE_ACTION);
        }
    }

    public void getItemsCommand(String itemName) {
        if (room.thereIsStaticItems()) {
            Item item = room.getItemByName(itemName);
            if (item != null && !item.isStatic()) {
                replaceItem(item);
            } else if (item != null && item.isStatic()) {
                System.out.println(CAN_NOT_TAKE_ACTION + item.getName() + ".");
            } else {
                System.out.println(NO_SUBJECT_ACTION + itemName);
            }
        }
    }

    private void replaceItem(Item item){
        addItemToInventory(item);
        room.removeItemFromRoomInventory(item);
    }

    public boolean useItemsCommand(String firstItemName, String secondItemName) {
        Item firstItem = getItemByFlag(firstItemName, true);
        Item secondItem = getItemByFlag(secondItemName, false);
        if (firstItem != null && secondItem != null) {
            if (firstItem instanceof Bucket) {
                ((Bucket) firstItem).craft(secondItem, room);
                return secondItem instanceof Wizard && ((Wizard) secondItem).isAwake();
            } else if (firstItem instanceof Chain) {
                ((Chain) firstItem).craft(secondItem, room, inventory);
                return false;
            }
        } else {
            System.out.println(INVALID_ACTION);
            return false;
        }
        return false;
    }

    private Item getItemByFlag(String itemName, boolean isFirstItem) {
        if (AVAILABLE_FIRST_ITEM.contains(itemName) && isFirstItem) {
            return getItemByName(itemName);
        }
        if (AVAILABLE_SECOND_ITEM.contains(itemName) && !isFirstItem) {
            if(BUCKET_ITEM_NAME.equals(itemName)) {
                return getItemByName(itemName);
            }
            return room.getItemByName(itemName);
        }
        return null;
    }

    private Item getItemByName(String itemName) {
        return inventory.getItem(itemName);
    }

    public void showInventoryCommand() {
        for(Item item : getInventory()) {
            System.out.print(" " + item.getName());
        }
        System.out.println();
    }

    private ArrayList<Item> getInventory() {
        return inventory.getInventory();
    }

    public String getDescriptionOfCurrentRoomCommand(){
        return room.getDescription();
    }

    private void addItemToInventory(Item item) {
        System.out.println(YOU_HAVE_ACTION + item.getName() + ".");
        inventory.addToInventory(item);
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room fr(){
        return room;
    }
}
