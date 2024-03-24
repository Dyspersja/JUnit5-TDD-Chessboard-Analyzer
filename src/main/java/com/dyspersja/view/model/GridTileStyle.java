package com.dyspersja.view.model;

public enum GridTileStyle {
    DEFAULT_0("#dddddd"),
    DEFAULT_1("#aaaaaa"),
    DEFAULT_HOVER("#777777"),
    ATTACKED_HOVER("#ff7777");

    private final String color;

    GridTileStyle(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return this.color;
    }
}
