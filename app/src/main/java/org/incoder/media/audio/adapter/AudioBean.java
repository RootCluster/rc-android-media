package org.incoder.media.audio.adapter;

/**
 * AudioBean
 *
 * @author : Jerry xu    date : 2018/10/30  15:30
 * @version : 1.0.0
 */
public class AudioBean {

    private String fileName;
    private int type;
    private long fileSize;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }
}
