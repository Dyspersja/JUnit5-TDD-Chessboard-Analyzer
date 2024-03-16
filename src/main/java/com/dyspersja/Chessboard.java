package com.dyspersja;

import lombok.Getter;

@Getter
public class Chessboard {

    private final int width;
    private final int height;

    public Chessboard(int width, int height) {
        if( width < 6 || width > 70 || height < 6 || height > 40)
            throw new IllegalArgumentException("Invalid Checkerboard size");

        this.width = width;
        this.height = height;
    }

}
