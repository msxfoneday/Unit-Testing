package com.example.chuanjiang.unittest381;


/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class ProDetail {
    public final String content;
    public final String contentType;
    public final String proType;

    public ProDetail(String content, String contentType, String proType) {
        this.content = content;
        this.contentType = contentType;
        this.proType = proType;
    }

    @Override
    public String toString() {
        return "ProDetail{" +
                "content='" + content + '\'' +
                ", contentType='" + contentType + '\'' +
                ", proType='" + proType + '\'' +
                '}';
    }
}
