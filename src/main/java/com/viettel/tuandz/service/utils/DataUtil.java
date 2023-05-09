package com.viettel.tuandz.service.utils;

import org.apache.commons.lang3.StringUtils;

public class DataUtil {

    public static String makeLikeParam(String s) {
        if (StringUtils.isEmpty(s)) return null;
        return "%" + s + "%";
    }
}
