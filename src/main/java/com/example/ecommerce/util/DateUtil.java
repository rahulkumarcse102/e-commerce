package com.example.ecommerce.util;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    static DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    static LocalDateTime now = LocalDateTime.now();

    public static @NotNull String getCurrentDateTime(){
        return now.format(format);
    }

}
