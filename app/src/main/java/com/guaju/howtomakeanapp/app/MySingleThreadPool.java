package com.guaju.howtomakeanapp.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by guaju on 2017/7/28.
 */

public class MySingleThreadPool {
    private static MySingleThreadPool mPool=new MySingleThreadPool();
    private static ExecutorService threadPool;

    private MySingleThreadPool(){
        threadPool = Executors.newSingleThreadExecutor();
    }
    public static ExecutorService getInstance(){
        return threadPool;
    }

}
