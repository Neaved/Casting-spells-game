package com.game.items;

import com.game.Room;

import java.util.ArrayList;

import static com.game.Constants.*;

public class Bucket extends Item {

    private boolean bucketWithChain;
    private boolean bucketWithWater;

    private static final String GET_BUCKET_WITH_WATER_ACTION_DESCRIPTION =
            "Держа ведро за цепь, вы опускаете его в колодец и поднимаете полным до краев.";
    private static final String CAN_NOT_GET_WATER_ACTION_DESCRIPTION = "Вода слишком далеко. Не достать.";
    private static final String BUCKET_WITHOUT_WATER_ACTION_DESCRIPTION = "В ведре пусто.";
    private static final String AWAKE_WIZARD_ACTION_DESCRIPTION = "Волшебник вскакивает и начинает отряхиваться. Приведя себя в порядок,\n"
            + "он благодарит вас за помощь и протягивает вам магический кристалл. Вы выиграли!";

    public Bucket(String name, String description, boolean isStatic) {
        super(name, description, isStatic);
        this.bucketWithChain = false;
        this.bucketWithWater = false;
    }

    public void craft(Item item, Room room) {
        String roomName = room.getName();

        if (item instanceof Well && isBucketWithChain() && GARDEN_LOC.equals(roomName)) {
            bucketWithWater = true;
            setDescription(BUCKET_ITEM_WITH_WATER_DESCRIPTION);
            System.out.println(GET_BUCKET_WITH_WATER_ACTION_DESCRIPTION);
            return;
        }

        if (item instanceof Well && GARDEN_LOC.equals(roomName)) {
            System.out.println(CAN_NOT_GET_WATER_ACTION_DESCRIPTION);
            return;
        }

        if (item instanceof Wizard && isBucketWithWater() && LIVING_ROOM_LOC.equals(roomName)) {
            awakeWizard(room, (Wizard) item);
            System.out.println(AWAKE_WIZARD_ACTION_DESCRIPTION);
            return;
        } else if (item instanceof Wizard && LIVING_ROOM_LOC.equals(roomName)) {
            System.out.println(BUCKET_WITHOUT_WATER_ACTION_DESCRIPTION);
            return;
        }

        System.out.println(CAN_NOT_USE_BUCKET_ON_BUCKET_ACTION);
    }

    private void awakeWizard(Room room, Wizard awakeWizard) {
        ArrayList<Item> roomInventoryItems = room.getRoomInventoryItems();
        roomInventoryItems.remove(awakeWizard);
        awakeWizard.setAwake(true);
        roomInventoryItems.add(awakeWizard);
    }

    public boolean isBucketWithChain() {
        return bucketWithChain;
    }

    public void setBucketWithChain(boolean bucketWithChain) {
        this.bucketWithChain = bucketWithChain;
    }

    public boolean isBucketWithWater() {
        return bucketWithWater;
    }
}
