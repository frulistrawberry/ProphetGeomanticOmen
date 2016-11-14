package com.xianzhifengshui.adapter;

import com.xianzhifengshui.R;
import com.xianzhifengshui.api.model.TopicEvaluate;
import com.xianzhifengshui.common.ItemViewDelegate;
import com.xianzhifengshui.common.RecyclerViewHolder;

/**
 * 作者: chengx
 * 日期: 2016/11/14.
 * 描述:
 */
public class TopicDetailEvaluateItemDelegate implements ItemViewDelegate<Object> {
    @Override
    public int getItemLayoutId() {
        return R.layout.item_topic_detail_evaluate;
    }

    @Override
    public boolean isForViewType(Object o, int position) {
        return o instanceof TopicEvaluate;
    }

    @Override
    public void convert(RecyclerViewHolder holder, Object o, int position) {

    }
}
