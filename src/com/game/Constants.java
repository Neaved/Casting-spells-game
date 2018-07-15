package com.game;

import java.util.*;

public class Constants {

    public static final String EMPTY_STRING = "";
    public static final String DOT_SYMBOL = ".";
    public static final String COMMA_SYMBOL = ",";
    public static final String COMMAS_SYMBOL = "\'";
    public static final String SPACE_SYMBOL = " ";
    public static final String START_TYPE_SYMBOL = "> ";
    public static final String COMMA_AND_SPACE_SYMBOLS = COMMA_SYMBOL + SPACE_SYMBOL;

    public static final String EXIT_CMD = "выйти";
    public static final String GET_CMD = "взять";
    public static final String GO_CMD = "идти";
    public static final String USE_CMD = "использовать";
    public static final String INVENTORY_CMD = "инвентарь";
    public static final String LOOK_CMD = "осмотреться";
    public static final String DESCR_CMD = "описание";
    public static final String UNKNOWN_CMD = "Неизвестная команда.";

    public static final String LIVING_ROOM_LOC = "гостинная";
    public static final String ATTIC_LOC = "чердак";
    public static final String GARDEN_LOC = "сад";

    public static final String WEST_DIRECTION = "запад";
    public static final String UPWARD_DIRECTION = "наверх";
    public static final String DOWNWARD_DIRECTION = "вниз";
    public static final String EASTERN_DIRECTION = "восток";

    public static final String BUCKET_ITEM_NAME = "ведро";
    public static final String CHAIN_ITEM_NAME = "цепь";
    public static final String WHISKY_ITEM_NAME = "виски";
    public static final String WELL_ITEM_NAME = "колодец";
    public static final String WIZARD_ITEM_NAME = "волшебник";
    public static final String BURNER_ITEM_NAME = "горелка";
    public static final String FROG_ITEM_NAME = "лягушка";

    public static final String BUCKET_ITEM_DESCRIPTION = "Пустое ведро.";
    public static final String BUCKET_ITEM_WITH_CHAIN_DESCRIPTION = "Пустое ведро c привареной цепью.";
    public static final String BUCKET_ITEM_WITH_WATER_DESCRIPTION = "Полное ведро воды.";
    public static final String WHISKY_ITEM_DESCRIPTION = "Пустая бутылка виски.";
    public static final String WIZARD_ITEM_DESCRIPTION = "Спящий Волшебник.";
    public static final String BURNER_ITEM_DESCRIPTION = "Гигантская горелка.";
    public static final String FROG_ITEM_DESCRIPTION = "Ква.";
    public static final String WELL_ITEM_DESCRIPTION = "Колодец с водой.";
    public static final String CHAIN_ITEM_DESCRIPTION = "Длинная цепь.";

    public static final String INVALID_ACTION = "Недопустимое действие.";
    public static final String INVALID_MOVE_ACTION = "Вы не можете туда пойти.";
    public static final String YOU_HAVE_ACTION = "У Вас есть ";
    public static final String CAN_NOT_TAKE_ACTION = "Нельзя взять ";
    public static final String NO_SUBJECT_ACTION = "Нет предмета с названием ";
    public static final String CAN_NOT_USE_BUCKET_ON_BUCKET_ACTION = "Нельзя использовать ведро на ведро.";

    public static final String STUFF = "Доступные вещи: ";
    public static final String INVENTORY_STUFF = "Доступные вещи в инвенторе: ";
    public static final String EMPTY_INVENTORY_STUFF = "У Вас нет вещей в инвенторе.";

    public static final String DEFAULT_START_GAME_DESCRIPTION = "Осмотритесь. Необходимо понять где вы находитесь.";

    public static final String DEFAULT_LIVING_ROOM_DESCRIPTION =
            "Вы находитесь в гостиной в доме волшебника. А вот и он сам - громко храпит на кровати.\n"
                    + "На западе от вас есть дверь, рядом - лестница наверх.\n";
    public static final String DEFAULT_ATTIC_DESCRIPTION =
            "Вы на чердаке старого дома. В углу видна гигантская горелка. Вниз ведет лестница.";
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
