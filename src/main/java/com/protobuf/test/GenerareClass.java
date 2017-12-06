package com.protobuf.test;
import java.io.IOException;

/**
 * protoc.exe
 * @author ganhaibin
 *
 */
public class GenerareClass {
    public static void main(String[] args) {
        String protoFile = "person-entity.proto";
        String path="C:/Users/Administrator/Documents/GitHub/protobuf-master";//项目地址
        String strCmd =path +"/src/protoc.exe -I=./proto --java_out=./src/main/java ./proto/"+ protoFile;  //proto文件地址
        try {
        	//通过执行cmd命令调用protoc.exe程序   
            Runtime.getRuntime().exec(strCmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
      
    }
}
