package com.swanand.mvpdemo.presenter;

import android.test.mock.MockContext;

import com.swanand.mvpdemo.view.MainView;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by swanand on 1/29/2017.
 */

public class MainPresenterTest {

    private MainPresenter mainPresenter;

    @Before
    public void setUp() throws Exception{
        mainPresenter=new MainPresenter();
    }

    @Test
    public void testLaunchActivityOnClick(){

        MainView mainView=mock(MainView.class);
        mainPresenter.onButtonClick(mainView);
        verify(mainView).openNewWindow();
    }
}
