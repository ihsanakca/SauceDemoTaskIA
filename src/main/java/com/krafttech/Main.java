package com.krafttech;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class Main {
    public static void main(String[] args) throws AWTException {

        double db=12.99,db1=25.99,db3=8.99, db4;

        db4=db+db1-db3;
        System.out.println("db4 = " + db4);

        String s = String.valueOf(db4);
        double db5=Double.parseDouble(s.substring(0,4));
        System.out.println("db5 = " + db5);

        DecimalFormat df=new DecimalFormat("#.##");

        DecimalFormatSymbols dfs=new DecimalFormatSymbols();
        dfs.setDecimalSeparator('.');
        df.setDecimalFormatSymbols(dfs);

        String format1 = df.format(db4);
        System.out.println("format1 = " + format1);


        Robot robot=new Robot();

        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_A);

    }
}