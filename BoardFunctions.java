public class BoardFunctions {
    public static void confirmLoc(String loc) {
        if (loc.length() > 2) {
            throw new InvalidLocation();
        }

        String col = loc.substring(0,1);
        String row = loc.substring(1,2);

        if (!(col.equals("a") || col.equals("b") || col.equals("c") || col.equals("d") || 
            col.equals("e") || col.equals("f") || col.equals("g") || col.equals("h"))) {
                throw new InvalidLocation();
        }

        if (!(row.equals("1") || row.equals("2") || row.equals("3") || row.equals("4") || 
            row.equals("5") || row.equals("6") || row.equals("7") || row.equals("8"))) {
                throw new InvalidLocation();
        }
    }

    public static int getCol(String loc) {
        String col = loc.substring(0,1);
        int colNum = 0;

        switch (col) {
            case "a":
                colNum = 0;
                break;
            case "b":
                colNum = 1;
                break;
            case "c":
                colNum = 2;
                break;
            case "d":
                colNum = 3;
                break;
            case "e":
                colNum = 4;
                break;
            case "f":
                colNum = 5;
                break;
            case "g":
                colNum = 6;
                break;
            case "h":
                colNum = 7;
                break;
        }

        return colNum;
    }

    public static int getRow(String loc) {
        String row = loc.substring(1,2);
        int rowNum = 0;

        switch (row) {
            case "1":
                rowNum = 0;
                break;
            case "2":
                rowNum = 1;
                break;
            case "3":
                rowNum = 2;
                break;
            case "4":
                rowNum = 3;
                break;
            case "5":
                rowNum = 4;
                break;
            case "6":
                rowNum = 5;
                break;
            case "7":
                rowNum = 6;
                break;
            case "8":
                rowNum = 7;
                break;
        }

        return rowNum;
    }


    public static String getColString(int colNum) {
        String colString = "";

        switch (colNum) {
            case 0:
                colString = "a";
                break;
            case 1:
                colString = "b";
                break;
            case 2:
                colString = "c";
                break;
            case 3:
                colString = "d";
                break;
            case 4:
                colString = "e";
                break;
            case 5:
                colString = "f";
                break;
            case 6:
                colString = "g";
                break;
            case 7:
                colString = "h";
                break;
        }

        return colString;
    }


    public static String getRowString(int rowNum) {
        String rowString = "";

        switch (rowNum) {
            case 0:
                rowString = "1";
                break;
            case 1:
                rowString = "2";
                break;
            case 2:
                rowString = "3";
                break;
            case 3:
                rowString = "4";
                break;
            case 4:
                rowString = "5";
                break;
            case 5:
                rowString = "6";
                break;
            case 6:
                rowString = "7";
                break;
            case 7:
                rowString = "8";
                break;
        }

        return rowString;
    }
}