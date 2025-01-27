package com.krafttech;

import java.util.Properties;

public class Main3 {
    public static void main(String[] args) {
      //  System.setProperty("browser","chrome");
        System.out.println("System.getProperty(\"browser\") = " + System.getProperty("browser"));

        // Tüm sistem özelliklerini alın
        Properties properties = System.getProperties();

        // Özellikleri yazdır
     //   properties.forEach((key, value) -> System.out.println(key + " = " + value));

        properties.list(System.out);


    }
}
