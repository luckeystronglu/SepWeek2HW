package com.qf.flag;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qf.adapter.RecommendAdapter;
import com.qf.entity.NewsEntity;
import com.qf.sepweek2hw.R;
import com.qf.util.Constant;
import com.qf.util.DownUtil;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by lenovo on 2016/9/10.
 */
public class RecommendedFragment extends Fragment implements DownUtil.OnDownListener {
    @Bind(R.id.lv_recomm)
    ListView lvRecomm;
    private RecommendAdapter adapter;


    public static RecommendedFragment getInstance(int cat){
        RecommendedFragment fragment = new RecommendedFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("cat",cat);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.flagment_recommended, null);
        ButterKnife.bind(this, view);

        adapter = new RecommendAdapter(getActivity());
        lvRecomm.setAdapter(adapter);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        int cat = bundle.getInt("cat");
        loadDatas(cat);

    }

    private void loadDatas(int cat) {
        String url = String.format(Constant.NEWS_URL, cat);
        new DownUtil().setOnDownListener(this).downJSON(url);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public Object paresJson(String json) {
        if (json != null) {
            try {
                JSONArray ja = new JSONObject(json).getJSONArray("infos");
                TypeToken<List<NewsEntity>> tt = new TypeToken<List<NewsEntity>>(){};
                return new Gson().fromJson(ja.toString(),tt.getType());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void downSucc(Object object) {
        if (object != null){
            List<NewsEntity> list = (List<NewsEntity>) object;
            adapter.setDatas(list);
        }
    }
}
