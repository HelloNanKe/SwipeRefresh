package com.example.nanke.swiperefresh;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<String> mData = new ArrayList<>();
    private MyAdpter adpter;
    private SwipeRefreshLayout refreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        adpter=new MyAdpter(mData);

        RecyclerView.LayoutManager layoutManger=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManger);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,1));
        recyclerView.setAdapter(adpter);
        initRefreshLayout();
    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        refreshLayout= (SwipeRefreshLayout) findViewById(R.id.refreshLayout);
    }
    private void initRefreshLayout(){
        //设置下拉刷新时圆圈的颜色
        refreshLayout.setColorSchemeResources(R.color.colorAccent);
        //设置下拉多长距离出发下拉刷新事件
        refreshLayout.setDistanceToTriggerSync(40);
        refreshLayout.setProgressBackgroundColorSchemeColor(getResources().getColor(R.color.colorPrimaryDark));

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //刷新时添加数据
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<10;i++){
                            //adpter.addData()
                        }
                        
                    }
                },2000);
            }
        });
    }
    private void initData() {
        mData.add("浙江");
        mData.add("温州");
        mData.add("台州");
        mData.add("杭州");
        mData.add("宁波");
        mData.add("慈溪");
        mData.add("凤凰");
        mData.add("义乌");
        mData.add("临海");
        mData.add("临平");
        mData.add("余杭");
        mData.add("浙江");
        mData.add("温州");
        mData.add("台州");
        mData.add("杭州");
        mData.add("宁波");
        mData.add("慈溪");
        mData.add("凤凰");
        mData.add("义乌");
        mData.add("临海");
        mData.add("临平");
        mData.add("余杭");
    }
}
