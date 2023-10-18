import java.awt.*;

public class BigRectangleFilter {
    public boolean accept(Object x) {
        Rectangle rec = (Rectangle) x;
        int perimeter = (rec.width * 2) + (rec.height * 2);

        System.out.println(rec + " Perimeter: " + perimeter);

        return perimeter > 10;
    }

    public static int perimeter(Rectangle rec)
    {
        return (rec.height * 2) + (rec.width * 2);
    }
}
