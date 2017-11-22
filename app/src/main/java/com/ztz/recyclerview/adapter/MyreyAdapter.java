package com.ztz.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ztz.recyclerview.R;
import com.ztz.recyclerview.bean.MusicBean;

import java.util.List;

/**
 * Created by TR on 2017/11/22.
 */
public class MyreyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    public MyreyAdapter(Context context) {
        this.context = context;
    }
    private List<MusicBean.SongListBean> list;
    public void addData(List<MusicBean.SongListBean> list) {
        this.list = list;
    }

    //对Activity暴露
    private MyItemOnClickListener listener;
    public void setItemOnClickListener(MyItemOnClickListener listener){
        this.listener=listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        viewHolder fmListHolder=new viewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_layout,parent,false),listener);
        return fmListHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewHolder holder1 = (viewHolder) holder;
        Glide.with(context).load(list.get(position).getPic_big()).placeholder(R.mipmap.ic_launcher).into(holder1.image_icon);
        holder1.text_name.setText(list.get(position).getArtist_name());
        holder1.text_title.setText(list.get(position).getAlbum_title());
        holder1.text_time.setText(list.get(position).getPublishtime());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 :list.size();
    }
    static class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView image_icon;
        private final TextView text_name;
        private final TextView text_title;
        private final TextView text_time;
        MyItemOnClickListener mListener;
        public viewHolder(View itemView,MyItemOnClickListener myItemOnClickListener) {
            super(itemView);
            image_icon = itemView.findViewById(R.id.image_icon);
            text_name = itemView.findViewById(R.id.text_name);
            text_title = itemView.findViewById(R.id.text_title);
            text_time = itemView.findViewById(R.id.text_time);
            this.mListener=myItemOnClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(mListener!=null){
                mListener.onItemOnClick(view,getPosition());
            }
        }
    }

    //定义接口
    public interface MyItemOnClickListener {
        void onItemOnClick(View view,int postion);
    }



}
