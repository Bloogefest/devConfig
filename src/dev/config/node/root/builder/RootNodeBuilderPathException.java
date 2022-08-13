package dev.config.node.root.builder;

public class RootNodeBuilderPathException extends RootNodeBuilderException {
    protected RootNodeBuilderPathException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeBuilderPathException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeBuilderPathException(Throwable cause) {
        super(cause);
    }

    public RootNodeBuilderPathException(String msg) {
        super(msg);
    }

    public RootNodeBuilderPathException() {}
}
