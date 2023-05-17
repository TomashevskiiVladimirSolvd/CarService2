package com.solvd.laba.Enums;

public class ColorEnum {
    public enum Color {
        RED("#FF0000"),
        GREEN("#00FF00"),
        BLUE("#0000FF"),
        YELLOW("#FFFF00"),
        ORANGE("#FFA500"),
        PURPLE("#800080"),
        PINK("#FFC0CB"),
        BROWN("#A52A2A"),
        BLACK("#000000"),
        WHITE("#FFFFFF");

        private final String colorCode;

        Color(String colorCode) {
            this.colorCode = colorCode;
        }

        public String getColorCode() {
            return colorCode;
        }
    }
}
