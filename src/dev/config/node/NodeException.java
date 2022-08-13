package dev.config.node;

import dev.config.ConfigException;

public class NodeException extends ConfigException {
    protected NodeException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public NodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public NodeException(Throwable cause) {
        super(cause);
    }

    public NodeException(String msg) {
        super(msg);
    }

    public NodeException() {}
}
