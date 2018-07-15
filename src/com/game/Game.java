package com.game;

import com.game.items.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.game.Constants.*;

public class Game {
    private Map<String, Room> rooms;

    public void game() {
        Scanner scanner = new Scanner(System.in);
        createWorld();

        Player player = new Player();
        player.setRoom(rooms.get(LIVING_ROOM_LOC));

        letsPlay(player, scanner);
    }

    private void createWorld() {
        Room livingRoom = new Room(LIVING_ROOM_LOC, DEFAULT_LIVING_ROOM_DESCRIPTION);
        addItemToLivingRoom(livingRoom);
        Room attic = new Room(ATTIC_LOC, DEFAULT_ATTIC_DESCRIPTION);
        addItemToAttic(attic);
        Room garden = new Room(GARDEN_LOC, DEFAULT_GARDEN_DESCRIPTION);
        addItemToGarden(garden);
        addPathsToRooms(livingRoom, attic, garden);

    }

    private void addItemToLivingRoom(Room livingRoom) {
        Bucket bucket = new Bucket(BUCKET_ITEM_NAME, "пустое ведро", false);
        Item whisky = new Item(WHISKY_ITEM_NAME, "пустая бутылка вики", false);
        Wizard wizard = new Wizard(WIZARD_ITEM_NAME, "волшебник", true);
        livingRoom.addItemToRoomInventory(whisky);
        livingRoom.addItemToRoomInventory(wizard);
        livingRoom.addItemToRoomInventory(bucket);
    }

    private void addItemToAttic(Room attic) {
        Item burner = new Item(BURNER_ITEM_NAME, "гигантская горелка", true);
        attic.addItemToRoomInventory(burner);
    }

    private void addItemToGarden(Room garden) {
        Item frog = new Item(FROG_ITEM_NAME, "ква", false);
        Well well = new Well(WELL_ITEM_NAME, "буль", true);
        Chain chain = new Chain(CHAIN_ITEM_NAME, "цепь", false);
        garden.addItemToRoomInventory(frog);
        garden.addItemToRoomInventory(well);
        garden.addItemToRoomInventory(chain);
    }

    private void addPathsToRooms(Room livingRoom, Room attic, Room garden) {
        livingRoom.addPaths("запад", garden);
        livingRoom.addPaths("наверх", attic);
        attic.addPaths("вниз", livingRoom);
        garden.addPaths("восток", livingRoom);

        rooms = new HashMap<>(3);
        rooms.put("гостинная", livingRoom);
        rooms.put("чердак", attic);
        rooms.put("сад", garden);
    }

    private void letsPlay(Player player, Scanner scanner) {
        while (true) {
            System.out.print("> ");
            String command = scanner.next();
            switch (command) {
                case GO_CMD:
                    player.goToAnotherRoomCommand(scanner.next());
                    break;
                case GET_CMD:
                    player.getItemsCommand(scanner.next());
                    break;
                case USE_CMD:
                    String firstItemName = scanner.next();
                    String secondItemName = scanner.next();
                    if (player.useItemsCommand(firstItemName, secondItemName)) {
                        return;
                    }
                    break;
                case INVENTORY_CMD:
                    player.showInventoryCommand();
                    break;
                case LOOK_CMD:
                    System.out.println(player.getDescriptionOfCurrentRoomCommand());
                    break;
                case EXIT_CMD:
                    return;
                default:
                    System.out.println(UNKNOWN_CMD);
            }
        }
    }
}
