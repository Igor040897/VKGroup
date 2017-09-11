package com.igor040897.vkgroup.ui.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.igor040897.vkgroup.model.view.BaseViewModel;

/**
 * Created by fanre on 9/9/2017.
 */

public abstract class BaseViewHolder<Item extends BaseViewModel> extends RecyclerView.ViewHolder {
    public BaseViewHolder(View itemView) {
        super(itemView);
    }

    public abstract void bindViewHolder(Item item);

    public abstract void unbindViewHolder();
}
