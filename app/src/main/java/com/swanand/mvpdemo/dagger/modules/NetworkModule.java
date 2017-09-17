package com.swanand.mvpdemo.dagger.modules;

import android.content.Context;

import com.swanand.mvpdemo.dagger.scopes.StackApplicationScope;

import java.io.File;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by swanand on 9/17/2017.
 */

@Module(includes = ContextModule.class)
public class NetworkModule {

    @Provides
    @StackApplicationScope
    public HttpLoggingInterceptor loggingInterceptor()
    {

        HttpLoggingInterceptor interceptor= new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.i(message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        return interceptor;
    }

    @Provides
    @StackApplicationScope
    public Cache cache(File cachefile)
    {
        return new Cache(cachefile,10*1000*1000); //10MB Cache

    }

    @Provides
    @StackApplicationScope
    public File cachefile(Context context)
    {
        return new File(context.getCacheDir(),"okhttp_cache");

    }

    @Provides
    @StackApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor loggingInterceptor, Cache cache){
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
   }
}
