package main.java.se.kth.iv1350.pos.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Logs exceptions to the console.
 */
public class ConsoleLogger {

    /**
     * Writes a log entry describing a thrown exception and prints it to the
     * console.
     * 
     * @param exception The exception that shall be logged.
     */
    public void logException(Exception exception) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Exception was thrown: ");
        logMsgBuilder.append(exception.getMessage());
//        logMsgBuilder.append(exception);
        System.err.println(logMsgBuilder.toString());
    }

    public void logTotalRevenue(Double totalRevenue) {
        StringBuilder logMsgBuilder = new StringBuilder();
        logMsgBuilder.append(createTime());
        logMsgBuilder.append(", Total revenue after previous sale: ");
        logMsgBuilder.append(totalRevenue);
        logMsgBuilder.append("\n");
        System.out.println(logMsgBuilder.toString());
    }

    private String createTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        return now.format(formatter);
    }

}