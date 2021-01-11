package com.xiaoyuanpe.units;

public class Utils {
    public static String IntegerToString(int n){
        if (n>0 && n<10){
            return "00"+n+"_";
        }
        else if(n>=10 && n<100){
            return "0"+n+"_";
        }
        else{
            return ""+n+"_";
        }
    }
}
