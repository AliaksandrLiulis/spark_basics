package com.example.spark;

import org.apache.spark.sql.*;

import static org.apache.spark.sql.functions.col;

public class Example6_GroupBySum {

    private static final String CSV_URL = "bonus.csv";

    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder().master("local[*]").getOrCreate();

        Dataset<Row> csv = spark.read().format("csv")
                .option("sep", ",")
                .option("inferSchema", "true")
                .option("header", "true")
                .load(CSV_URL);

        csv.groupBy(col("deposit type")).sum("amount").show();

        spark.stop();
    }
}