package dev.config.node.root;

import dev.config.ConfigFlow;
import dev.config.ConfigLanguage;
import dev.config.annotation.*;
import dev.config.node.object.ObjectNode;

import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class RootNode<T> extends ObjectNode<LinkedHashMap<String, ObjectNode<?>>> {
    protected final Path path;
    protected final ConfigLanguage language;

    protected final Class<T> type;
    protected final Constructor<T> constructor;

    public RootNode(Path path, ConfigLanguage language, ConfigFlow flow, Save save, Class<T> type, Constructor<T> constructor, LinkedHashMap<String, ObjectNode<?>> value) {
        super(flow, save, value);

        this.path = path;
        this.language = language;

        this.type = type;
        this.constructor = constructor;
    }

    public RootNode(Path path, ConfigLanguage language, ConfigFlow flow, Class<T> type, Constructor<T> constructor, Save save) {
        this(path, language, flow, save, type, constructor, new LinkedHashMap<>());
    }

    public boolean add(String name, ObjectNode<?> node) throws RootNodeInvalidException, RootNodeNotAllowedException {
        if (name == null || name.isBlank() || node == null) throw new RootNodeInvalidException();
        if (node instanceof RootNode<?>) throw new RootNodeNotAllowedException();
        return value.putIfAbsent(name, node) == null;
    }

    public ObjectNode<?> remove(String name) throws RootNodeInvalidException {
        if (name == null || name.isBlank()) throw new RootNodeInvalidException();
        return value.remove(name);
    }

    public boolean contains(String name) throws RootNodeInvalidException {
        if (name == null || name.isBlank()) throw new RootNodeInvalidException();
        return value.containsKey(name);
    }

    public boolean contains(ObjectNode<?> node) throws RootNodeInvalidException, RootNodeNotAllowedException {
        if (node == null) throw new RootNodeInvalidException();
        if (node instanceof RootNode<?>) throw new RootNodeNotAllowedException();
        return value.containsValue(node);
    }

    public void clear() {
        value.clear();
    }

    public int size() {
        return value.size();
    }

    public boolean empty() {
        return value.isEmpty();
    }

    public Path config() {
        return path;
    }

    public ConfigLanguage language() {
        return language;
    }

    public Class<T> type() {
        return type;
    }

    public Constructor<T> constructor() {
        return constructor;
    }
}
