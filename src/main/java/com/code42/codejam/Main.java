package com.code42.codejam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            solve(getFiles(args[0]).toArray(new File[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void solve(File... in) throws IOException {
        Mind mind = new Mind();
        for (File file : in) {
            System.out.println(String.format("Solve for [%s].", file.getAbsolutePath()));
            mind.doYouMagic(new FileInputStream(file), new FileOutputStream(new File(file.getParent(), file.getName().substring(0, file.getName().length() - 3) + ".out")));
        }
    }

    private static List<File> getFiles(String path) {
        File file = new File(path);
        if (file.isDirectory()) {
            //noinspection ConstantConditions
            return Arrays.asList(file.listFiles((dir, name) -> name.endsWith(".in")));
        } else {
            return Collections.singletonList(file);
        }
    }
}
