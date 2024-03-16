package com.dyspersja;

import lombok.Getter;

@Getter
public class Chessboard {

    private static final int MIN_WIDTH = 6;
    private static final int MAX_WIDTH = 70;
    private static final int MIN_HEIGHT = 6;
    private static final int MAX_HEIGHT = 40;

    private final int width;
    private final int height;

    public Chessboard(int width, int height) {
        if( width < MIN_WIDTH || width > MAX_WIDTH || height < MIN_HEIGHT || height > MAX_HEIGHT)
            throw new IllegalArgumentException("Invalid Checkerboard size");

        this.width = width;
        this.height = height;
    }

}
