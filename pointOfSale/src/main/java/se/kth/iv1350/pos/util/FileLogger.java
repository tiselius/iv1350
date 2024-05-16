package main.java.se.kth.iv1350.pos.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Logs exceptions to a file.
 */
public class FileLogger {
    private PrintWriter logFile;
    private static final String LOG_FILE_NAME = "log.txt";

    /**
     * Creates a new instance of a Logger.
     */
    public FileLogger() {
        try {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME, true), true);

        } catch (Exception e) {
            System.err.println("Could not create writer for log file.");
        }
    }

    /**
     * Writes a log entry describing a thrown exception and writes it to a local
     * file.
     * 
     * @param exception The exception that shall be logged.
     */
    public void logException(Exception exception) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
        logFile.println(logMsgBuilder);
        exception.printStackTrace(logFile);
        logFile.println("\n");
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }

}
