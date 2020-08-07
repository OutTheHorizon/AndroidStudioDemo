package com.horizon.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.Observer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * @author androiddeveloper
 */
public class RetrofitDemo1 extends AppCompatActivity {
    final String LOG = "Horizon";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_demo1);

        /**
         * 创建Retrofit实例
         */
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                //设置数据解析器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                //设置网络请求的Url地址
                .baseUrl("https://gank.io/api/v2/banners/")
                .build();
        // 创建 网络请求接口 的实例
        final GetRequest_Interface request = retrofit.create(GetRequest_Interface.class);
        //对 发送请求 进行封装
        Call<Reception> call = request.getCall();

        Reception reception ;
        //异步请求
        call.enqueue(new Callback<Reception>() {
            //请求成功时回调
            @Override
            public void onResponse(Call<Reception> call, Response<Reception> response) {
                Reception reception = response.body();
                if(reception!=null) {
                    reception = response.body();
                    System.out.println("链接成功");
                }
                //请求处理,输出结果
//                response.body().show();
            }
            //请求失败时候的回调
            @Override
            public void onFailure(Call<Reception> call, Throwable throwable) {
                System.out.println("连接失败");
            }
        });

        //同步请求
//        try {
//            Response<Reception> response = call.execute();
//            response.body().show();
//        } catch (IOException e) {
//            Log.d("H","H");
//            e.printStackTrace();
//        }
    }
}
