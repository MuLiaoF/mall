package com.books.token.controller;

import lombok.Data;

@Data
public class TokenTestModel {
    private String mid;
    private String msg_signature;
    private String timestamp;
    private String nonce;
    private String encrypt_type;
    private String requestContent;
    private String appid;
}
