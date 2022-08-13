package dev.config.node.root.builder;

public class RootNodeBuilderLanguageException extends RootNodeBuilderException {
    protected RootNodeBuilderLanguageException(String msg, Throwable cause, boolean suppression, boolean writable) {
        super(msg, cause, suppression, writable);
    }

    public RootNodeBuilderLanguageException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public RootNodeBuilderLanguageException(Throwable cause) {
        super(cause);
    }

    public RootNodeBuilderLanguageException(String msg) {
        super(msg);
    }

    public RootNodeBuilderLanguageException() {}
}
