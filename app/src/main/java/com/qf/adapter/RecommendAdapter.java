package com.qf.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.qf.entity.NewsEntity;
import com.qf.sepweek2hw.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/9/10.
 */
public class RecommendAdapter extends BaseAdapter {
    private Context context;
    private List<NewsEntity> datas;

    public RecommendAdapter(Context context) {
        this.context = context;
        this.datas = new ArrayList<>();
    }

    public void setDatas(List<NewsEntity> datas){
        this.datas = datas;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item_news, null);
            holder.tvSubject = (TextView) convertView.findViewById(R.id.tv_subject);
            holder.tvSummary = (TextView) convertView.findViewById(R.id.tv_summary);
            holder.readCount = (TextView) convertView.findViewById(R.id.readCount);
            holder.shareCount = (TextView) convertView.findViewById(R.id.shareCount);
            holder.praiseCount = (TextView) convertView.findViewById(R.id.praiseCount);
            holder.ivNewspic = (ImageView) convertView.findViewById(R.id.iv_newspic);
            convertView.setTag(holder);
        }
        holder.tvSubject.setText(datas.get(position).getTitle());
        holder.tvSummary.setText(datas.get(position).getContent());
        holder.readCount.setText(datas.get(position).getReadCount() +"");
        holder.shareCount.setText(datas.get(position).getShareCount() +"");
        holder.praiseCount.setText(datas.get(position).getPraiseCount() +"");


        String photo = datas.get(position).getPhoto();
        String[] strings = photo.split("/");
        //图片接口有问题
        Glide.with(context)
                .load("http://ft-info.fit-time.cn/" + strings[1])
                .into(holder.ivNewspic);
        return convertView;
    }


    class ViewHolder {

        ImageView ivNewspic;

        TextView tvSubject,tvSummary,readCount,shareCount,praiseCount;


//        @Bind(R.id.iv_newspic)
//        ImageView ivNewspic;
//        @Bind(R.id.tv_subject)
//        TextView tvSubject;
//        @Bind(R.id.tv_summary)
//        TextView tvSummary;
//        @Bind(R.id.readCount)
//        TextView readCount;
//        @Bind(R.id.shareCount)
//        TextView shareCount;
//        @Bind(R.id.praiseCount)
//        TextView praiseCount;
//
//        ViewHolder(View view) {
//            ButterKnife.bind(this, view);
//        }
    }
}
