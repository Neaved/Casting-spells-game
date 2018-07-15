package com.game.items;

import com.game.Room;

import java.util.ArrayList;

import static com.game.Constants.*;

public class Bucket extends Item {

    private boolean bucketWithChain;
    private boolean bucketWithWater;

    public Bucket(String name, String description, boolean isStatic) {
        super(name, description, isStatic);
        this.bucketWithChain = false;
        this.bucketWithWater = false;
    }

     public void craft(Item item, Room room) {
        String roomName = room.getName();

        if (item instanceof Well && isBucketWithChain() && GARDEN_LOC.equals(roomName)) {
            bucketWithWater = true;
            System.out.println("Держа ведро за цепь, вы опускаете его в колодец и поднимаете полным до краев.");
            return;
        }

        if (item instanceof Well && GARDEN_LOC.equals(roomName)) {
            System.out.println("Вода слишком далеко. Не достать.");
            return;
        }

        if (item instanceof Wizard && isBucketWithWater() && LIVING_ROOM_LOC.equals(roomName)) {
            System.out.println("Волшебник вскакивает и начинает отряхиваться. Приведя себя в порядок, он\n"
                    + "благодарит вас за помощь и протягивает вам магический кристалл. Вы выиграли!");
            awakeWizard(room,item);
            return;
        } else if (item instanceof Wizard && LIVING_ROOM_LOC.equals(roomName)) {
            System.out.println("В ведре пусто.");
            return;
        }

        System.out.println(CAN_NOT_USE_BUCKET_ON_BUSKET_ACTION);
    }

    private void awakeWizard(Room room, Item item){
        Wizard awakeWizard = (Wizard) item;
        ArrayList<Item> roomInventory = room.getRoomInventory();
        roomInventory.remove(item);
        awakeWizard.setAwake(true);
        roomInventory.add(awakeWizard);
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
