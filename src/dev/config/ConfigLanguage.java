package dev.config;

public enum ConfigLanguage {
    PROPERTIES(true),
    JSON(false),
    YAML(false),
    TOML(false),
    XML(false);

    private final boolean supported;

    ConfigLanguage(boolean supported) {
        this.supported = supported;
    }

    public boolean supported() {
        return supported;
    }
}
