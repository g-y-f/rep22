package com.gyf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUntils {
    //日期类型装换为字符串
    public static String date2String(Date date, String pat){
        SimpleDateFormat S=new SimpleDateFormat(pat);
        String format = S.format(date);
        return format;
    }
    //字符串类型转换为日期类型
    public static Date string2Date(String str,String pat) throws ParseException {
        SimpleDateFormat S=new SimpleDateFormat(pat);
        Date parse = S.parse(str);
        return parse;
    }
}
