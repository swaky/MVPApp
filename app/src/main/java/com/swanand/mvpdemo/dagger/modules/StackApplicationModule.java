package com.swanand.mvpdemo.dagger.modules;

import com.swanand.mvpdemo.api.ApiInterface;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by swanand on 9/17/2017.
 */

@Module(includes = NetworkModule.class)
public class StackApplicationModule {

    @Provides
    public ApiInterface apiInterface(Retrofit retrofit){
        return retrofit.create(ApiInterface.class);
    }

    @Provides
    public Retrofit retrofit(OkHttpClient okHttpClient)
    {
        return  new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl("https://api.stackexchange.com/2.2/")
                .build();
    }
}
