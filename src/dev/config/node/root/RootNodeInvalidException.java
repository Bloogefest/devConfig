package dev.config.node.root;

public class RootNodeInvalidException extends RootNodeException {
    protected RootNodeInvalidException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeInvalidException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeInvalidException(Throwable cause) {
        super(cause);
    }

    public RootNodeInvalidException(String msg) {
        super(msg);
    }

    public RootNodeInvalidException() {}
}
