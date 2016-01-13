package com.example.administrator.ceshi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 * Created by Administrator on 2015/12/14.
 */
public class TextSimpleAdapter extends RecyclerView.Adapter<MyViewHolder> implements AbsListView.OnScrollListener{


    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }
    private OnItemClickLitener mOnItemClickLitener;
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;
    private int lastPoition;
    public TextSimpleAdapter(Context context,List<String> datas){
        this.mContext=context;
        this.mDatas=datas;
        mInflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder,final int position) {
        // TODO Auto-generated method stub
        lastPoition = position;
        holder.tv.setText(mDatas.get(position));
        holder.show.setVisibility(View.GONE);
        if (mOnItemClickLitener !=null){
            holder.show_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickLitener.onItemClick(holder.show_item, position);
                }
            });
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
        // TODO Auto-generated method stub
        View view = mInflater.inflate(R.layout.item_single_textview,arg0,false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState==1){

        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}

class MyViewHolder extends ViewHolder{

    TextView tv;
    View show;
    LinearLayout show_item;
    public MyViewHolder(View arg0) {
        super(arg0);
        // TODO Auto-generated constructor stub
        tv = (TextView) arg0.findViewById(R.id.id_tv);
        show = (View)arg0.findViewById(R.id.show);
        show_item = (LinearLayout)arg0.findViewById(R.id.show_item);
    }

}
