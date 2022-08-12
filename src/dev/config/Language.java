package dev.config;

import java.util.Map;

public enum Language {
    Properties(Map.of(Flow.Strict, ".properties", Flow.Advanced, ".properties")),
    Json(Map.of(Flow.Strict, ".json", Flow.Advanced, ".json")),
    Yaml(Map.of(Flow.Strict, ".yaml", Flow.Advanced, ".yml")),
    Toml(Map.of(Flow.Strict, ".toml", Flow.Advanced, ".toml")),
    Xml(Map.of(Flow.Strict, ".xml", Flow.Advanced, ".xml"));

    private final Map<Flow, String> extensions;

    Language(Map<Flow, String> extensions) {
        this.extensions = extensions;
    }

    public String extension(Flow flow) throws Exception.Flow {
        if (flow == null) throw new Exception.Flow();
        return extensions.get(flow);
    }

    public Map<Flow, String> extensions() {
        return extensions;
    }

    public static abstract class Exception extends Config.Exception {
        public static final class Flow extends Exception {}
    }
}
