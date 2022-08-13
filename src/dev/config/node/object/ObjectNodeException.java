package dev.config.node.object;

import dev.config.node.NodeException;

public class ObjectNodeException extends NodeException {
    protected ObjectNodeException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public ObjectNodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public ObjectNodeException(Throwable cause) {
        super(cause);
    }

    public ObjectNodeException(String msg) {
        super(msg);
    }

    public ObjectNodeException() {}
}
