package com.horizon.retrofit;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;

/**
 * @Author lhh
 * @ClasssName GetRequest_Interface
 * @Description
 * @UpdateDate 2020/8/7 4:11 PM
 */
public interface GetRequest_Interface {
    @GET("openapi.do?keyfrom=abc&key=2032414398&type=data&doctype=json&version=1.1&q=car")
    retrofit2.Call<Reception> getCall();
    // @GET注解的作用:采用Get方法发送网络请求

    // getCall() = 接收网络请求数据的方法
    // 其中返回类型为Call<*>，*是接收数据的类（即上面定义的Translation类）
    // 如果想直接获得Responsebody中的内容，可以定义网络请求返回值为Call<ResponseBody>
}
