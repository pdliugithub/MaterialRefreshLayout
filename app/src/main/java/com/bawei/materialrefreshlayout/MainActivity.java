package com.bawei.materialrefreshlayout;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.cjj.MaterialRefreshLayout;
import com.cjj.MaterialRefreshListener;
import com.cjj.MaterialWaveView;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private MaterialRefreshLayout mMaterialRefresh;
    private static Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.id_listView);
        mMaterialRefresh = (MaterialRefreshLayout) findViewById(R.id.refresh);
        mMaterialRefresh.setIsOverLay(false);
        mMaterialRefresh.setWaveShow(true);//是否显示波纹效果
        mMaterialRefresh.setWaveColor(0xddff00ff);//波纹的颜色
        mMaterialRefresh.setWaveHeight(MaterialWaveView.DefaulWaveHeight);//波纹的高度
        mMaterialRefresh.setLoadMore(true);//是否支持加载更多

        //设置监听
        mMaterialRefresh.setMaterialRefreshListener(new MaterialRefreshListener() {
            //下拉刷新
            @Override
            public void onRefresh(MaterialRefreshLayout materialRefreshLayout) {

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //结束刷新
                        mMaterialRefresh.finishRefresh();
                    }
                },2000);
            }

            //加载更多
            @Override
            public void onRefreshLoadMore(MaterialRefreshLayout materialRefreshLayout) {
                super.onRefreshLoadMore(materialRefreshLayout);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        //结束刷新
                        mMaterialRefresh.finishRefreshLoadMore();
                    }
                },2000);
            }
        });

        String[] str = new String[]{"哈哈1", "哈哈2", "哈哈3", "哈哈4", "哈哈5", "哈哈6", "哈哈7", "哈哈8","哈哈9","哈哈10","哈哈11","哈哈12","哈哈13","哈哈8",};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, str);
        mListView.setAdapter(adapter);

    }
}
