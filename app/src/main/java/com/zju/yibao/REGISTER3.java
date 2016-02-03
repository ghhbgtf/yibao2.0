package com.zju.yibao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by hmw on 2016/2/2.
 */
public class REGISTER3 extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView title;
    private Button registerEnd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
        initView();
    }
    private void initView() {
        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        title = (TextView) findViewById(R.id.tv_title);
        title.setText("注册");

        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        registerEnd = (Button) findViewById(R.id.btn_registerEnd);
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
}
