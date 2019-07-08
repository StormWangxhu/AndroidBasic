package com.stormwangxhu.androidbasic.service.threaddemo;


public class MyThreadExtendsDemo1 extends Thread {

    @Override
    public void run() {
        System.out.println("Start Thread By Extends...");
        super.run();
    }
}
