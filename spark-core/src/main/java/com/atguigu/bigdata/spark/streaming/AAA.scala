package com.atguigu.bigdata.spark.streaming

import java.util.Random

import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord}
import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.dstream.{DStream, InputDStream, ReceiverInputDStream}
import org.apache.spark.streaming.kafka010.{ConsumerStrategies, KafkaUtils, LocationStrategies}
import org.apache.spark.streaming.receiver.Receiver
import org.apache.spark.streaming.{Seconds, StreamingContext}

object AAA {
  def main(args: Array[String]): Unit = {
    val sparkconf: SparkConf = new SparkConf().setMaster("local[*]").setAppName("AAA")
    val ssc = new StreamingContext(sparkconf,Seconds(3))
    ssc.checkpoint("cp")
    val line: ReceiverInputDStream[String] = ssc.socketTextStream("localhost", 9999)
    val res: DStream[(String, Int)] = line.flatMap(_.split(" ")).map((_,1)).reduceByKey(_+_)
    val res2: DStream[(String, Int)] = line.flatMap(_.split(" ")).map((_, 1)).updateStateByKey(
      (seq: Seq[Int], buff: Option[Int]) => {
        val newCount = buff.getOrElse(0) + seq.sum
        Option(newCount)
      }
    )
    //res2//Seq[V], Option[S]) => Option[S]
    res.print()
    res2.print(13)
    ssc.start()
    ssc.awaitTermination()

  }
}
