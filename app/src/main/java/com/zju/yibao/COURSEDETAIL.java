package com.zju.yibao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zju.yibao.bean.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class COURSEDETAIL extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView tv_title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        initView();

        String json = getIntent().getStringExtra("data");
        Course course = JSON.parseObject(json, Course.class);

        fillData(course);
        fillComment(course);

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
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_title.setText("课程详情");

        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void fillData(Course course) {
        fillString(course.getCourseName(), R.id.tv_course_name);
        fillString(course.getTeacherName(), R.id.tv_course_teacher);
        fillString(course.getOrganizationName(), R.id.tv_course_organization);
        fillString(course.getCourseDesc(), R.id.tv_course_desc);

        fillString(course.getTeacherName(), R.id.tv_teacher_name);
//        fillString(course.getTeacherName(), R.id.tv_teacher_name);
        fillString(course.getEducation(), R.id.tv_teacher_academic);
        fillString(String.valueOf(course.getSeniority()), R.id.tv_teacher_seniority);
        fillString(course.getDescription(), R.id.tv_teacher_description);

        fillString(course.getOrganizationName(), R.id.tv_organization_name);
        fillString(course.getOrganizationDescription(), R.id.tv_organization_desc);

    }

    private void fillString(String string, int id) {
        ((TextView) findViewById(id)).setText(string);
    }

    private void fillComment(Course course) {
        ListView listView = (ListView) findViewById(R.id.list_comment);

        List<Map<String, Object>> listItems = new ArrayList<>();

        String[] strings = new String[]{"studentName", "comment", "studentHeadPortraits", "starLevel"};
        int[] to = {R.id.tv_studentName, R.id.tv_comment, R.id.img_studentHeadPortraits, R.id.rating_starLevel};

        for (int i = 0; i < course.getCourseCommentViews().size(); i++) {
            Map<String, Object> item = new HashMap<>();
            item.put(strings[0], course.getCourseCommentViews().get(i).getStudentName());
            item.put(strings[1], course.getCourseCommentViews().get(i).getComment());
            item.put(strings[2], R.drawable.user);
            item.put(strings[3], course.getCourseCommentViews().get(i).getStarLevel());

            listItems.add(item);
        }

        MySimpleAdapter adapter = new MySimpleAdapter(
                COURSEDETAIL.this,
                listItems,
                R.layout.list_item_comment,
                strings,
                to
        );

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height *= course.getCourseCommentViews().size();
        listView.setLayoutParams(params);

        listView.setAdapter(adapter);
    }

}
