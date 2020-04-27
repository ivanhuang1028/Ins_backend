package com.hl.ins.util;

import org.jxls.builder.xls.XlsCommentAreaBuilder;
import org.jxls.common.Context;
import org.jxls.util.JxlsHelper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

public class JxlsUtils {
    static{
        XlsCommentAreaBuilder.addCommandMapping("merge", MergeCommand.class);
    }
    public  static void export(HttpServletResponse response,String templatePath,String fileName, Context context){
        OutputStream os= null;
        try {
            os = response.getOutputStream();
            response.setContentType("application/x-ms-excel");
            String filename = URLEncoder.encode(fileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment; filename=" + filename);
            InputStream is= JxlsUtils.class.getResourceAsStream(templatePath);
            JxlsHelper.getInstance().processTemplate(is, os, context);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
