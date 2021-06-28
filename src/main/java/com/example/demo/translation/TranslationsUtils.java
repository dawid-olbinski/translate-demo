package com.example.demo.translation;

import com.example.demo.translation.domain.entity.Translation;
import org.springframework.beans.BeanUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

public class TranslationsUtils {


    public static void createTranslations(Object source, Object target, String lang) {

        PropertyDescriptor[] propertyDescriptors = BeanUtils.getPropertyDescriptors(target.getClass());

        for (PropertyDescriptor targetPD : propertyDescriptors) {
            boolean isTranslation = Objects.equals(targetPD.getPropertyType(), Translation.class);
            if (isTranslation) {
                PropertyDescriptor sourcePD = BeanUtils.getPropertyDescriptor(source.getClass(), targetPD.getName());

                if (sourcePD != null) {
                    System.out.println(sourcePD);
                    Method writeMethod = targetPD.getWriteMethod();
                    Method readMethod = sourcePD.getReadMethod();

                    try {
                        String value = (String) readMethod.invoke(source);
                        writeMethod.invoke(target, Translation.createTranslation(value, lang));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        return;
                    }
                }
            }
        }
    }

    public static void createTranslations(Object source, Object target) {
        createTranslations(source, target, "en");
    }
}
