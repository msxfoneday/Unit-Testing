package com.example.chuanjiang.unittest381;

/**
 * @author chuan.jiang(chuan.jiang@msxf.com)
 */
public class AdvList {
    public final String type;
    public final int priority;
    public final String content;
    public final String filePath;

    public AdvList(String type, int priority, String content, String filePath) {
        this.type = type;
        this.priority = priority;
        this.content = content;
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "AdvList{" +
                "type='" + type + '\'' +
                ", priority=" + priority +
                ", content='" + content + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
