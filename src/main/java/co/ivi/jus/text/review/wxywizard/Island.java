/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.text.review.wxywizard;

public class Island {
    public static void main(String[] args) {
        String poetry = """
                         No man is an island,
                           Entire of itself,
                Every man is a piece of the continent,
                         A part of the main.           
                """;
        System.out.println(poetry);

        String poetryHtml =
                "<html>\n" +
                "<head></head>\n" +
                "<body>\n" +
                "<div align=\"center\">\n" +
                "    No man is an island,<br />\n" +
                "    Entire of itself,<br />\n" +
                "    Every man is a piece of the continent,<br />\n" +
                "    A part of the main.\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        System.out.println(poetryHtml);
        System.out.println();
        String poetryTextArea = """
                <html>
                <head></head>
                <body>
                <div align="center">
                    No man is an island,<br />
                    Entire of itself,<br />
                    Every man is a piece of the continent,<br />
                    A part of the main.
                </div>
                </body>
                </html>
                """;
        System.out.println(poetryTextArea);
//        老师为啥我这两个输出是false？
        System.out.println(poetryHtml.equals(poetryTextArea));
        System.out.println(poetryHtml==poetryTextArea);

    }
}
