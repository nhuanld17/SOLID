package org.example;

import java.io.File;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String directoryPath = "E:\\GIT";
        File directory = new File(directoryPath);

        if (!directory.isDirectory()) {
            System.out.println("The specified path is not a directory.");
            return;
        }

        deleteSRTFiles(directory);
    }

    private static void deleteSRTFiles(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    // Recursively call this method for directories
                    deleteSRTFiles(file);
                } else if (file.isFile() && file.getName().endsWith(".srt")) {
                    if (file.delete()) {
                        System.out.println("Deleted: " + file.getAbsolutePath());
                    } else {
                        System.out.println("Failed to delete: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}