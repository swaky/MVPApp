package com.swanand.mvpdemo.dagger.modules;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

/**
 * Created by swanand on 9/17/2017.
 */

@Module(includes = {ContextModule.class,NetworkModule.class})
public class PicassoModule {

    @Provides
    public Picasso picasso(Context context, OkHttp3Downloader okHttp3Downloader)
    {
       return new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
    }

    @Provides
    public OkHttp3Downloader okHttp3Downloader(OkHttpClient okHttpClient)
    {
        return new OkHttp3Downloader(okHttpClient);
    }
}
