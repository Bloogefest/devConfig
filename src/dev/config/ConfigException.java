package dev.config;

public class ConfigException extends Exception {
    protected ConfigException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public ConfigException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }

    public ConfigException(String msg) {
        super(msg);
    }

    public ConfigException() {}
}
