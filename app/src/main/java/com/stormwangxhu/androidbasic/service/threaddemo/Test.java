package com.stormwangxhu.androidbasic.service.threaddemo;

import android.util.Log;

import com.stormwangxhu.androidbasic.service.threaddemo.MyThreadExtendsDemo1;
import com.stormwangxhu.androidbasic.service.threaddemo.MyThreadImplDemo2;

public class Test {
    public static void main(String[] args) {
        MyThreadExtendsDemo1 extendsDemo1 = new MyThreadExtendsDemo1();
        MyThreadImplDemo2 implDemo2 = new MyThreadImplDemo2();
        extendsDemo1.start();
        new Thread(implDemo2).start();
    }
}
