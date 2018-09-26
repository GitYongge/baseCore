package com.costech.util

import com.alibaba.druid.proxy.jdbc.ClobProxyImpl

import javax.servlet.http.HttpServletRequest

/**
 * @ClassName: PageData
 * @description: 参数封装Map
 * @author: yangy
 * @create: 2018-09-17 17:22
 * */
class PageData  extends HashMap implements Map{

    Map map = null
    HttpServletRequest request
    PageData(HttpServletRequest request){
        this.request = request
        Map properties = request.getParameterMap()
        Map returnMap = new HashMap()
        Iterator entries = properties.entrySet().iterator()
        Map.Entry entry
        String name
        String value
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next()
            name = (String) entry.getKey()
            Object valueObj = entry.getValue()
            if(null == valueObj){
                value = ""
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj
                for(int i=0;i<values.length;i++){
                    value = values[i] + ","
                }
                value = value.substring(0, value.length()-1)
            }else{
                value = valueObj.toString()
            }
            returnMap.put(name, value)
        }
        map = returnMap
    }

    PageData() {
        map = new HashMap()
    }

    @Override
    Object get(Object key) {
        Object obj
        if(map.get(key) instanceof Object[]) {
            Object[] arr = (Object[])map.get(key)
            obj = request == null ? arr:(request.getParameter((String)key) == null ? arr:arr[0])
        } else {
            obj = map.get(key)
        }
        return obj
    }

    String getString(Object key) {
        return (String)get(key)
    }

    @SuppressWarnings("unchecked")
    @Override
    Object put(Object key, Object value) {
        if(value instanceof ClobProxyImpl){ 			//读取oracle Clob类型数据
            try {
                ClobProxyImpl cpi = (ClobProxyImpl)value
                Reader is = cpi.getCharacterStream() 	//获取流
                BufferedReader br = new BufferedReader(is)
                String str = br.readLine()
                StringBuffer sb = new StringBuffer()
                while(str != null){						//循环读取数据拼接到字符串
                    sb.append(str)
                    sb.append("\n")
                    str = br.readLine()
                }
                value = sb.toString()
            } catch (Exception e) {
                e.printStackTrace()
            }
        }
        return map.put(key, value)
    }

    @Override
    Object remove(Object key) {
        return map.remove(key)
    }

    void clear() {
        map.clear()
    }

    boolean containsKey(Object key) {
        return map.containsKey(key)
    }

    boolean containsValue(Object value) {
        return map.containsValue(value)
    }

    Set entrySet() {
        return map.entrySet()
    }

    boolean isEmpty() {
        return map.isEmpty()
    }

    Set keySet() {
        return map.keySet()
    }

    void putAll(Map t) {
        map.putAll(t)
    }

    int size() {
        return map.size()
    }

    Collection values() {
        return map.values()
    }

}
