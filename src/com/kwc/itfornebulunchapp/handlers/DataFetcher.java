package com.kwc.itfornebulunchapp.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @since 1.0
 * @author Marius Kristensen
 */
public final class DataFetcher {
    private DataFetcher() {
    }

    public static String fetchHTML() {
        String url = "http://leietaker.itfornebu.no/itfornebu/kantinemeny";
        String line;
        StringBuilder content = new StringBuilder();

        // Read url content into StringBuilder
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            return null;
        }

        return content.toString();
    }
}
