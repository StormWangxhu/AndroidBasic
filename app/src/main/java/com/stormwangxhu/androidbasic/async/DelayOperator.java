package com.stormwangxhu.androidbasic.async;

public class DelayOperator {

    //延时操作,用来模拟下载
    void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
