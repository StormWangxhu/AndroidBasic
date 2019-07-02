package com.stormwangxhu.androidbasic.listviewdemo;


import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.stormwangxhu.androidbasic.R;
import com.stormwangxhu.androidbasic.commom.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class ListViewDemoActivity extends BaseActivity {

    private String[] data = {"Apple", "Banana", "Orange", "Whatmelo", "Pear", "Grape", "Pineapple", "Chery", "Mango"};

    private List<Fruit> fruitList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_demo);
        initFruits();
        FruitAdapter fruitAdapter = new FruitAdapter(ListViewDemoActivity.this, R.layout.listview_fruit_item, fruitList);
        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(fruitAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(ListViewDemoActivity.this, fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit apple = new Fruit("Apple", R.drawable.fruit_1);
            fruitList.add(apple);
            Fruit banana = new Fruit("Banana", R.drawable.fruit_2);
            fruitList.add(banana);
            Fruit orange = new Fruit("Orange", R.drawable.fruit_3);
            fruitList.add(orange);
            Fruit watermalon = new Fruit("Watermelo", R.drawable.fruit_4);
            fruitList.add(watermalon);
            Fruit pear = new Fruit("Pear", R.drawable.fruit_5);
            fruitList.add(pear);
            Fruit chery = new Fruit("Chery", R.drawable.fruit_6);
            fruitList.add(chery);
            Fruit mango = new Fruit("Mango", R.drawable.fruit_7);
            fruitList.add(mango);
        }
    }


}
