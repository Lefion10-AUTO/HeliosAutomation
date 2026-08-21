package com.helios.utils;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;

public final class ResourceUtils {

    private ResourceUtils() {
    }

    public static String getFilePath(String resourcePath) {
        URL resource = ResourceUtils.class
                .getClassLoader()
                .getResource(resourcePath);

        if (resource == null) {
            throw new IllegalArgumentException(
                    "Resource not found: " + resourcePath
            );
        }

        try {
            return Path.of(resource.toURI())
                    .toAbsolutePath()
                    .toString();

        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(
                    "Invalid resource path: " + resourcePath,
                    e
            );
        }
    }
}