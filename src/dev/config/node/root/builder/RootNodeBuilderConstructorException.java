package dev.config.node.root.builder;

public class RootNodeBuilderConstructorException extends RootNodeBuilderException {
    protected RootNodeBuilderConstructorException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeBuilderConstructorException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeBuilderConstructorException(Throwable cause) {
        super(cause);
    }

    public RootNodeBuilderConstructorException(String msg) {
        super(msg);
    }

    public RootNodeBuilderConstructorException() {}
}
