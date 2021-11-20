/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.text.review.songor;

public class Island {
    public static void main(String[] args) {
        String html = """
                <html>
                 <head></head>
                 <body>
                  <div align="center">
                   No man is an island,<br>
                   Entire of itself,<br>
                   Every man is a piece of the continent,<br>
                   A part of the main.
                  </div>
                 </body>
                </html>
                """;
        System.out.println(html);

        String text = """
                         No man is an island,
                           Entire of itself,
                Every man is a piece of the continent,
                         A part of the main.
                """;
        System.out.println(text);
    }
}
