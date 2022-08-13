package dev.config.node.root;

public class RootNodeNotAllowedException extends RootNodeException {
    protected RootNodeNotAllowedException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeNotAllowedException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeNotAllowedException(Throwable cause) {
        super(cause);
    }

    public RootNodeNotAllowedException(String msg) {
        super(msg);
    }

    public RootNodeNotAllowedException() {}
}
