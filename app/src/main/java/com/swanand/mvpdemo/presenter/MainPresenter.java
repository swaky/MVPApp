package com.swanand.mvpdemo.presenter;

import com.swanand.mvpdemo.view.MainView;

/**
 * Created by swanand on 1/28/2017.
 */

public class MainPresenter {

    private final MainView mainView;
    public MainPresenter(MainView mainView) {

        this.mainView = mainView;
    }

    public void onButtonClick(){
        mainView.openNewWindow();
    }


}
