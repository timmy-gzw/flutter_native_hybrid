package com.timmy.wireguard;

import android.app.Activity;

import io.flutter.Log;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;

public class FlutterPluginJumpToAct implements MethodChannel.MethodCallHandler {

    public static String CHANNEL = "com.qyh.jump/plugin";
    static MethodChannel channel;
    private Activity activity;

    private FlutterPluginJumpToAct(Activity activity) {
        this.activity = activity;
    }

    /**
     * 此方法需要外界进行调用注册
     *
     * @param registrar
     */
    public static void registerWith(PluginRegistry.Registrar registrar) {

        channel = new MethodChannel(registrar.messenger(), CHANNEL);
        FlutterPluginJumpToAct instance = new FlutterPluginJumpToAct(registrar.activity());
        // setMethodCallHandler在此通道上接收方法调用的回调
        channel.setMethodCallHandler(instance);
    }

    @Override
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        //通过methodCall可以获得参数和方法名，原生这面做对应业务
        //result可以给Flutter设置回调
        // "test1":是Flutter代码设置的调用指令
        if (methodCall.method.equals("test1")) {
            // do something
            Log.d("gzw", methodCall.arguments.toString());
            result.success("suc");
        }
    }
}
