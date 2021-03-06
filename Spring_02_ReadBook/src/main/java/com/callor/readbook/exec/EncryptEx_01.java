package com.callor.readbook.exec;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class EncryptEx_01 {
    public static void main(String[] args) {
        // 암호화, 복구화를 도와주는 class.?
        StandardPBEStringEncryptor pbe = new StandardPBEStringEncryptor();


        String salt = "!Biz1234";
        // SHA-128, SHA-256, SHA-512, SHA-1024
        // 암호화 방식으로 MD5 방식과 DES 방식을 사용하겠다!
        // 24byte 기본으로 사용
        String encPolicy = "PBEWithMD5AndDES";

        pbe.setAlgorithm(encPolicy);
        pbe.setPassword(salt);

        String username = "root";
        String password = "!Biz12341234";
        // 암호화
        String encUserName = pbe.encrypt(username);
        String encPassword = pbe.encrypt(password);

        System.out.printf("user name: %s\n", encUserName);
        System.out.printf("password: %s\n", encPassword);

        // 복구화
        // 최소한 24!(Byte)만큼 반복된다.
        // Bit로는 (24 * 8)!(Bit)
        // String planText = pbe.decrypt(encText);
        // System.out.println(planText); // Korea

    }
}
