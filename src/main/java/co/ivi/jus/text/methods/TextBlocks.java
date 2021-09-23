/*
 * Copyright (c) 2021, Xuelei Fan. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.text.methods;

public class TextBlocks {
    public static void main(String[] args) {
        String stringBlock =
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <body>\n" +
                "        <h1>\"Hello World!\"</h1>\n" +
                "    </body>\n" +
                "</html>\n";
        System.out.println("Here is the regular string:\n" + stringBlock);

        String textBlock = """
                <!DOCTYPE html>
                <html>
                    <body>
                        <h1>"Hello World!"</h1>
                    </body>
                </html>
                """;
        System.out.println("Here is the text block:\n" + textBlock);

        System.out.println("Is the text block equals to the regular string? " +
                stringBlock.equals(textBlock));
        System.out.println("Is the text block refers to the regular string? " +
                (stringBlock == textBlock));

        int size = """
                <!DOCTYPE html>
                <html>
                    <body>
                        <h1>"Hello World!"</h1>
                    </body>
                </html>
                """.length();
        System.out.println("The size of the text block code is: " + size);

        textBlock = """
                <!DOCTYPE html>
                <html>
                    <body>
                        <h1>"%s"</h1>
                    </body>
                </html>
                """.formatted("Hello World!");
        System.out.println("Here is the text block:\n" + textBlock);
        System.out.println("Is the text block equals to the regular string? " +
                stringBlock.equals(textBlock));
        System.out.println("Is the text block refers to the regular string? " +
                (stringBlock == textBlock));
    }
}