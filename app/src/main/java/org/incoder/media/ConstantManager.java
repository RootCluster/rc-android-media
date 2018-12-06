package org.incoder.media;

/**
 * ConstantManager
 *
 * @author : Jerry xu
 * @date : 2018/10/31  10:30
 */
public interface ConstantManager {

    /**
     * 音频录制权限
     */
    int PERMISSIONS_REQUEST_AUDIO = 0;
    /**
     * 系统录音
     */
    int SYSTEM_VOICE_RESULT_CODE = 0;
    /**
     * 系统录像
     */
    int SYSTEM_VIDEO_RESULT_CODE = 1;
    /**
     * 系统拍照
     */
    int SYSTEM_CAMERA_RESULT_CODE = 2;
    /**
     * 系统相册选择
     */
    int SYSTEM_ALBUM_RESULT_CODE = 3;
}
