package com.xiaoyuanpe.units;

public class HasRole {
    public static boolean hasOneRole(boolean[] booleans){
        Boolean b = false;
        for (int i=0;i<booleans.length;i++){
            if (booleans[i]==true){
                b=true;
                break;
            }
        }
        return b;
    }
}
