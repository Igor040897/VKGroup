package com.igor040897.vkgroup.model.view;

import android.view.View;

import com.igor040897.vkgroup.model.WallItem;
import com.igor040897.vkgroup.ui.holder.BaseViewHolder;
import com.igor040897.vkgroup.ui.holder.NewsItemBodyHolder;

/**
 * Created by fanre on 9/11/2017.
 */

public class NewsFeedItemBodyViewModel extends BaseViewModel {

    private int id;

    private String text;

    public NewsFeedItemBodyViewModel(WallItem wallItem) {
        this.id = wallItem.getId();
        this.text = wallItem.getText();
    }

    @Override
    public LayoutTypes getType() {
        return LayoutTypes.NewsFeedItemBody;
    }

    @Override
    protected BaseViewHolder onCreateViewHolder(View view) {
        return new NewsItemBodyHolder(view);
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }
}
