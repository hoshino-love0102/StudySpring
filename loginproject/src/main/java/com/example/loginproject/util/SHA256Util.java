package com.example.loginproject.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Util {
    public static String encode(String text) {
        return DigestUtils.sha256Hex(text);
    }
}
