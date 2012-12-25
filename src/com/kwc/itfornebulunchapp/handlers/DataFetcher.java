package com.kwc.itfornebulunchapp.handlers;

import com.kwc.itfornebulunchapp.utils.AlertBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @since 1.0
 * @author Marius Kristensen
 */
public final class DataFetcher {
    private DataFetcher() {
    }

    private static final String HTML_PATH = "http://leietaker.itfornebu.no/itfornebu/kantinemeny";

    public static String fetchHTML() {

        String line;
        StringBuilder content = new StringBuilder();
        // Read url content into StringBuilder
        try {
            URL url = new URL(HTML_PATH);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        } catch (MalformedURLException e) {
            AlertBox.alertBox("Error", "Failed to retrieve lunch from source.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }
}
