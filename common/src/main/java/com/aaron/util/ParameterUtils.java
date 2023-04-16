package com.aaron.util;

import java.util.*;

public class ParameterUtils {
    public static List<Parameter> list(Parameter... parameters) {
        List<Parameter> parameterList = new ArrayList<Parameter>();
        for (int i = 0; i < parameters.length; i++) {
            parameterList.add(parameters[i]);
        }
        return parameterList;
    }

    public static void sort(List<Parameter> parameters) {
        Collections.sort(parameters);
    }

    public static String concat(List<Parameter> parameters) {
        StringBuffer sb = new StringBuffer();
        boolean first = true;
        for (Parameter parameter : parameters) {
            if (first) {
                first = false;
            } else {
                sb.append("&");
            }
            sb.append(parameter.getName() + "=" + parameter.getValue());
        }
        return sb.toString();
    }


    public static Map<String, String> sort(Map<String, String> parameters) {
        Map<String, String> map = new TreeMap<String, String>();
        Iterator<Map.Entry<String, String>> iterator = parameters.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            map.put(entry.getKey(), entry.getValue());
        }
        return map;
    }

    public static String concat(Map<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        Iterator<Map.Entry<String, String>> iterator = parameters.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            sb.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
