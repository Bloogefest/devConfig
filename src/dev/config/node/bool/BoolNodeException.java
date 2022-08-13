package dev.config.node.bool;

import dev.config.node.NodeException;

public class BoolNodeException extends NodeException {
    protected BoolNodeException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public BoolNodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BoolNodeException(Throwable cause) {
        super(cause);
    }

    public BoolNodeException(String msg) {
        super(msg);
    }

    public BoolNodeException() {}
}
