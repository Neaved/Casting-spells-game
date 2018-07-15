package com.game.items;

import com.game.Inventory;
import com.game.Room;

import java.util.ArrayList;

import static com.game.Constants.*;

public class Chain extends Item {

    public Chain(String name, String description, boolean isStatic) {
        super(name, description, isStatic);
    }

    public void craft(Item item, Room room, Inventory inventory) {
        String roomName = room.getName();
        if (item instanceof Bucket
                && ATTIC_LOC.equals(roomName)) {

            ArrayList<Item> playerInventory = inventory.getInventory();
            Chain chain = null;
            for (Item playerItem : playerInventory) {
                if (playerItem.getName().equals(CHAIN_ITEM_NAME)) {
                    chain = (Chain) playerItem;
                }
            }
            if (chain != null) {
                playerInventory.remove(chain);
            }
            ((Bucket) item).setBucketWithChain(true);
            playerInventory.add(item);
            System.out.println("Теперь цепь надежно приварена к ведру.");
        }
    }
}
