package dev.config;

import dev.config.node.root.RootNode;

public class Config<T> { // TODO: 13.08.2022 CONFIG
    protected final RootNode<T> node;
    private T source;

    public Config(RootNode<T> node, T source) {
        this.node = node;
        this.source = source;
    }

    public Config<T> update() {
        // TODO: 12.08.2022 UPDATE LOGIC
        return this;
    }

    public Config<T> repair() {
        // TODO: 12.08.2022 REPAIR LOGIC
        return this;
    }

    public Config<T> save() {
        // TODO: 12.08.2022 SAVE LOGIC
        return this;
    }

    public Config<T> reset() {
        // TODO: 12.08.2022 RESET LOGIC 
        return this;
    }

    public RootNode<T> node() {
        return node;
    }

    public T source() {
        return source;
    }
}
