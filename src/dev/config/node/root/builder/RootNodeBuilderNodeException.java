package dev.config.node.root.builder;

public class RootNodeBuilderNodeException extends RootNodeBuilderException {
    protected RootNodeBuilderNodeException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeBuilderNodeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeBuilderNodeException(Throwable cause) {
        super(cause);
    }

    public RootNodeBuilderNodeException(String msg) {
        super(msg);
    }

    public RootNodeBuilderNodeException() {}
}
