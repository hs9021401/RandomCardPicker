package com.production.alex.randomcardpicker;

import java.util.Random;

public class Card {
    private int m_color;
    private String m_sentence;
    String localSentence;

    public void randomGenerate(int limitColor) {
        if (limitColor == 0) {
            int iColorHex;
            Random random = new Random();
            m_color = random.nextInt(7);
            iColorHex = new CustColor().getColorHex(m_color);
            m_sentence = genSentence(iColorHex);
        }else
        {
            m_sentence = genSentence(limitColor);
        }
    }


    private String genSentence(int color) {

        String[] sentence;
        Random random = new Random();
        switch (color) {
            case CustColor.RED:
                sentence = new String[]{"r1", "r2", "r3", "r4"};
                localSentence = sentence[random.nextInt(sentence.length)];
                break;

            case CustColor.ORANGE:
                sentence = new String[]{"o1", "o2", "o3", "o4"};
                localSentence = sentence[random.nextInt(sentence.length)];
                break;

            case CustColor.YELLOW:
                sentence = new String[]{"y1", "y2", "y3", "y4"};
                localSentence = sentence[random.nextInt(sentence.length)];
                break;

            case CustColor.GREEN:
                sentence = new String[]{"g1", "g2", "g3", "g4"};
                localSentence = sentence[random.nextInt(sentence.length)];
                break;

            case CustColor.BLUE:
                sentence = new String[]{"b1", "b2", "b3", "b4"};
                localSentence = sentence[random.nextInt(sentence.length)];
                break;

            case CustColor.INDIGO:
                sentence = new String[]{"i1", "i2", "i3", "i4"};
                localSentence = sentence[random.nextInt(sentence.length)];
                break;

            case CustColor.PURPLE:
                sentence = new String[]{"p1", "p2", "p3", "p4"};
                localSentence = sentence[random.nextInt(sentence.length)];
                break;
        }
        return localSentence;
    }


    public int getColor() {
        return m_color;
    }

    public String getSentence() {
        return m_sentence;
    }

}
