package com.linuxea.contravariance;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Log {

    public static void main(String[] args) {
        List<String> messages = Arrays.asList("Hello, world!", "This is a log message.");

        LogProcessor<ConsoleLogger> consoleLogProcessor = new LogProcessor<>(new ConsoleLogger());
        Consumer<Logger> loggerConsumer = logger -> logger.log("Processed: " + messages);

        consoleLogProcessor.processLogMessages(loggerConsumer);

        LogProcessor<FileLogger> fileLogProcessor = new LogProcessor<>(new FileLogger());
        fileLogProcessor.processLogMessages(loggerConsumer);
    }

    public interface Logger {

        void log(String message);
    }

    public static class ConsoleLogger implements Logger {

        @Override
        public void log(String message) {
            System.out.println("Console: " + message);
        }
    }

    public static class FileLogger implements Logger {

        @Override
        public void log(String message) {
            System.out.println("File: " + message);
        }
    }

    public static class LogProcessor<T extends Logger> {

        private final T logger;

        public LogProcessor(T logger) {
            this.logger = logger;
        }

        public void processLogMessages(Consumer<? super T> logConsumer) {
            logConsumer.accept(logger);
        }
    }


}
