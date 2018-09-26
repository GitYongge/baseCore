package com.costech.util;

import java.util.UUID;

/**
 * @ClassName: UuidUtil
 * @description:
 * @author: yangy
 * @create: 2018-09-17 10:34
 **/

public class UuidUtil {
    public static String get32UUID() {
        String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
        return uuid;
    }
    public static void main(String[] args) {
        System.out.println(get32UUID());
    }
}
