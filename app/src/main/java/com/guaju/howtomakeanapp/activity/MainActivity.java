package com.guaju.howtomakeanapp.activity;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.guaju.howtomakeanapp.R;
import com.guaju.howtomakeanapp.base.BaseActivity;
import com.guaju.howtomakeanapp.bean.UpdateAppBean;
import com.guaju.howtomakeanapp.event.InfoEvent;
import com.guaju.howtomakeanapp.fragment.ChatFragment;
import com.guaju.howtomakeanapp.fragment.MainFragment2;
import com.guaju.howtomakeanapp.fragment.MineFragment;
import com.guaju.howtomakeanapp.httputils.BaseCallBack;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;
import com.guaju.howtomakeanapp.utils.DialogUtils;
import com.guaju.howtomakeanapp.utils.PackageUtils;
import com.guaju.howtomakeanapp.utils.SimpleImageLoader;
import com.guaju.howtomakeanapp.widget.TabFragmentHost;

import org.greenrobot.eventbus.EventBus;
import org.zackratos.ultimatebar.UltimateBar;

import java.io.IOException;

import okhttp3.Response;


public class MainActivity extends BaseActivity {
    String path="https://guaju.github.io/versioninfo.json";
    private String currentVersion;
    private String version;
    private UpdateAppBean.DataBean data;
    private TabFragmentHost fth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UltimateBar ultimateBar = new UltimateBar(this);
        ultimateBar.setTransparentBar(Color.BLUE, 50);

        checkUpdate();
        initView();



    }

    private void initView() {


        fth = (TabFragmentHost) findViewById(android.R.id.tabhost);
        //关联内容
        fth.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        TabHost.TabSpec mainSpec = fth.newTabSpec("home").setIndicator(getBottomIndicator("首页",R.drawable.selector_main));
        TabHost.TabSpec chatSpec = fth.newTabSpec("chat").setIndicator(getBottomIndicator("聊天",R.drawable.selector_chat));
        TabHost.TabSpec mineSpec = fth.newTabSpec("mine").setIndicator(getBottomIndicator("个人中心",R.drawable.selector_mine));
        fth.addTab(mainSpec, MainFragment2.class,null);
        fth.addTab(chatSpec, ChatFragment.class,null);
        fth.addTab(mineSpec, MineFragment.class,null);


    }

    private View getBottomIndicator(String title,int drawable) {
//        BottomIndicator bottomIndicator = new BottomIndicator(this);
//        bottomIndicator.setTextAndImage(title,drawable);
//        return bottomIndicator;
        View v = LayoutInflater.from(this).inflate(R.layout.main_indicator,null,false);
        TextView tv = (TextView) v.findViewById(R.id.tv);
        ImageView iv= (ImageView) v.findViewById(R.id.iv);
        tv.setText(title);
        iv.setBackgroundResource(drawable);
        return v;

    }

    private void checkUpdate() {
        OkHttpUtils.getInstance().get(path, null, new BaseCallBack() {
            @Override
            public void onError() {

            }

            @Override
            public void onSuccess(Response response) {
                if (response.isSuccessful()){
                    String json = null;
                    try {
                        json = response.body().string();
                        parseJson(json);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            @Override
            public void onFailed() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });





    }
    public void send(View v){


        EventBus.getDefault().post(new InfoEvent("小明",8,"96区生命宝珠"));

        try {
            SimpleImageLoader.getInsance().removeFromDisk("https://n.sinaimg.cn/tech/crawl/20170226/yrbm-fyawhqy2124261.jpg");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void parseJson(String json) {

        if (TextUtils.isEmpty(json)){
            return;
        }
        Gson gson=OkHttpUtils.getGson();
        UpdateAppBean updateBean = gson.fromJson(json, UpdateAppBean.class);
        if ("200".equals(updateBean.getStatus())){
            data = updateBean.getData();
            version = data.getVersion();
            try {
                currentVersion = PackageUtils.getCurrentVersion(MainActivity.this);
            } catch (PackageManager.NameNotFoundException e) {
                e.printStackTrace();
            }
            if (!TextUtils.isEmpty(version)){
                 if (!version.equals(currentVersion)){
                     //需要下载app
                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                        DialogUtils.showUpdateDialog(MainActivity.this,"版本更新", data.getInfo(), data.getAppurl());
                         }
                     });
//                     DownLoader.downLoadAndInstallApk(MainActivity.this,data.getAppurl());
                 }
            }

        }

    }
}
