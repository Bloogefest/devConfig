package dev.config.node.array;

import dev.config.node.NodeException;

public class ArrayNodeException extends NodeException {
    protected ArrayNodeException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public ArrayNodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ArrayNodeException(Throwable cause) {
        super(cause);
    }

    public ArrayNodeException(String msg) {
        super(msg);
    }

    public ArrayNodeException() {}
}
