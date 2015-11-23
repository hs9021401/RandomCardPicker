package com.production.alex.randomcardpicker;

import android.support.annotation.ColorInt;

public class CustColor {
    int retHex;

    @ColorInt
    public static final int RED = 0xFFFF0000;

    @ColorInt
    public static final int ORANGE = 0xFFFFA500;

    @ColorInt
    public static final int YELLOW = 0xFFFFFF00;

    @ColorInt
    public static final int GREEN = 0xFF00FF00;

    @ColorInt
    public static final int BLUE = 0xFF0000FF;

    @ColorInt
    public static final int INDIGO = 0xFF2E0854;

    @ColorInt
    public static final int PURPLE = 0xFF551A8B;

    @ColorInt
    public static final int RANDOM = 0x00000000;


    public int getColorHex(int index)
    {
        switch(index)
        {
            case 0:
                retHex = RED;
                break;
            case 1:
                retHex = ORANGE;
                break;
            case 2:
                retHex = YELLOW;
                break;
            case 3:
                retHex = GREEN;
                break;
            case 4:
                retHex = BLUE;
                break;
            case 5:
                retHex = INDIGO;
                break;
            case 6:
                retHex = PURPLE;
                break;
        }
        return retHex;
    }
}
