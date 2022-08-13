package dev.config.node.root.builder;

import dev.config.ConfigFlow;
import dev.config.ConfigLanguage;
import dev.config.annotation.Inject;
import dev.config.annotation.Save;
import dev.config.node.object.ObjectNode;
import dev.config.node.root.RootNode;

import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.util.LinkedHashMap;

public class RootNodeBuilder<T> {
    protected Path path;
    protected ConfigLanguage language;
    protected ConfigFlow flow;
    protected Save save;

    protected Class<T> type;
    protected Constructor<T> constructor;
    protected final LinkedHashMap<String, ObjectNode<?>> nodes;

    public RootNodeBuilder(LinkedHashMap<String, ObjectNode<?>> nodes) throws RootNodeBuilderNodeException {
        if (nodes == null) throw new RootNodeBuilderNodeException();
        this.nodes = nodes;
    }

    public RootNodeBuilder(int capacity, float factor) {
        nodes = new LinkedHashMap<>(capacity, factor);
    }

    public RootNodeBuilder() {
        nodes = new LinkedHashMap<>();
    }

    public RootNodeBuilder<T> path(Path path) {
        this.path = path;
        return this;
    }

    public RootNodeBuilder<T> language(ConfigLanguage language) {
        this.language = language;
        return this;
    }

    public RootNodeBuilder<T> flow(ConfigFlow flow) {
        this.flow = flow;
        return this;
    }

    public RootNodeBuilder<T> save(Save save) {
        this.save = save;
        return this;
    }

    public RootNodeBuilder<T> save(Class<T> type) {
        this.type = type;
        return this;
    }

    public RootNodeBuilder<T> constructor(Constructor<T> constructor) {
        this.constructor = constructor;
        return this;
    }

    public RootNodeBuilder<T> node(String name, ObjectNode<?> node) throws RootNodeBuilderNodeException {
        if (node == null || node instanceof RootNode<?>) throw new RootNodeBuilderNodeException();
        nodes.put(name, node);
        return this;
    }

    public RootNode<T> build() throws RootNodeBuilderPathException, RootNodeBuilderLanguageException, RootNodeBuilderFlowException, RootNodeBuilderSaveException, RootNodeBuilderTypeException, RootNodeBuilderConstructorException {
        if (path == null) throw new RootNodeBuilderPathException();
        if (language == null) throw new RootNodeBuilderLanguageException();
        if (flow == null) throw new RootNodeBuilderFlowException();
        if (save == null) throw new RootNodeBuilderSaveException();
        if (type == null) throw new RootNodeBuilderTypeException();
        if (constructor == null || !constructor.isAnnotationPresent(Inject.class)) throw new RootNodeBuilderConstructorException();
        return new RootNode<>(path, language, flow, save, type, constructor, nodes);
    }
}
