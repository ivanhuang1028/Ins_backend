package com.hl.ins.util;


import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final String download_tmp_path = "D:/temp/download/temp/";

    public static final Integer YES_READ = 1;
    public static final Integer NO_READ = 0;

    public static final Integer MSG_TYPE_CHARACTER = 1;
    public static final Integer MSG_TYPE_FACE = 2;
    public static final Integer MSG_TYPE_PIC = 3;
    public static final Integer MSG_TYPE_VIDEO = 4;
    public static final Integer MSG_TYPE_TOPIC = 5;

    public static final String DIC_LABEL = "label";

    public static final List<String> TOPIC_TYPES = new ArrayList<>();


    static {
        TOPIC_TYPES.add("PIC");
        TOPIC_TYPES.add("VIDEO");
    }


}
