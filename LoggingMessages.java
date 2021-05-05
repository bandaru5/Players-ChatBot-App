package com.chatbot;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

    /*
    *  to write logs in output.log using LoggingMessages class
    */

public class LoggingMessages {

    public static void writeLog(String logText, String className) {

        Logger LOGGER = Logger.getLogger(className);       // write some logs
        try {

            File logDir = new File("./logs/");   //create logs directory if it doesn't exist.
            if (!(logDir.exists()))
                logDir.mkdir();

            /* append logText to output.log */

            FileHandler handler = new FileHandler(logDir + File.separator + "output.log", true);
            handler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(handler);
            LOGGER.info(logText);
            handler.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
