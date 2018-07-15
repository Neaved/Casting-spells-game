package com.game;

import java.util.*;

public class Constants {

    public static final String EXIT_CMD = "выйти";
    public static final String GET_CMD = "взять";
    public static final String GO_CMD = "идти";
    public static final String USE_CMD = "использовать";
    public static final String INVENTORY_CMD = "инвентарь";
    public static final String LOOK_CMD = "осмотреться";
    public static final String UNKNOWN_CMD = "Неизвестная команда";

    public static final String LIVING_ROOM_LOC = "гостинная";
    public static final String ATTIC_LOC = "чердак";
    public static final String GARDEN_LOC = "сад";

    public static final String BUCKET_ITEM_NAME = "ведро";
    public static final String CHAIN_ITEM_NAME = "цепь";
    public static final String WHISKY_ITEM_NAME = "виски";
    public static final String WELL_ITEM_NAME = "колодец";
    public static final String WIZARD_ITEM_NAME = "волшебник";
    public static final String BURNER_ITEM_NAME = "горелка";
    public static final String FROG_ITEM_NAME = "лягушка";

    public static final String INVALID_ACTION = "Недопустимое действие.";
    public static final String INVALID_MOVE_ACTION = "Вы не можете туда пойти.";
    public static final String YOU_HAVE_ACTION = "У Вас есть ";
    public static final String CAN_NOT_TAKE_ACTION = "Нельзя взять ";
    public static final String NO_SUBJECT_ACTION = "Нет предмета с названием ";
    public static final String CAN_NOT_USE_BUCKET_ON_BUSKET_ACTION = "ННельзя использовать ведро на ведро.";

    public static final String STUFF = "Доступные вещи:";

    public static final String DEFAULT_LIVING_ROOM_DESCRIPTION =
            "Вы находитесь в гостиной в доме волшебника. А вот и он сам - громко храпит на\n"
                    + "кровати. На западе от вас есть дверь, рядом - лестница наверх.\n";
    public static final String DEFAULT_ATTIC_DESCRIPTION =
            "Вы на чердаке старого дома. В углу видна гигантская горелка. Вниз ведет лестница.\n";
    public static final String DEFAULT_GARDEN_DESCRIPTION =
            "Вы в прекрасном саду. Прямо по курсу находится колодец. На востоке - дверь в дом.\n";

    public static final List<String> AVAILABLE_FIRST_ITEM = Arrays.asList(
            BUCKET_ITEM_NAME,
            CHAIN_ITEM_NAME
    );

    public static final List<String> AVAILABLE_SECOND_ITEM = Arrays.asList(
            BUCKET_ITEM_NAME,
            WELL_ITEM_NAME,
            WIZARD_ITEM_NAME
    );

}
