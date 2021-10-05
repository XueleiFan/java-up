/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.immutable.former;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Unmodifiable {
    public static void main(String[] args) {
        List<String> months = new ArrayList<>();
        months.add("JANUARY");
        months.add("FEBRUARY");
        months.add("MARCH");

        for (int i = 0; i < 10; i++) {
            months = Collections.unmodifiableList(months);
        }
    }
}
