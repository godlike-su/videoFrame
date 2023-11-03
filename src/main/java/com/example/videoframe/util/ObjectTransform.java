package com.example.videoframe.util;

import com.example.videoframe.exception.ParamerException;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * &#064;Author:  `sujinwang`
 * &#064;Date:  `2022/3/21 21:22`
 * &#064;Version:  1.0
 * &#064;Description:  转换类直接的数据
 */
public class ObjectTransform {

    private ObjectTransform() {
    }

    public static <T> List<T> transform(List<?> list, Class<T> t) {
        List<T> resultList = null;
        if (null != list) {
            resultList = new ArrayList<>(list.size());
            Iterator<?> var4 = list.iterator();

            while (var4.hasNext()) {
                Object element = var4.next();
                resultList.add(transform(element, t));
            }
        }

        return resultList;
    }

    /**
     * 转换entity之间相同命名，相同元素的类
     * @param source
     * @param t
     * @param <T>
     * @return
     */
    public static <T> T transform(Object source, Class<T> t) {
        T target = null;
        if (source != null) {
            try {
                target = t.getDeclaredConstructor().newInstance();
                BeanUtils.copyProperties(source, target);
            } catch (InstantiationException | IllegalAccessException
                     | InvocationTargetException | NoSuchMethodException e) {
                throw new ParamerException("对象转换异常" + e);
            }
        }

        return target;
    }
}
