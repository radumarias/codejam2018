package com.code42.codejam.universe;

import java.util.*;
import java.io.*;
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
                int d = in.nextInt();
                String code = in.next().trim();

                int changes = solver.solve(d, code);
                System.out.println("Case #" + i + ": " + (changes == -1 ? "IMPOSSIBLE" : changes));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static class Solver {

        public int solve(int d, String code) {
            char[] chars = code.toCharArray();
            int n = 0;

            if (chars.length > 1) {
                boolean changed;
                do {
                    if (damage(chars) <= d) {
                        return n;
                    }

                    changed = false;

                    for (int i = chars.length - 1; i > 0; i--) {
                        if ((chars[i - 1] == 'C') && (chars[i] == 'S')) {
                            char t = chars[i];
                            chars[i] = chars[i - 1];
                            chars[i - 1] = t;
                            n++;

                            changed = true;

                            break;
                        }
                    }
                } while (changed);
            }

            int df = damage(chars);

            return df <= d ? n : -1;
        }

        private int damage(char[] code) {
            int d = 0;
            int c = 1;
            for (int i = 0; i < code.length; i++) {
                switch (code[i]) {
                    case 'S':
                        d+=c;
                        break;
                    case 'C':
                        c*=2;
                        break;
                }
            }

            return d;
        }
    }

}
