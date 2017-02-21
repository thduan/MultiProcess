package com.tihi.multiprocess.Util;

import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @description FastJson解析工具类， 大数据量解析时比Gson快很多倍
 * @author duantianhui
 * @date   2016-10-11 14:04:48
 */
public class FastJson {
	public static String toJSONString(Object object) {
		return JSON.toJSONString(object);
	}

	public static String toJSONString(List<?> object) {
		return JSON.toJSONString(object);
	}

	public static JSONObject parseObject(String text) {
		return JSON.parseObject(text);
	}

	public static JSONArray parseArray(String text) {
		return JSON.parseArray(text);
	}

	public static <T> T parseObject(String text, Class<T> clazz) {
		if(TextUtils.isEmpty(text)) {
			return null;
		}
		return JSON.parseObject(text, clazz);
	}

	public static <T> List<T> parseArray(String text, Class<T> clazz) {
		if(TextUtils.isEmpty(text) || text.equalsIgnoreCase("{}")){
			return new ArrayList<T>();
		}
		return JSON.parseArray(text, clazz);
	}
}
