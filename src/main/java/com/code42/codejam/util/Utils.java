package com.code42.codejam.util;

import com.code42.codejam.util.model.Point;

public class Utils {

    public static int distance(Point p1, Point p2) {
        return Math.abs(p1.getRow() - p2.getRow()) +
                Math.abs(p1.getCol() - p2.getCol());
    }
}
