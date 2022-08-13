package dev.config.node;

public class NodeInvalidException extends NodeException {
    protected NodeInvalidException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public NodeInvalidException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public NodeInvalidException(Throwable cause) {
        super(cause);
    }

    public NodeInvalidException(String msg) {
        super(msg);
    }

    public NodeInvalidException() {}
}
