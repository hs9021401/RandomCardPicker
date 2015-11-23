package com.production.alex.randomcardpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Main extends AppCompatActivity implements View.OnClickListener {
    Button btnOnePick, btnThreePicker;
    static String TYPE_TAG = "TYPE";

    static String[] COLOR_TAG = new String[]{"COLOR", "COLOR2", "COLOR3"};
    static String[] SENTENCE_TAG = new String[]{"SENTENCE", "SENTENCE2", "SENTENCE3"};

    static String PICK_ONE = "PICKONE";
    static String PICK_THREE = "PICKTHREE";

    ArrayList<Integer> selectedColor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    void initComponent() {
        btnOnePick = (Button) findViewById(R.id.onePick);
        btnThreePicker = (Button) findViewById(R.id.oneThree);
        btnOnePick.setOnClickListener(this);
        btnThreePicker.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it;
        selectedColor = new ArrayList<>();
        switch (v.getId()) {
            case R.id.onePick:
                Card card = new Card();
                card.randomGenerate(CustColor.RANDOM);
                it = new Intent(Main.this, ResultActivity.class);
                it.putExtra(TYPE_TAG, PICK_ONE);
                it.putExtra(COLOR_TAG[0], card.getColor());
                it.putExtra(SENTENCE_TAG[0], card.getSentence());
                startActivity(it);
                break;

            case R.id.oneThree:
                Card card3;
                it = new Intent(Main.this, ResultActivity.class);
                it.putExtra(TYPE_TAG, PICK_THREE);

                int index = 0;

                while(selectedColor.size()!=3)
                {
                    card3 = new Card();
                    card3.randomGenerate(CustColor.RANDOM);

                    if(index == 0)
                    {
                        it.putExtra(COLOR_TAG[index], card3.getColor());
                        it.putExtra(SENTENCE_TAG[index], card3.getSentence());
                        selectedColor.add(card3.getColor());
                        index ++;
                    }else
                    {
                        //檢查是否重複
                        if(selectedColor.contains(card3.getColor()))
                        {
                            //如果有重複顏色則不動作, 繼續下一次Random
                        }else
                        {
                            it.putExtra(COLOR_TAG[index], card3.getColor());
                            it.putExtra(SENTENCE_TAG[index], card3.getSentence());
                            selectedColor.add(card3.getColor());
                            index ++;
                        }
                    }
                }

                startActivity(it);
                break;
        }

    }

}
