package com.books.testUtil;


/**
 * 单例最完美的写法，懒加载，线程安全，可防止反序列化
 * 注意：枚举类不可反射
 */
public enum Singleton {

    INSTANCE;



    public static void main(String[] args) {

        // lmd表达式写法
        new Thread(()->{
            for (int i = 0; i <100 ; i++) {
               System.out.println(Singleton.INSTANCE.hashCode());
            }
        }).start();

        // 普通写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <100 ; i++) {
                    System.out.println(Singleton.INSTANCE.hashCode());
                }
            }
        }).start();

    }
}
