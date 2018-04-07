package com.code42.codejam.util.io;

import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SolutionWriter {

    private PrintWriter writer;
    private OutputStream os;

    public SolutionWriter(OutputStream os) {
        this.os = os;
    }

    public void write(int[] rides) {
        ensureStreamIsInitiated();

        StringBuilder sb = new StringBuilder();

        sb.append(rides.length);

        for (int ride : rides) {
            sb.append(" ").append(ride);
        }
        String line = sb.toString();
        System.out.println(line);
        writer.println(line);
    }

    public void end() {
        if (writer != null) {
            writer.flush();
            writer.close();
        }
    }

    private void ensureStreamIsInitiated() {
        if (writer == null) {
            this.writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
        }
    }
}