package com.swanand.mvpdemo.dagger.modules;

import android.content.Context;

import com.swanand.mvpdemo.dagger.scopes.StackApplicationScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by swanand on 9/17/2017.
 */
@Module
public class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @StackApplicationScope
    public Context context(){
        return context;
    }
}
