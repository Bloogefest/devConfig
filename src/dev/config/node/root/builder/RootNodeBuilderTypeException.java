package dev.config.node.root.builder;

public class RootNodeBuilderTypeException extends RootNodeBuilderException {
    protected RootNodeBuilderTypeException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeBuilderTypeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeBuilderTypeException(Throwable cause) {
        super(cause);
    }

    public RootNodeBuilderTypeException(String msg) {
        super(msg);
    }

    public RootNodeBuilderTypeException() {}
}
