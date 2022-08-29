package com.atguigu.bigdata.spark;


class Sample {
    Sample(String s) {
        System.out.println(s);
    }

    Sample() {
        System.out.println("Sample默认构造函数被调用");
    }
}

class Test {
    static Test test = new Test();
    Sample sam1 = new Sample("sam1成员初始化");//
    int i=10;
    static {
        System.out.println("static2块执行");//
    }

    Sample sam2 = new Sample("sam2成员初始化");//
    static {
        System.out.println("static1块执行");//
    }
    Test(Sample n)//构造器
    {
        System.out.println("Test带参构造函数被调用");//
    }
    Test()//构造器
    {
        System.out.println("Test默认构造函数被调用");//
    }
    //主方法
    public static void main(String str[]) {
        Test a = new Test();//无参构造器
    }

}
