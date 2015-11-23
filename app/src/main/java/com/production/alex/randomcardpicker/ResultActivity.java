package com.production.alex.randomcardpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ResultActivity extends AppCompatActivity {
    ImageView img;

    int intColor, intColor2, intColor3;
    String strSentence, strSentence2, strSentence3;
    String strType;

    ViewPager viewPager;
    View view1, view2, view3;
    List<View> viewList;

    CustColor custColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
    }

    void init() {
        custColor = new CustColor();
        float scale = getResources().getDisplayMetrics().density;

        //init UI component
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        LayoutInflater inflater = getLayoutInflater();

        //decompose Intent data
        Intent it = getIntent();
        strType = it.getExtras().getString(Main.TYPE_TAG);

        assert strType != null;
        if (strType.equals(Main.PICK_ONE)) {
            ImageView img;
            TextView txt;

            intColor = it.getExtras().getInt(Main.COLOR_TAG[0]);
            strSentence = it.getExtras().getString(Main.SENTENCE_TAG[0]);

            //create one view
            view1 = inflater.inflate(R.layout.card1, null);
            img = (ImageView) view1.findViewById(R.id.image1);
            txt = (TextView) view1.findViewById(R.id.txt1);
            img.setBackgroundColor(custColor.getColorHex(intColor));
            txt.setTextSize(50 * scale);
            txt.setText(strSentence);

            viewList = new ArrayList<>();
            viewList.add(view1);
        } else if (strType.equals(Main.PICK_THREE)) {
            ImageView img1, img2, img3;
            TextView txt, txt2, txt3;

            intColor = it.getExtras().getInt(Main.COLOR_TAG[0]);
            intColor2 = it.getExtras().getInt(Main.COLOR_TAG[1]);
            intColor3 = it.getExtras().getInt(Main.COLOR_TAG[2]);

            strSentence = it.getExtras().getString(Main.SENTENCE_TAG[0]);
            strSentence2 = it.getExtras().getString(Main.SENTENCE_TAG[1]);
            strSentence3 = it.getExtras().getString(Main.SENTENCE_TAG[2]);

            //create three view
            view1 = inflater.inflate(R.layout.card1, null);
            img1 = (ImageView) view1.findViewById(R.id.image1);
            txt = (TextView) view1.findViewById(R.id.txt1);
            img1.setBackgroundColor(custColor.getColorHex(intColor));
            txt.setTextSize(50 * scale);
            txt.setText(strSentence);


            view2 = inflater.inflate(R.layout.card2, null);
            img2 = (ImageView) view2.findViewById(R.id.image2);
            txt2 = (TextView) view2.findViewById(R.id.txt2);
            img2.setBackgroundColor(custColor.getColorHex(intColor2));
            txt2.setTextSize(50 * scale);
            txt2.setText(strSentence2);

            view3 = inflater.inflate(R.layout.card3, null);
            img3 = (ImageView) view3.findViewById(R.id.image3);
            txt3 = (TextView) view3.findViewById(R.id.txt3);
            img3.setBackgroundColor(custColor.getColorHex(intColor3));
            txt3.setTextSize(50 * scale);
            txt3.setText(strSentence3);


            viewList = new ArrayList<>();
            viewList.add(view1);
            viewList.add(view2);
            viewList.add(view3);
        }

        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_share:
                Intent it = new Intent();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    PagerAdapter pagerAdapter = new PagerAdapter() {
        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(viewList.get(position));
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    };
}
