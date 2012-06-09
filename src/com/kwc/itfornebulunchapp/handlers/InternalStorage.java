package com.kwc.itfornebulunchapp.handlers;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * This class handles the internal storage of the lunch in the phones
 * temporary storage. Meaning it will only last as long as the app stays
 * alive. The app will look for this file first to find the lunch data. If
 * it is missing it will download the lunch and recreate it.
 *
 * @author Marius Kristensen
 * @since 1.1
 */
public class InternalStorage {
    private final String fileName = "lunch.json";

    private Context fileContext;

    /**
     * Constructor.
     * @param fileContext
     */
    public InternalStorage(Context fileContext) {
        this.fileContext = fileContext;
        deleteFile();
    }


    /**
     * Write to file.
     * @param jsonString - json-formatted string.
     * @return true or false
     */
    public boolean writeToFile(String jsonString) {
        FileOutputStream fos;
        try {
            fos = fileContext.openFileOutput(fileName, Context.MODE_PRIVATE);
            fos.write(jsonString.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            return false;
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Read From file.
     * @return string with file content.
     */
    public String readFromFile() {
        String fileString = "";
        FileInputStream fis = null;
        try {
            fis = fileContext.openFileInput(fileName);
            byte[] input = new byte[fis.available()];
            while (fis.read(input) != -1) {
                fileString += new String(input);
            }
        } catch (IOException e) {
            return "";
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (IOException e) {
                // Do nothing
            }
        }
        return fileString;
    }

    /**
     * Checks if the file we use already exists.
     */
    public boolean fileExists() {
        File file = fileContext.getFileStreamPath(fileName);
        return file.exists();
    }

    /**
     * Deletes the file if it exists.
     */
    public void deleteFile() {
        if (fileExists()) {
            fileContext.deleteFile(fileName);
        }
    }
}
