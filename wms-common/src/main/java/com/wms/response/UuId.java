package com.wms.response;

import java.util.UUID;

public class UuId {
    public static String getUUID(){
        UUID uuid=UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }

    public static void main(String[] args) {
        System.err.println(getUUID());
    }
}
