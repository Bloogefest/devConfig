package dev.config;

import dev.config.annotations.*;
import dev.config.annotations.Config;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class Metadata<T> {
    private final Class<T> source;
    private final Config annotation;
    private final Comment comment;
    private final Constructor<T> instance;
    private final Set<Element> elements;
    private final Shared shared;
    private final boolean commented;
    private final boolean nullable;

    private Metadata(Class<T> source, Config annotation, Comment comment, Constructor<T> instance, Set<Element> elements, Shared shared) {
        this.source = source;
        this.annotation = annotation;
        this.comment = comment;
        this.instance = instance;
        this.elements = elements;
        this.shared = shared;

        commented = commented(comment);
        nullable = nullable(elements);
    }

    public static <T> Metadata<T> metadata(Class<T> source, Config annotation, Comment comment, Constructor<T> instance, Set<Element> elements, Shared shared) throws Exception.Source, Exception.Annotation, Exception.Instance, Exception.Elements, Exception.Shared {
        if (source == null) throw new Exception.Source();
        if (annotation == null) throw new Exception.Annotation();
        if (instance == null || instance.canAccess(source)) throw new Exception.Instance();
        if (elements == null) throw new Exception.Elements();
        if (shared == null) throw new Exception.Shared();
        return new Metadata<>(source, annotation, comment, instance, elements, shared);
    }

    public static <T> Metadata<T> metadata(Class<T> source, Config annotation, Constructor<T> instance) throws Exception.Source, Exception.Annotation, Exception.Instance, Exception.Elements, Exception.Shared, Exception.Connect, Exception.Parameter, Element.Shared.Exception.Index, Element.Exception.Source, Element.Exception.Annotation, Element.Shared.Exception.Name, Shared.Exception.Path, Shared.Exception.Config, Shared.Exception.Resource, Language.Exception.Flow {
        return metadata(source, annotation, comment(source), instance, elements(source, instance), Shared.shared(annotation));
    }

    public static <T> Metadata<T> metadata(Class<T> source) throws Exception.Source, Exception.Annotation, Exception.Instance, Exception.Elements, Exception.Shared, Exception.Connect, Exception.Parameter, Element.Shared.Exception.Index, Element.Exception.Source, Element.Exception.Annotation, Element.Shared.Exception.Name, Shared.Exception.Path, Shared.Exception.Config, Shared.Exception.Resource, Language.Exception.Flow {
        return metadata(source, annotation(source), instance(source));
    }

    public static Config annotation(Class<?> source) throws Exception.Source, Exception.Annotation {
        if (source == null) throw new Exception.Source();
        Config annotation = source.getAnnotation(Config.class);
        if (annotation == null) throw new Exception.Annotation();
        return annotation;
    }

    public static Comment comment(Class<?> source) throws Exception.Source {
        if (source == null) throw new Exception.Source();
        return source.getAnnotation(Comment.class);
    }

    @SuppressWarnings("unchecked")
    public static <T> Constructor<T> instance(Class<T> source) throws Exception.Source, Exception.Instance {
        if (source == null) throw new Exception.Source();
        Constructor<T>[] instances = (Constructor<T>[]) source.getDeclaredConstructors();
        if (instances.length > 1 || Arrays.stream(source.getDeclaredFields()).filter(field -> Modifier.isFinal(field.getModifiers())).count() < instances.length) throw new Exception.Instance();
        return instances[0];
    }

    public static <T> Set<Element> elements(Class<T> source, Constructor<T> instance) throws Exception.Source, Exception.Instance, Exception.Parameter, Exception.Connect, Element.Shared.Exception.Index, Element.Exception.Source, Element.Exception.Annotation, Element.Shared.Exception.Name {
        if (source == null) throw new Exception.Source();
        if (instance == null || instance.canAccess(source)) throw new Exception.Instance();
        Set<Element> elements = new HashSet<>();
        Parameter[] parameters = instance.getParameters();
        for (Field field : source.getDeclaredFields()) {
            Property annotation = field.getAnnotation(Property.class);
            if (annotation == null) continue;
            code: {
                for (int i = 0; i < parameters.length; i++) {
                    Connect connect = parameters[i].getAnnotation(Connect.class);
                    if (connect == null) throw new Exception.Parameter();
                    if (connect.value().equals(Element.Shared.name(field, annotation))) {
                        elements.add(Element.element(field, annotation, field.getAnnotation(Comment.class), connect, i));
                        break code;
                    }
                }
                if (Modifier.isFinal(field.getModifiers())) throw new Exception.Connect();
                elements.add(Element.element(field, annotation, field.getAnnotation(Comment.class)));
            }
        }
        return Collections.unmodifiableSet(elements);
    }

    public static boolean commented(Comment comment) {
        return comment != null;
    }

    public static boolean nullable(Set<Element> elements) {
        return elements.isEmpty();
    }

    public Class<T> source() {
        return source;
    }

    public Config annotation() {
        return annotation;
    }

    public Comment comment() {
        return comment;
    }

    public Constructor<T> instance() {
        return instance;
    }

    public Set<Element> elements() {
        return elements;
    }

    public Shared shared() {
        return shared;
    }

    public boolean commented() {
        return commented;
    }

    public boolean nullable() {
        return nullable;
    }

    public static final class Element {
        private final Field source;
        private final Property annotation;
        private final Comment comment;
        private final Connect connect;
        private final Element.Shared shared;
        private final boolean commented;
        private final boolean connected;

        private Element(Field source, Property annotation, Comment comment, Connect connect, Element.Shared shared) {
            this.source = source;
            this.annotation = annotation;
            this.comment = comment;
            this.connect = connect;
            this.shared = shared;

            commented = commented(comment);
            connected = connected(connect);
        }

        public static Element element(Field source, Property annotation, Comment comment, Connect connect, int index) throws Exception.Source, Exception.Annotation, Element.Shared.Exception.Index, Element.Shared.Exception.Name {
            if (source == null) throw new Exception.Source();
            if (annotation == null) throw new Exception.Annotation();
            return new Element(source, annotation, comment, connect, Element.Shared.shared(source, annotation, index, connect));
        }

        public static Element element(Field source, Property annotation, Comment comment) throws Exception.Source, Exception.Annotation, Element.Shared.Exception.Index, Element.Shared.Exception.Name {
            return element(source, annotation, comment, null, -1);
        }

        public static boolean commented(Comment comment) {
            return comment != null;
        }

        public static boolean connected(Connect connect) {
            return connect != null;
        }

        public Field source() {
            return source;
        }

        public Property annotation() {
            return annotation;
        }

        public Comment comment() {
            return comment;
        }

        public Connect connect() {
            return connect;
        }

        public Element.Shared shared() {
            return shared;
        }

        public boolean commented() {
            return commented;
        }

        public boolean connected() {
            return connected;
        }

        public static final class Shared {
            private final String name;
            private final int index;

            private Shared(String name, int index) {
                this.name = name;
                this.index = index;
            }

            public static Shared shared(String name, int index, boolean connected) throws Exception.Name, Exception.Index {
                if (name == null || name.isBlank()) throw new Exception.Name();
                if (connected && index < 0 || !connected && index >= 0) throw new Exception.Index();
                return new Shared(name, index);
            }

            public static Shared shared(Field source, Property annotation, int index, Connect connect) throws Exception.Name, Exception.Index, Element.Exception.Source, Element.Exception.Annotation {
                return shared(name(source, annotation), index, connected(connect));
            }

            public static String name(Field source, Property annotation) throws Element.Exception.Source, Element.Exception.Annotation {
                if (source == null) throw new Element.Exception.Source();
                if (annotation == null || annotation != source.getAnnotation(Property.class)) throw new Element.Exception.Annotation();
                return annotation.value().isBlank() ? source.getName() : annotation.value();
            }

            public static boolean connected(Connect connect) {
                return connect != null;
            }

            public String name() {
                return name;
            }

            public int index() {
                return index;
            }

            public static abstract class Exception extends Element.Exception {
                public static final class Name extends Exception {}
                public static final class Index extends Exception {}
            }
        }

        public static abstract class Exception extends Metadata.Exception {
            public static final class Source extends Exception {}
            public static final class Annotation extends Exception {}
        }
    }

    public static final class Shared {
        private final Path path;
        private final String resource;
        private final boolean resourced;

        private Shared(Path path, String resource) {
            this.path = path;
            this.resource = resource;

            resourced = resourced(resource);
        }

        public static Shared shared(Path path, String resource) throws Exception.Path, Exception.Resource {
            if (path == null) throw new Exception.Path();
            if (resource == null) throw new Exception.Resource();
            return new Shared(path, resource);
        }

        public static Shared shared(Config config) throws Exception.Path, Exception.Resource, Exception.Config, Language.Exception.Flow {
            return shared(path(config), resource(config));
        }

        public static Path path(Config config) throws Exception.Config, Language.Exception.Flow {
            if (config == null) throw new Exception.Config();
            return Path.of(config.extension() ? config.path() + config.language().extension(config.flow()) : config.path());
        }

        public static String resource(Config config) throws Exception.Config, Language.Exception.Flow {
            if (config == null) throw new Exception.Config();
            return config.resource().extension() ? config.resource().path() + config.language().extension(config.flow()) : config.resource().path();
        }

        public static boolean resourced(String resource) {
            return resource != null && !resource.isBlank();
        }

        public Path path() {
            return path;
        }

        public String resource() {
            return resource;
        }

        public boolean resourced() {
            return resourced;
        }

        public static abstract class Exception extends Metadata.Exception {
            public static final class Path extends Exception {}
            public static final class Resource extends Exception {}
            public static final class Config extends Exception {}
        }
    }

    public static abstract class Exception extends dev.config.Config.Exception {
        public static final class Source extends Exception {}
        public static final class Annotation extends Exception {}
        public static final class Instance extends Exception {}
        public static final class Elements extends Exception {}
        public static final class Shared extends Exception {}
        public static final class Parameter extends Exception {}
        public static final class Connect extends Exception {}
    }
}
