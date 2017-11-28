package com.protobuf.test;

import java.io.IOException;

/**
 * protoc.exe
 * @author ganhaibin
 *
 */
public class GenerareClass {
    public static void main(String[] args) {
        String protoFile = "person-entity.proto";//  
        String strCmd = "C:/Users/Administrator/Documents/GitHub/protobuf-master/src/protoc.exe -I=./proto --java_out=./src/main/java ./proto/"+ protoFile;  
        try {
            Runtime.getRuntime().exec(strCmd);
        } catch (IOException e) {
            e.printStackTrace();
        }//通过执行cmd命令调用protoc.exe程序  
    }
}
