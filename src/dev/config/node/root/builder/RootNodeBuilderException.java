package dev.config.node.root.builder;

import dev.config.node.root.RootNodeException;

public class RootNodeBuilderException extends RootNodeException {
    protected RootNodeBuilderException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeBuilderException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeBuilderException(Throwable cause) {
        super(cause);
    }

    public RootNodeBuilderException(String msg) {
        super(msg);
    }

    public RootNodeBuilderException() {}
}
