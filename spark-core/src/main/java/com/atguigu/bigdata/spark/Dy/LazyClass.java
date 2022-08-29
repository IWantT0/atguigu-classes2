package com.atguigu.bigdata.spark.Dy;

public class LazyClass {
    static final int i=5 ;
    public static void main(String[] args) {


    }
}
class Lazy{

    private Lazy() {
    }
    private static Lazy lazy = new Lazy();

    public static Lazy getInstance() {
        return lazy;
    }
}
