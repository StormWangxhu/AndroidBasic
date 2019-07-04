package com.stormwangxhu.androidbasic.service.servicedemo;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * 提供一个计算数值的服务
 */
public class MyServiceByBind extends Service {

    private int result = 0;

    private MyBinder binder = new MyBinder();

    class MyBinder extends Binder {
        public int sum(int a, int b) {
            result = a + b;
            Log.e("MyServiceByBind:", "sum=" + result);
            Toast.makeText(MyServiceByBind.this, "a=" + a + ",b=" + b + " sumResult=" + result, Toast.LENGTH_SHORT).show();
            return result;
        }

        public int reduce(int a, int b) {
            result = a - b;
            Log.e("MyServiceByBind:", "reduce=" + result);
            Toast.makeText(MyServiceByBind.this, "a=" + a + ",b=" + b + " reduceResult=" + result, Toast.LENGTH_SHORT).show();
            return result;
        }

        public void showUserInfo(User user) {
            Integer uid = user.getId();
            Integer age = user.getAge();
            String username = user.getName();
            Log.e("MyServiceByBind:", "user=" + user);
            Toast.makeText(MyServiceByBind.this, "User{ uid = " + uid + ",age = " + age + ",username=" + username, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
}
