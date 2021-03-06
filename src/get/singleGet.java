package get;

import helper.printValues;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
public class singleGet {

    public static void main(String[] args) throws IOException {

        Configuration conf = HBaseConfiguration.create();
        Connection connection = ConnectionFactory.createConnection(conf);
        Table table = connection.getTable(TableName.valueOf("notifications"));

        Get get =new Get(Bytes.toBytes("2"));

        get.addColumn(Bytes.toBytes("attributes"), Bytes.toBytes("type"));
        get.addColumn(Bytes.toBytes("metrics"), Bytes.toBytes("open"));

        Result result = table.get(get);

        byte[] val= result.getValue(Bytes.toBytes("attributes"), Bytes.toBytes("type"));
        System.out.println("Value:" + Bytes.toString(val));

        printValues.printAllValues(result);

    }




}
