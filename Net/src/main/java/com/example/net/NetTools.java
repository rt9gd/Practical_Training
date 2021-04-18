package com.example.net;

import android.text.TextUtils;

import com.example.net.api.TokenApi;
import com.example.net.entity.TokenRespEntity;
import com.example.net.utils.ConstValue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 */
public class NetTools {

    private Retrofit mRetrofit;
    private NetTools(){
        createRetrofit();
    }
    private volatile static NetTools instance=null;
    public static NetTools getInstance(){
        if (null==instance){
            synchronized (NetTools.class){
                if(null==instance){
                    instance=new NetTools();
                }
            }
        }
        return instance;
    }

    private void createRetrofit(){
        mRetrofit=new Retrofit.Builder().client(createClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(BuildConfig.SERVER_URL)
                .build();
    }

    private OkHttpClient createClient() {
        return new OkHttpClient.Builder()
                .readTimeout(ConstValue.TIMEOUT_VALUE, TimeUnit.SECONDS)
                .writeTimeout(ConstValue.TIMEOUT_VALUE, TimeUnit.SECONDS)
                .connectTimeout(ConstValue.TIMEOUT_VALUE, TimeUnit.SECONDS)
                .addNetworkInterceptor(createNetworkInterceptor())
                .addInterceptor(createTokenInterceptor())
                .build();
    }

    private Interceptor createTokenInterceptor() {
        Interceptor interceptor= new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                if(checkHttpCode401(response)){
                    String token = requestToken();
                    if(TextUtils.isEmpty(token)){
                        throw  new RuntimeException("Token is null...");
                    }
                    Request.Builder authorization = request.newBuilder().addHeader("Authorization", "bearer " + token);
                    Request newRequest = authorization.build();
                    return chain.proceed(newRequest);
                }
                return response;
            }
        };
        return interceptor;
    }

    private boolean checkHttpCode401(Response response){
        if(null==response){
            return false;
        }
        if(response.code()==401){
            return true;
        }
        else{
            return false;
        }
    }

    private String requestToken(){
        TokenApi tokenApi = create(TokenApi.class);
        Call<TokenRespEntity> tokenService = tokenApi.getToken("password", ConstValue.AUTHCODE, "");
        try {
            retrofit2.Response<TokenRespEntity> result = tokenService.execute();
            if (result!=null && result.body()!=null){
                return result.body().getAccess_token();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    private Interceptor createNetworkInterceptor() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return interceptor;
    }

    public <T> T create(Class<?> clazz){
        return (T) mRetrofit.create(clazz);
    }

}
