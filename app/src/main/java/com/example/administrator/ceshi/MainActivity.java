package com.example.administrator.ceshi;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView 打造横向 listview
 */
public class MainActivity extends Activity{

    MainActivity mActivity;
    private RecyclerView id_recyclerView;
    private List<String> mDatas;
    private TextSimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mActivity = this;
        initDatas();
        initView();
        mAdapter = new TextSimpleAdapter(this,mDatas);
        id_recyclerView.setAdapter(mAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        id_recyclerView.setLayoutManager(linearLayoutManager);
        mAdapter.setOnItemClickLitener(new TextSimpleAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                View viewLine = view.findViewById(R.id.show);
                viewLine.setVisibility(View.VISIBLE);
                Toast.makeText(mActivity,mDatas.get(position),Toast.LENGTH_SHORT).show();
                mAdapter.notifyDataSetChanged();
            }
        });
    }


    private void initView() {
        id_recyclerView = (RecyclerView) findViewById(R.id.id_recyclerView);
    }


    private void initDatas() {
        // TODO Auto-generated method stub
        mDatas  = new ArrayList<String>();
        for (int i = 'A'; i <= 'z'; i++) {
            mDatas.add((char)i+"");
        }
    }
}
