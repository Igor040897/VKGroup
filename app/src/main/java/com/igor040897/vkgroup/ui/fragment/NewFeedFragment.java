package com.igor040897.vkgroup.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.igor040897.vkgroup.MyApplication;
import com.igor040897.vkgroup.R;
import com.igor040897.vkgroup.common.BaseAdapter;
import com.igor040897.vkgroup.model.WallItem;
import com.igor040897.vkgroup.model.view.NewsFeedItemBodyViewModel;
import com.igor040897.vkgroup.rest.api.WallApi;
import com.igor040897.vkgroup.rest.model.request.WallGetRequestModel;
import com.igor040897.vkgroup.rest.model.response.WallGetResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFeedFragment extends BaseFragment {

    @Inject
    WallApi wallApi;

    RecyclerView recyclerView;
    BaseAdapter baseAdapter;

    public NewFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        wallApi.get(new WallGetRequestModel(-86529522).toMap()).enqueue(new Callback<WallGetResponse>() {
            @Override
            public void onResponse(Call<WallGetResponse> call, Response<WallGetResponse> response) {

                List<NewsFeedItemBodyViewModel> list = new ArrayList<NewsFeedItemBodyViewModel>();
                for (WallItem item : response.body().response.getItems()) {
                    list.add(new NewsFeedItemBodyViewModel(item));
                }

                baseAdapter.addItems(list);

                Toast.makeText(getActivity(), "Likes: " + response.body().response.getItems().get(0).getLikes().getCount(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<WallGetResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.fragment_feed;
    }

    @Override
    public int onCreateToolbarTitle() {
        return R.string.screen_name_news;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecyclerView(view);
        setUpAdapter(recyclerView);
    }

    private void setUpRecyclerView(View rootView) {
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    private void setUpAdapter(RecyclerView rv) {
        baseAdapter = new BaseAdapter();
        rv.setAdapter(baseAdapter);
    }
}
