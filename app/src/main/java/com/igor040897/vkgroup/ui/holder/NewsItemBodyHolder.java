package com.igor040897.vkgroup.ui.holder;

import android.view.View;
import android.widget.TextView;

import com.igor040897.vkgroup.R;
import com.igor040897.vkgroup.model.view.NewsFeedItemBodyViewModel;

/**
 * Created by fanre on 9/11/2017.
 */

public class NewsItemBodyHolder extends BaseViewHolder<NewsFeedItemBodyViewModel> {

    public TextView text;

    public NewsItemBodyHolder(View itemView) {
        super(itemView);
        text = (TextView) itemView.findViewById(R.id.tv_text);
    }

    @Override
    public void bindViewHolder(NewsFeedItemBodyViewModel newsFeedItemBodyViewModel) {
        text.setText(newsFeedItemBodyViewModel.getText());
    }

    @Override
    public void unbindViewHolder() {
        text.setText(null);
    }
}
