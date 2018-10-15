package com.anton.blockchain.domain;

import com.anton.blockchain.helper.HashUtil;

import java.util.Date;

public class Block {

    private String hash;

    private String previousHash;

    private String data;

    private long timestamp;


    public Block(String previousHash, String data) {
        this.previousHash = previousHash;
        this.data = data;
        this.timestamp = new Date().getTime();
        this.hash = performHash();
    }

    private String performHash() {
        return HashUtil.applySha256(this.previousHash + this.timestamp + this.data);
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getData() {
        return data;
    }

    public long getTimestamp() {
        return timestamp;
    }

}
