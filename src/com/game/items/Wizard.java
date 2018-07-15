package com.game.items;

public class Wizard extends Item {

    private boolean isAwake;

    public Wizard(String name, String description, boolean isStatic) {
        super(name, description, isStatic);
        this.isAwake = true;
    }

    public boolean isAwake() {
        return isAwake;
    }

    public void setAwake(boolean awake) {
        isAwake = awake;
    }
}
