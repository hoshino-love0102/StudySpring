package com.example.loginproject.util;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Util {

    public static boolean matches(String rawPassword, String hashedPassword) {
        return encode(rawPassword).equals(hashedPassword);
    }

    public static String encode(String text) {
        return DigestUtils.sha256Hex(text);
    }
}