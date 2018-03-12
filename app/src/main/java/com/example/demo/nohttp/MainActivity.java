package com.example.demo.nohttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.demo.nohttp.Interface.HttpListener;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity implements HttpListener {

    @BindView(R.id.mList)
    public ListView mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //请求数据
        initData();
    }

    private void initData() {
        String url = "http://v.juhe.cn/toutiao/index?type=top&key=b0c1a57febbe49da8940dc820c2d8e43";
        //创建请求对象,设置加载的网络路径和请求
        Request<String> request = NoHttp.createStringRequest(url, RequestMethod.GET);
        //获取核心的NoHttp网络工具类对象
        CallServer callServer = CallServer.getRequestInstance();
        //把队列添加进去
        callServer.add(this, 0, request, this, true, true);

    }

    @Override
    public void onSuccesed(int what, Response response) {
        System.out.println(response.get());
    }

    @Override
    public void onFailed(int what, Response response) {

    }
}
