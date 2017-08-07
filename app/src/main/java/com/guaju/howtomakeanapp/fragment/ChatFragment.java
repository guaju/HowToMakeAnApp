package com.guaju.howtomakeanapp.fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import com.guaju.howtomakeanapp.R;
import com.guaju.howtomakeanapp.base.BaseFragment;
import com.guaju.howtomakeanapp.bean.WareHot;
import com.guaju.howtomakeanapp.http.RetrofitUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by guaju on 2017/7/27.
 */


/*
rxjava
是一个使用了观察序列的，能够实现基于事件的异步处理效果

跨线程操作
handler
asynctask
okhttp /volley /retrofit
runOnUiThread


 */



public class ChatFragment extends BaseFragment {
    private static final String TAG = "ChatFragment";
    @Override
    public void initData() {
        initRxJava2();
    }

    private void initRxJava2() {
        Observable.just("hehe").
                observeOn(AndroidSchedulers.mainThread())
                .subscribe(a-> Log.e(TAG, "initRxJava2: "+a));


    }

    private void initRxJava() {
        //1、创建一个oberver观察者
        //2、创建一个被观察者实例
        //3、让被观察者去添加订阅者
        //1 创建一个观察者
       Observer observer=new Observer<WareHot>() {
           @Override
           public void onCompleted() {
               //控制制度条

           }

           @Override
           public void onError(Throwable throwable) {

           }

           @Override
           public void onNext(WareHot s) {
               //做获取到的数据处理
               Log.e(TAG, "onNext: "+s.getCopyright() );

           }
       };
       //2创建一个被观察者
        Observable<WareHot> observable = Observable.create(new Observable.OnSubscribe<WareHot>() {

            @Override
            public void call(final Subscriber<? super WareHot> subscriber) {
                //添加数据
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        RetrofitUtil.getInstance().getWaresHot1(new Callback<WareHot>() {
                            @Override
                            public void onResponse(Call<WareHot> call, Response<WareHot> response) {
                                WareHot body = response.body();
                                subscriber.onNext(body);
//                        subscriber.onCompleted();
                            }

                            @Override
                            public void onFailure(Call<WareHot> call, Throwable throwable) {

                            }
                        });
                    }
                });




            }
        });
        //3添加订阅者,联网获取数据
        observable.subscribeOn(Schedulers.io());//设置在子线程完成 subscribe 操作
        observable.observeOn(AndroidSchedulers.mainThread());//设置在哪完成observe操作
        observable.subscribe(observer);

       // 应该打印什么东西？nihaobuhaoxiexieni

    }

    @Override
    public View initView(LayoutInflater inflater) {
        View v = inflater.inflate(R.layout.fragment_chat, null, false);
        return v;

    }


}
