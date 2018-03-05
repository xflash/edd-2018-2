package org.xflash.edd.model;

public class Ansis {
    private static final String POSTFIX = "m";
    private static final String PREFIX = "\u001B";
    private static final String SQ = "[";
    public static final String ANSI_WHITE = PREFIX + SQ + "37" + POSTFIX;
    public static final String ANSI_CYAN = PREFIX + SQ + "36" + POSTFIX;
    public static final String ANSI_PURPLE = PREFIX + SQ + "35" + POSTFIX;
    public static final String ANSI_BLUE = PREFIX + SQ + "34" + POSTFIX;
    public static final String ANSI_YELLOW = PREFIX + SQ + "33" + POSTFIX;
    public static final String ANSI_GREEN = PREFIX + SQ + "32" + POSTFIX;
    public static final String ANSI_RED = PREFIX + SQ + "31" + POSTFIX;
    public static final String ANSI_BLACK = PREFIX + SQ + "30" + POSTFIX;
    public static final String ANSI_RESET = PREFIX + SQ + "0" + POSTFIX;
    public static final String ANSI_BOLD = PREFIX + SQ + "1" + POSTFIX;
    public static final String ANSI_UNDERSCORE = PREFIX + SQ + "4" + POSTFIX;
    public static final String ANSI_BLINK = PREFIX + SQ + "5" + POSTFIX;
    public static final String ANSI_REVERSE = PREFIX + SQ + "7" + POSTFIX;
}
