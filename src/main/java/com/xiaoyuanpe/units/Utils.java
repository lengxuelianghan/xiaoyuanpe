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

    public static String camelToUnderline(String str) {
        if (str == null || str.trim().isEmpty()){
            return "";
        }
        int len = str.length();
        StringBuilder sb = new StringBuilder(len);
        sb.append(str.substring(0, 1).toLowerCase());
        for (int i = 1; i < len; i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                sb.append("_");
                sb.append(Character.toLowerCase(c));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
