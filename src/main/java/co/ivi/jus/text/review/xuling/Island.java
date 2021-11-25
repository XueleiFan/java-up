/*
 * Copyright (c) 2021, Ling Xu. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 */

package co.ivi.jus.text.review.xuling;

/**
 * textarea island work
 *
 * @author jack
 * @since 2021/11/22
 **/
public class Island {
    public static void main(String[] args) {
        System.out.println("""
                <p style="text-align:center">
                No man is an island,<br/>
                Entire of itself,<br/>
                Every man is a piece of the continent,<br/>
                A part of the main.</p>
                """);
        System.out.println("""
                         No man is an island,
                           Entire of itself,
                Every man is a piece of the continent,
                         A part of the main.""");
    }
}
