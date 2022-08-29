package com.atguigu.bigdata.spark.core

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

object Test2 {
  def main(args: Array[String]): Unit = {
    val sparkConf =new SparkConf().setMaster("local[*]").setAppName("spark")
    val sparkContext = new SparkContext(sparkConf)
    val dataRDD: RDD[Int] =sparkContext.makeRDD(List(1,2,3,4,5,6,7,8,9),19)
    val fileRDD: RDD[String] =sparkContext.textFile("input/words.txt",2)
    //fileRDD.collect().foreach(println)
    //dataRDD.collect().foreach(println)
    dataRDD.saveAsTextFile("input3");

    sparkContext.stop()
  }
}
