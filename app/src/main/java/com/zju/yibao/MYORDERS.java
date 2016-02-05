package com.zju.yibao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.zju.yibao.bean.MyOrders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MYORDERS extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private TextView tv_title;
    private ListView listView;
    private MyBaseAdapter adapter;

    private Button btnDelete;
    private Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorders);

        initView();
        loadData();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        tv_title = (TextView) findViewById(R.id.tv_title);
        listView = (ListView) findViewById(R.id.list);

        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("我的购物车");

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnDelete = (Button) findViewById(R.id.btn_delete);
        btnDelete.setOnClickListener(this);
        btnBuy = (Button) findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(this);
    }

    private void loadData() {
        String string = getIntent().getStringExtra("data");
        MyOrders myOrders = JSON.parseObject(string, MyOrders.class);

        for (int i = 0; i < 13; i++) {
            MyOrders.OrdersEntity temp = new MyOrders.OrdersEntity();
            temp.setCourseName("钢琴" + i);
            temp.setTeacherName("李老师");
            temp.setOrganizationName("新东方");
            myOrders.getOrders().add(temp);
        }

        adapter = new MyBaseAdapter(MYORDERS.this, myOrders.getOrders());
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this, "adapter.getIsSelected():" + adapter.getIsSelected(), Toast.LENGTH_SHORT).show();
    }
}
