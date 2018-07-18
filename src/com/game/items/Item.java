package com.game.items;

public class Item {

    private String name;
    private String description;
    private boolean isStatic;

    public Item(String name, String description, boolean isStatic) {
        this.name = name;
        this.description = description;
        this.isStatic = isStatic;
    }

    public String getName() {
        return name;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public boolean isNotStatic() {
        return !isStatic();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
