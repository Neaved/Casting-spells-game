package com.game;

import com.game.items.Bucket;
import com.game.items.Chain;
import com.game.items.Item;
import com.game.items.Wizard;

import static com.game.Constants.*;

public class Player {

    private Room room;
    private Inventory playerInventory;

    public Player() {
        playerInventory = new Inventory();
    }

    public void goToAnotherRoomCommand(String direction) {
        Room nextRoom = room.findNextRoom(direction);
        if (nextRoom != null) {
            this.room = nextRoom;
            System.out.println(room.getDescription());
        } else {
            System.out.println(INVALID_MOVE_ACTION);
        }
    }

    public void getItemsCommand(String itemName) {
        Item item = room.getRoomItemByName(itemName);
        if (item != null) {
            if (item.isStatic()) {
                showCanNotTakeActionMessage(item);
            } else {
                replaceItem(item);
            }
        } else {
            showNoSubjectActionMessage(itemName);
        }
    }

    private void showCanNotTakeActionMessage(Item item) {
        System.out.println(CAN_NOT_TAKE_ACTION + item.getName() + DOT_SYMBOL);
    }

    private void showNoSubjectActionMessage(String itemName) {
        System.out.println(NO_SUBJECT_ACTION + COMMAS_SYMBOL + itemName + COMMAS_SYMBOL + DOT_SYMBOL);
    }

    private void replaceItem(Item item) {
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
                ((Chain) firstItem).craft(secondItem, room, playerInventory);
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
            return getItemFromInventoryByName(itemName);
        }
        if (AVAILABLE_SECOND_ITEM.contains(itemName) && !isFirstItem) {
            if (BUCKET_ITEM_NAME.equals(itemName)) {
                return getItemFromInventoryByName(itemName);
            }
            return room.getRoomItemByName(itemName);
        }
        return null;
    }

    private Item getItemFromInventoryByName(String itemName) {
        return playerInventory.getItemByName(itemName);
    }

    public void showInventoryCommand() {
        if (playerInventory.isEmpty()) {
            System.out.println(EMPTY_INVENTORY_STUFF);
        } else {
            System.out.println(INVENTORY_STUFF + playerInventory.toString());
        }
    }

    public void getDescriptionOfCurrentRoomCommand() {
        System.out.println(room.getDescription());
    }

    private void addItemToInventory(Item item) {
        playerInventory.addToInventory(item);
        System.out.println(YOU_HAVE_ACTION + item.getName() + DOT_SYMBOL);
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void showItemDescriptionCommand(String itemName) {
        Item item = getItemToShow(itemName);
        if (item != null) {
            System.out.println(item.getDescription());
        } else {
            showNoSubjectActionMessage(itemName);
        }
    }

    private Item getItemToShow(String itemName) {
        Item item = getItemFromInventoryByName(itemName);
        return item == null ? getRoomInventoryByName(itemName) : item;
    }

    private Item getRoomInventoryByName(String itemName) {
        return room.getRoomItemByName(itemName);
    }

}
