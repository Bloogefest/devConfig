package dev.config;

public final class Config<T> {
    private final Class<T> type;
    private final Metadata<T> metadata;
    private T source;

    private Config(Class<T> type, Metadata<T> metadata, T source) {
        this.type = type;
        this.metadata = metadata;
        this.source = source;
    }

    public static <T> Config<T> config(Class<T> type, Metadata<T> metadata, T source) throws Exception.Type, Exception.Metadata, Exception.Source {
        if (type == null) throw new Exception.Type();
        if (metadata == null) throw new Exception.Metadata();
        if (source != null && source.getClass() != type) throw new Exception.Source();
        return new Config<>(type, metadata, source);
    }

    public static <T> Config<T> config(Class<T> type, T source) throws Exception.Type, Exception.Metadata, Exception.Source, Metadata.Shared.Exception.Path, Metadata.Exception.Instance, Metadata.Shared.Exception.Config, Metadata.Exception.Connect, Metadata.Shared.Exception.Resource, Metadata.Element.Shared.Exception.Index, Metadata.Exception.Elements, Metadata.Exception.Shared, Metadata.Exception.Source, Metadata.Exception.Annotation, Metadata.Element.Exception.Source, Metadata.Element.Exception.Annotation, Metadata.Element.Shared.Exception.Name, Language.Exception.Flow, Metadata.Exception.Parameter {
        return config(type, Metadata.metadata(type), source);
    }

    public static <T> Config<T> config(Class<T> type) throws Metadata.Shared.Exception.Path, Metadata.Exception.Instance, Metadata.Shared.Exception.Config, Metadata.Exception.Connect, Exception.Metadata, Metadata.Shared.Exception.Resource, Metadata.Element.Shared.Exception.Index, Metadata.Exception.Elements, Metadata.Exception.Shared, Exception.Source, Metadata.Exception.Source, Metadata.Exception.Annotation, Metadata.Element.Exception.Source, Metadata.Element.Exception.Annotation, Metadata.Element.Shared.Exception.Name, Language.Exception.Flow, Exception.Type, Metadata.Exception.Parameter {
        return config(type, null);
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

    public Class<T> type() {
        return type;
    }

    public Metadata<T> metadata() {
        return metadata;
    }

    public T source() throws Exception.Source {
        if (source == null) throw new Exception.Source();
        return source;
    }

    public static abstract class Exception extends java.lang.Exception {
        public static final class Type extends Exception {}
        public static final class Metadata extends Exception {}
        public static final class Source extends Exception {}
        // TODO: 12.08.2022 OTHER EXCEPTIONS
    }
}
