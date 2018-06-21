package com.smsimulator.core;

/**
 * Project UCD_FinalProject_SAVICK
 * Created by skaveesh on 2018-06-21.
 */
public class Debugger {

    private static final boolean isLoggerEnabled = true;

    public static void log(Object o) {
        if (isLoggerEnabled)
            System.out.println(o.toString());
    }

}
