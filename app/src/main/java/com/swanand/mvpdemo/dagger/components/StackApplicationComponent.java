package com.swanand.mvpdemo.dagger.components;

import com.squareup.picasso.Picasso;
import com.swanand.mvpdemo.api.ApiInterface;
import com.swanand.mvpdemo.dagger.modules.PicassoModule;
import com.swanand.mvpdemo.dagger.modules.StackApplicationModule;

import dagger.Component;

/**
 * Created by swanand on 9/16/2017.
 */

@Component(modules = {StackApplicationModule.class,PicassoModule.class})
public interface StackApplicationComponent {
    Picasso getPicasso();
    ApiInterface getApiInterface();
}
