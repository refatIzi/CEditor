package com.example.dashboard.visualization;

import android.graphics.Color;

import java.util.regex.Pattern;

public class Visualization {


    final private TextColor similar_part_of_speeches = new TextColor(
            Pattern.compile(
                    "\\b(were made|who merely stated|The government|stricter about|hose receiving benefits|verification of address|Metadata has various purposes|provide digital identification)\\b"),
            Color.parseColor("#cc7832")
    );

    final private TextColor NUMBERS = new TextColor(
            Pattern.compile("(\\b(\\d*[.]?\\d+)\\b)"),
            Color.parseColor("#2f5f93")
    );

    final private TextColor BRACKETS = new TextColor(
            Pattern.compile("[\\(\\)]"),
            Color.parseColor("#3e9cca")
    );
    final private TextColor SQUARE_BRACKETS = new TextColor(
            Pattern.compile("[\\[\\]]"),
            Color.parseColor("#3e9cca")
    );
    final private TextColor BRACES = new TextColor(
            Pattern.compile("[\\{\\}]"),
            Color.parseColor("#3e9cca")
    );

    /**
     * регулятор для подсвтеки одиночных букв
     */
    private TextColor LETTERS = new TextColor(
            Pattern.compile("(\\b(q|w|e|r|t|y|u|i|o|p|a|s|d|f|g|h|j|k|l|z|x|c|v|b|n|m|Q|W|E|R|T|Y|U|I|O|P|A|S|D|F|G|H|J|K|L|Z|X|C|V|B|N|M)\\b)"),
            Color.parseColor("#648cb8")
    );
    private TextColor DETECT_WORD = new TextColor(
            Pattern.compile("\\b(loans|borrowers|income|independent|become|without|traditionally|libraries|databases|digitally)\\b"),
            Color.parseColor("#648cb8")
    );
    private static Visualization visualization = new Visualization();
   private static  TextColor[] colors = {
            visualization.similar_part_of_speeches,
            visualization.NUMBERS,
            visualization.LETTERS,
            visualization.BRACKETS,
            visualization.SQUARE_BRACKETS,
            visualization.BRACES,
            visualization.DETECT_WORD

    };


    public static TextColor[] getColors() {
        return colors;
    }

    public class TextColor {
        public final Pattern pattern;
        public final int color;

        TextColor(Pattern pattern, int color) {
            this.pattern = pattern;
            this.color = color;
        }
    }
}
