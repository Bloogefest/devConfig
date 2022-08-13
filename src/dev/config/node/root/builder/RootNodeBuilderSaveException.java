package dev.config.node.root.builder;

public class RootNodeBuilderSaveException extends RootNodeBuilderException {
    protected RootNodeBuilderSaveException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeBuilderSaveException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeBuilderSaveException(Throwable cause) {
        super(cause);
    }

    public RootNodeBuilderSaveException(String msg) {
        super(msg);
    }

    public RootNodeBuilderSaveException() {}
}
