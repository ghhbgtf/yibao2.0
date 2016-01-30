package com.zju.yibao;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.zju.yibao.bean.Course;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        String json = getIntent().getStringExtra("data");
        Course course = JSON.parseObject(json, Course.class);

        fillData(course);
        fillComment(course);

    }

    private void fillComment(Course course) {
        ListView listView = (ListView) findViewById(R.id.list_comment);
        List<Map<String, Object>> listItems = new ArrayList<>();
        String[] strings = new String[]{"studentName", "comment", "studentHeadPortraits", "starLevel"};
//        String[] strings = new String[]{"studentName", "comment", "studentHeadPortraits"};
        for (int i = 0; i < course.getCourseCommentViews().size(); i++) {
            Map<String, Object> item = new HashMap<>();
            item.put(strings[0], course.getCourseCommentViews().get(i).getStudentName());
            item.put(strings[1], course.getCourseCommentViews().get(i).getComment());
            item.put(strings[2], R.drawable.user);
            item.put(strings[3], course.getCourseCommentViews().get(i).getStarLevel());

            listItems.add(item);
        }
        MySimpleAdapter adapter = new MySimpleAdapter(
                CourseActivity.this,
                listItems,
                R.layout.list_item_comment,
                strings,
                new int[]{R.id.tv_studentName, R.id.tv_comment, R.id.img_studentHeadPortraits, R.id.rating_starLevel}
//                new int[]{R.id.tv_studentName, R.id.tv_comment, R.id.img_studentHeadPortraits}
        );

        ViewGroup.LayoutParams params = listView.getLayoutParams();

        params.height *= course.getCourseCommentViews().size();
        listView.setLayoutParams(params);

        listView.setAdapter(adapter);
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

}