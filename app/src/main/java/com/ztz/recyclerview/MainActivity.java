package com.ztz.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;
import com.ztz.recyclerview.activity.ShopCartActivity;
import com.ztz.recyclerview.adapter.MyreyAdapter;
import com.ztz.recyclerview.bean.MusicBean;
import com.ztz.recyclerview.presenter.RecyPresenter;
import com.ztz.recyclerview.view.RecyViewCallBack;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyViewCallBack {
    private SpringView spring_view;
    private RecyclerView recycler_view;
    private RecyPresenter presenter;
    private MyreyAdapter adapter;
    private int a=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化控件
        initView();
        //recyclerview
        recycler_view.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        adapter = new MyreyAdapter(this);
        recycler_view.setAdapter(adapter);
        recycler_view.addItemDecoration(new DividerItemDecoration(this,1));
        //与presenter交互
        presenter = new RecyPresenter(this);
        presenter.RequestData(a);
        //springview
        spring_view.setHeader(new DefaultHeader(this));
        spring_view.setFooter(new DefaultFooter(this));
        spring_view.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                //刷新
                if (a == 1) {
                    Toast.makeText(MainActivity.this,"没有最新数据了",Toast.LENGTH_SHORT).show();
                }else{
                    a = 1;
                    presenter.RequestData(a);
                }
                //停止刷新
                spring_view.onFinishFreshAndLoad();
                //刷新适配器
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadmore() {
                //加载
                a = a+3;
                presenter.RequestData(a);
                //停止加载
                spring_view.onFinishFreshAndLoad();
                //刷新适配器
                adapter.notifyDataSetChanged();
            }
        });
        //recyclerview的条目点击事件----点击跳转到购物车
        adapter.setItemOnClickListener(new MyreyAdapter.MyItemOnClickListener() {
            @Override
            public void onItemOnClick(View view, int postion) {
                Toast.makeText(MainActivity.this,"点击了item"+postion,Toast.LENGTH_SHORT).show();
                //跳转
                startActivity(new Intent(MainActivity.this, ShopCartActivity.class));
            }
        });

    }
    private void initView() {
        spring_view = findViewById(R.id.spring_view);
        recycler_view = findViewById(R.id.recycler_view);
    }

    //获取到的数据
    @Override
    public void success(MusicBean musicBean) {
        Log.i("-------------------",musicBean.getSong_list().get(1).getAlbum_title());
        List<MusicBean.SongListBean> list = musicBean.getSong_list();
        adapter.addData(list);
        //添加完数据,进行一次刷新
        adapter.notifyDataSetChanged();
    }

    @Override
    public void failed(Exception e) {
        Log.i("-------------------","失败");
    }
}
