package com.guaju.howtomakeanapp.activity;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
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
import com.guaju.howtomakeanapp.fragment.ChatFragment;
import com.guaju.howtomakeanapp.fragment.MainFragment;
import com.guaju.howtomakeanapp.fragment.MineFragment;
import com.guaju.howtomakeanapp.httputils.OkHttpUtils;
import com.guaju.howtomakeanapp.utils.DialogUtils;
import com.guaju.howtomakeanapp.utils.PackageUtils;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/* 如何去开发一款app
   1.这个app是做什么的？
     {
     一、是一个电商、购物网站的app

         0、注册、登录
         1、商品的展示
         2、排序
         3、动画
         4、缓存
         5、支付
         6、定位
         7、订单信息
         8、聊天
         9、版本更新
         10、应用发布

     二、新闻资讯类的
         0、注册、登录
         1、新闻分类展示（Fragment嵌套Fragment来展示分类新闻）
         2、点赞，收藏，评论
         3、个人中心（签到，积分，积分兑换，vip）
         4、版本更新
         5、应用发布
     三、O2O(美团外卖、快方、叮当快药，滴滴打人，uber)
         0、登录注册（短信验证码）
         1、商品展示（分类）
         2、购物车
         3、支付
         4、定位，地图
         5、聊天客服/评论、催单、投诉等
         6、推送
         7、个人中心（积分、优惠券、兑换、vip）
         8、版本更新
         9、应用发布
      四、金融（理财产品）
          0、登录注册（短信验证码）
          1、商品展示（分类）（自定义控件）
          2、支付（银联或者别的银行的，一般不会有支付宝、微信）
          4、定位
          5、聊天客服
          6、推送（少部分会有）
          7、个人中心（积分、优惠券、兑换、vip）
          8、加密
          9、版本更新
          10、应用发布

     五、智能硬件（连接一款设备：手环、XX检测器、XX遥控器）
          0、登录注册（少有）
          1、蓝牙、红外、或者wifi连接硬件设备
          2、使用java调用c/c++（jni技术）调用硬件提供的方法（c/c++）(ndk)
          3、拿到硬件获得的数据，进行展示，然后做出相应的操作
          9、版本更新
          10、应用发布
     六、直播项目
         核心点：推流拉流，弹幕，礼品赠送


     }

     运行到手机上的app，必须有签名


 */
public class MainActivity extends BaseActivity {
    String path="https://guaju.github.io/versioninfo.json";
    private String currentVersion;
    private String version;
    private UpdateAppBean.DataBean data;
    private FragmentTabHost fth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkUpdate();
        initView();




    }

    private void initView() {


        fth = (FragmentTabHost) findViewById(android.R.id.tabhost);
        //关联内容
        fth.setup(this,getSupportFragmentManager(),android.R.id.tabcontent);
        TabHost.TabSpec mainSpec = fth.newTabSpec("home").setIndicator(getBottomIndicator("首页",R.drawable.selector_main));
        TabHost.TabSpec chatSpec = fth.newTabSpec("chat").setIndicator(getBottomIndicator("聊天",R.drawable.selector_chat));
        TabHost.TabSpec mineSpec = fth.newTabSpec("mine").setIndicator(getBottomIndicator("个人中心",R.drawable.selector_mine));
        fth.addTab(mainSpec, MainFragment.class,null);
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
        //创建builder对象
        Request.Builder builder = new Request.Builder();
        Request request = builder.get()
                .url(path)
                .build();
        //得到call对象
        Call call = OkHttpUtils.getInstance().newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
               runOnUiThread(new Runnable() {
                   @Override
                   public void run() {
                Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();

                   }
               });
            }

            @Override
            public void onResponse(Response response) throws IOException {
//                int code = response.code();
//                if (200==code){
//                    Toast.makeText(MainActivity.this, "成功", Toast.LENGTH_SHORT).show();
//                }
                if (response.isSuccessful()){
                    String json = response.body().string();
                    parseJson(json);
                }


            }
        });

    }

    private void parseJson(String json) {

        if (TextUtils.isEmpty(json)){
            return;
        }
        Gson gson=new Gson();
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
