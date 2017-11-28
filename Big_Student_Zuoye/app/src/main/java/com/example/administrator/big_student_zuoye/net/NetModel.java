package com.example.administrator.big_student_zuoye.net;

import com.example.administrator.big_student_zuoye.app.App;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by TMVPHelper on 2017/11/27
 */
public class NetModel implements NetContract.Model {
    private static NetModel netModel;
    private OkHttpClient okHttpClient;

    public static NetModel getInstance() {
        if (netModel == null) {
            synchronized (NetModel.class) {
                netModel = new NetModel();
            }
        }
        return netModel;
    }

    public NetModel() {
        okHttpClient=new OkHttpClient();
    }

    @Override
    public void getDataFormNet(String url, final Callbacks callbacks) {
        final Request request=new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String string = response.body().string();
                App.baseActivity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        callbacks.succ(string);
                    }
                });
            }
        });
    }
}