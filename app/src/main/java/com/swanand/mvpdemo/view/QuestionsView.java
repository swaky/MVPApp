package com.swanand.mvpdemo.view;

import com.swanand.mvpdemo.model.Item;

import java.util.List;

/**
 * Created by swanand on 1/28/2017.
 */

public interface QuestionsView {
    void renderData(List<Item> items);
    void showProgressDialog();
    void dismissProgressDialog();
}
