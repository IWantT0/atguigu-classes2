package com.atguigu.bigdata.spark.core.rdd.builder

import org.apache.spark.{SparkConf, SparkContext}

object Spark03_RDD_File_Par3 {

    def main(args: Array[String]): Unit = {

        // TODO 准备环境
        val sparkConf = new SparkConf().setMaster("local[*]").setAppName("RDD")
        val sc = new SparkContext(sparkConf)

        // 如果数据源为多个文件，那么计算分区时以文件为单位进行分区
        val rdd = sc.textFile("datas/file1/word.txt", 3)
         //13/2=6 ...1  0 6 12 13
        rdd.saveAsTextFile("output")
        // TODO 关闭环境
        sc.stop()
    }
}
