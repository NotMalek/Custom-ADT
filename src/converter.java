import java.io.*;

public class converter {
    public static String fillZero(int value) {

        if (value < 10000000 && value > 999999)
            return "0" + String.format("%d", value);
        else if (value < 1000000 && value > 99999)
            return "00" + String.format("%d", value);
        else if (value < 100000 && value > 9999)
            return "000" + String.format("%d", value);
        else if (value < 10000 && value > 999)
            return "0000" + String.format("%d", value);
        else if (value < 1000 && value > 99)
            return "00000" + String.format("%d", value);
        else if (value  < 100 && value > 9)
        return "000000"+ String.format("%d", value);
        else if (value < 10 && value >= 0)
            return "0000000" + String.format("%d", value);
        else
            return String.format("%d", value);
    }
}

