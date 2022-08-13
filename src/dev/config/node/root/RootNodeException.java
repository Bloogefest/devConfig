package dev.config.node.root;

import dev.config.node.NodeException;

public class RootNodeException extends NodeException {
    protected RootNodeException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeException(Throwable cause) {
        super(cause);
    }

    public RootNodeException(String msg) {
        super(msg);
    }

    public RootNodeException() {}
}
