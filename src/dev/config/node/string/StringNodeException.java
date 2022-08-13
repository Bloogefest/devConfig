package dev.config.node.string;

import dev.config.node.NodeException;

public class StringNodeException extends NodeException {
    protected StringNodeException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public StringNodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public StringNodeException(Throwable cause) {
        super(cause);
    }

    public StringNodeException(String msg) {
        super(msg);
    }

    public StringNodeException() {}
}
