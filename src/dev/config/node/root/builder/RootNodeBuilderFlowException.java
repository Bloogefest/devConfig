package dev.config.node.root.builder;

public class RootNodeBuilderFlowException extends RootNodeBuilderException {
    protected RootNodeBuilderFlowException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeBuilderFlowException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeBuilderFlowException(Throwable cause) {
        super(cause);
    }

    public RootNodeBuilderFlowException(String msg) {
        super(msg);
    }

    public RootNodeBuilderFlowException() {}
}
