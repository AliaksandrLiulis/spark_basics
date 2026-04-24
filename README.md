# Spark Basics

A hands-on learning project that walks through core Apache Spark SQL concepts using Java.

## Prerequisites

- Java 21
- Maven
- Apache Spark 3.5.3

## Project Structure

```
src/main/java/com/example/spark/
├── Example1_ShowCSV.java          — Load and display CSV data
├── Example2_FilterByName.java     — Filter rows using SQL LIKE expression
├── Example3_FilterByAmount.java   — Filter rows by numeric comparison
├── Example4_FilterFunction.java   — Programmatic filtering with FilterFunction<Row>
├── Example5_UDF.java              — Register and apply a User-Defined Function
├── Example6_GroupBySum.java       — GroupBy with sum aggregation
└── Example7_GroupByAvgWithUDF.java — Combine UDF with GroupBy and average aggregation
```

`bonus.csv` — sample dataset with employee bonus records (name, amount, deposit type).

## Examples

### 1. Show CSV

Loads a CSV file into a DataFrame and prints its contents and schema. Covers `SparkSession` creation, CSV reader options (`header`, `inferSchema`, `sep`), `.show()`, and `.printSchema()`.

### 2. Filter By Name

Filters rows where the name contains a substring using a SQL `LIKE` expression inside `.filter()`.

### 3. Filter By Amount

Filters rows where the bonus amount exceeds a threshold using a numeric comparison in `.filter()`.

### 4. Filter Function

Uses the `FilterFunction<Row>` Java interface to apply custom filtering logic programmatically, accessing column values via `Row.getAs()`.

### 5. User-Defined Function (UDF)

Registers a `UDF1<Integer, String>` that maps deposit type codes (1, 2, 3) to human-readable names. Applies it with `.withColumn()` and `callUDF()`.

### 6. GroupBy Sum

Groups records by deposit type and computes the total bonus amount per group using `.groupBy().sum()`.

### 7. GroupBy Average with UDF

Combines a UDF transformation with aggregation — maps deposit type codes to names, then groups by the new column and calculates the average bonus per deposit type.

## Running

```bash
mvn compile exec:java -Dexec.mainClass="com.example.spark.Example1_ShowCSV"
```

Replace the class name to run a different example.