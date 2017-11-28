package com.example.administrator.big_student_zuoye.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by Administrator on 2017/11/27.
 */
public class Tuitls {

    private static Class<?> oClass;
    private static Type superclass;
    private static Type[] arguments;

    public static <T>T getT(Object o, int i){

        try {
            oClass = o.getClass();
            superclass = oClass.getGenericSuperclass();
            arguments = ((ParameterizedType) superclass).getActualTypeArguments();
            Type type = arguments[i];
            return ((Class<T>)type).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
