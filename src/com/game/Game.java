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
        livingRoom.addItemToRoomInventory(new Item(WHISKY_ITEM_NAME, WHISKY_ITEM_DESCRIPTION, false));
        livingRoom.addItemToRoomInventory(new Wizard(WIZARD_ITEM_NAME, WIZARD_ITEM_DESCRIPTION, true));
        livingRoom.addItemToRoomInventory(new Bucket(BUCKET_ITEM_NAME, BUCKET_ITEM_DESCRIPTION, false));
    }

    private void addItemToAttic(Room attic) {
        attic.addItemToRoomInventory(new Item(BURNER_ITEM_NAME, BURNER_ITEM_DESCRIPTION, true));
    }

    private void addItemToGarden(Room garden) {
        garden.addItemToRoomInventory(new Item(FROG_ITEM_NAME, FROG_ITEM_DESCRIPTION, false));
        garden.addItemToRoomInventory(new Well(WELL_ITEM_NAME, WELL_ITEM_DESCRIPTION, true));
        garden.addItemToRoomInventory(new Chain(CHAIN_ITEM_NAME, CHAIN_ITEM_DESCRIPTION, false));
    }

    private void addPathsToRooms(Room livingRoom, Room attic, Room garden) {
        livingRoom.addPaths(WEST_DIRECTION, garden);
        livingRoom.addPaths(UPWARD_DIRECTION, attic);
        attic.addPaths(DOWNWARD_DIRECTION, livingRoom);
        garden.addPaths(EASTERN_DIRECTION, livingRoom);

        addRooms(livingRoom, attic, garden);
    }

    private void addRooms(Room livingRoom, Room attic, Room garden) {
        rooms = new HashMap<>(3);
        rooms.put(livingRoom.getName(), livingRoom);
        rooms.put(attic.getName(), attic);
        rooms.put(garden.getName(), garden);
    }

    private void letsPlay(Player player, Scanner scanner) {
        showStartDescription();
        while (true) {
            System.out.print(START_TYPE_SYMBOL);
            String command = scanner.next().toLowerCase();
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
                    player.getDescriptionOfCurrentRoomCommand();
                    break;
                case DESCR_CMD:
                    player.showItemDescriptionCommand(scanner.next());
                    break;
                case EXIT_CMD:
                    return;
                default:
                    System.out.println(UNKNOWN_CMD);
            }
        }
    }

    private void showStartDescription() {
        System.out.println(DEFAULT_START_GAME_DESCRIPTION);
    }
}
