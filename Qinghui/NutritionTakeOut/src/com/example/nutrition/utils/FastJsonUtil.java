package com.example.nutrition.utils;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class FastJsonUtil {
	
	public static <T> T json2Object(String jsonStr,Class<T> clz){
		return JSON.parseObject(jsonStr, clz);
	}
	
	public static <T>List<T> getList(String jsonStr,Class<T> cls){
	    return  JSON.parseArray(jsonStr, cls);
	}
	
    public static <T> List<Map<String,Object>> getListMap(String jsonStr, Class<T> clz){
		return JSON.parseObject(jsonStr, new TypeReference<List<Map<String,T>>>(){}.getType());
	}
}
