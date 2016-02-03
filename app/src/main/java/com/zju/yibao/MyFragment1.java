package com.zju.yibao;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.ToxicBakery.viewpager.transforms.DefaultTransformer;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Atlas on 15/12/16.
 */

public class MyFragment1 extends android.app.Fragment implements AdapterView.OnItemClickListener {

    private View root;

    private ConvenientBanner convenientBanner;
    private ArrayList<Integer> localImages = new ArrayList<>();

    private ListView listView;
    private List<Map<String, Object>> listItems;
    private SimpleAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        convenientBanner.startTurning(5000);
    }

    @Override
    public void onPause() {
        super.onPause();
        convenientBanner.stopTurning();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_1, null);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
        initBanner();
        loadData();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), COURSES.class);
        String class_name = ((TextView) view.findViewById(R.id.text_name)).getText().toString();
        intent.putExtra("class_name", class_name);
        startActivity(intent);
    }

    private void initView() {
        convenientBanner = (ConvenientBanner) root.findViewById(R.id.convenientBanner);
        listView = (ListView) root.findViewById(R.id.list);
        listView.setOnItemClickListener(this);
    }

    private void initBanner() {
        initImageLocal();

        CBViewHolderCreator<LocalImageHolderView> cbViewHolderCreator1 = new CBViewHolderCreator<LocalImageHolderView>() {
            @Override
            public LocalImageHolderView createHolder() {
                return new LocalImageHolderView();
            }
        };

        convenientBanner.setPages(cbViewHolderCreator1, localImages);
        convenientBanner
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.CENTER_HORIZONTAL);
        try {
            convenientBanner.getViewPager().setPageTransformer(true, DefaultTransformer.class.newInstance());
        } catch (Exception e) {
        }
    }

    private void initImageLocal() {
        if (localImages.size() != 0) {
            return;
        }
        for (int position = 0; position < 6; position++) {
            localImages.add(getResId("ic_test_" + position, R.drawable.class));
        }
    }

    public static int getResId(String variableName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void loadData() {
        listItems = new ArrayList<>();

        int[] icons = new int[]{
                R.drawable.class_shengyue,
                R.drawable.class_gangqin,
                R.drawable.class_shoutiqin,
                R.drawable.class_jiazigu,
                R.drawable.class_wudao};

        String[] names = new String[]{"声乐", "钢琴", "手提琴", "架子鼓", "舞蹈"};

        for (int i = 0; i < icons.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("icon", icons[i]);
            item.put("name", names[i]);

            listItems.add(item);
        }

        adapter = new SimpleAdapter(
                getActivity(),
                listItems,
                R.layout.list_item_fragment1,
                new String[]{"icon", "name"},
                new int[]{R.id.image_icon, R.id.text_name});

        listView.setAdapter(adapter);
    }
}
