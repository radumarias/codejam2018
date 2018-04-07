package com.code42.codejam.troublesort;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        try {
            Solver solver = new Solver();

            InputStream is;
            if (args.length != 0) {
                is = new FileInputStream(args[0]);
            } else {
                is = System.in;
            }

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));
            String line = in.nextLine();
            int t = Integer.parseInt(line);
            for (int i = 1; i <= t; ++i) {
                int n = in.nextInt();
                int[] l = new int[n];
                for (int j = 0; j < n; j++) {
                    l[j] = in.nextInt();
                }
                int position = solver.solve(l);

                System.out.println("Case #" + i + ": " + (position == -1 ? "OK" : position));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static class Solver {

        public int solve(int[] l) {
//            for (int i = 0; i < l.length - 2; i++) {
//                if ((l[i] > l[i + 2]) &&
//                        !(l[i] > l[i + 1] && l[i + 1] > l[i + 2]) &&
//                        (Math.abs(l[i] - l[i + 1]) == 1 && Math.abs(l[i] - l[i + 2]) == 1)) {
////                    if (i > 0) {
////                        if (l[i - 1] > l[i]) {
////                            return i;
////                        }
////                    }
//
//                    return i + 1;
//                }
//            }
//
//            return -1;
            int p = sort(l);
            if (p != -1) {
                return p;
            }

            for (int i = 0; i < l.length - 1; i++) {
                if (l[i] > l[i + 1]) {
                    return i;
                }
            }

            return -1;
        }

        public int sort(int[] l) {
            boolean done = false;
            while (!done) {
                done = true;
                for (int i = 0; i < l.length - 2; i++) {
                    if (l[i] > l[i + 2]) {
                        done = false;
                        int t = l[i];
                        l[i] = l[i + 2];
                        l[i + 2] = t;
                    }
                }

//                for (int i = 0; i < l.length - 2; i++) {
//                    if ((l[i] > l[i + 2]) &&
//                            !(l[i] > l[i + 1] && l[i + 1] > l[i + 2]) &&
//                            (Math.abs(l[i] - l[i + 1]) == 1 && Math.abs(l[i] - l[i + 2]) == 1)) {
//                        if (i > 0) {
//                            if (l[i - 1] > l[i]) {
//                                return i;
//                            }
//                        }
//
//                        return i + 1;
//                    }
//                }
            }

            return -1;
        }

    }

}
