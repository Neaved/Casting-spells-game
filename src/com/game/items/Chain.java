package com.game.items;

import com.game.Inventory;
import com.game.Room;

import java.util.ArrayList;

import static com.game.Constants.*;

public class Chain extends Item {

    private static final String BUCKET_ITEM_WITH_CHAIN_ACTION_DESCRIPTION = "Теперь цепь надежно приварена к ведру.";

    public Chain(String name, String description, boolean isStatic) {
        super(name, description, isStatic);
    }

    public void craft(Item item, Room room, Inventory playerInventory) {
        if (item instanceof Bucket && ATTIC_LOC.equals(room.getName())) {
            ArrayList<Item> playerInventoryItems = playerInventory.getInventoryItems();
            Chain chain = getChainFromPlayerInventory(playerInventoryItems);

            if (chain != null) {
                playerInventoryItems.remove(chain);
            }
            ((Bucket) item).setBucketWithChain(true);
            item.setDescription(BUCKET_ITEM_WITH_CHAIN_DESCRIPTION);
            playerInventoryItems.add(item);
            System.out.println(BUCKET_ITEM_WITH_CHAIN_ACTION_DESCRIPTION);
        }
    }

    private Chain getChainFromPlayerInventory(ArrayList<Item> playerInventoryItems) {
        for (Item playerItem : playerInventoryItems) {
            if (CHAIN_ITEM_NAME.equals(playerItem.getName())) {
                return (Chain) playerItem;
            }
        }
        return null;
    }
}
