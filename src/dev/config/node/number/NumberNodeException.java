package dev.config.node.number;

import dev.config.node.NodeException;

public class NumberNodeException extends NodeException {
    protected NumberNodeException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public NumberNodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public NumberNodeException(Throwable cause) {
        super(cause);
    }

    public NumberNodeException(String msg) {
        super(msg);
    }

    public NumberNodeException() {}
}
