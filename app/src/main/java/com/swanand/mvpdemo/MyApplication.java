package com.swanand.mvpdemo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;


import com.squareup.picasso.Picasso;
import com.swanand.mvpdemo.api.ApiInterface;
import com.swanand.mvpdemo.dagger.components.DaggerStackApplicationComponent;
import com.swanand.mvpdemo.dagger.modules.ContextModule;

import com.swanand.mvpdemo.dagger.modules.NetworkModule;
import com.swanand.mvpdemo.dagger.modules.PicassoModule;
import com.swanand.mvpdemo.dagger.components.StackApplicationComponent;
import com.swanand.mvpdemo.dagger.modules.StackApplicationModule;

import timber.log.Timber;

/**
 * Created by swanand on 9/15/2017.
 */

public class MyApplication extends Application {
   public static MyApplication get(Activity activity)
   {
       return (MyApplication) activity.getApplication();
   }

    private ApiInterface apiInterface;
    private Picasso picasso;
    @Override
    public void onCreate() {
        super.onCreate();


        Context context=this;


        Timber.plant(new Timber.DebugTree());


        StackApplicationComponent component= DaggerStackApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .stackApplicationModule(new StackApplicationModule())
                .networkModule(new NetworkModule())
                .picassoModule(new PicassoModule())
                .build();

        apiInterface=component.getApiInterface();

        picasso=component.getPicasso();

    }

    public ApiInterface getApiInterface()
    {
        return apiInterface;
    }
    public Picasso getPicasso()
    {
        return picasso;
    }

}
