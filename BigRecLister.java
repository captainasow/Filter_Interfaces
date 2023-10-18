import java.awt.*;
import java.util.ArrayList;

public class BigRecLister {
    public static void main(String[] args) {
        ArrayList<Rectangle> recList = new ArrayList<>();
        recList.add(new Rectangle(1, 2));
        recList.add(new Rectangle(10, 20));
        recList.add(new Rectangle(3, 1));
        recList.add(new Rectangle(4, 2));
        recList.add(new Rectangle(14, 12));
        recList.add(new Rectangle(1, 4));
        recList.add(new Rectangle(5, 2));
        recList.add(new Rectangle(10, 2));
        recList.add(new Rectangle(1, 4));
        recList.add(new Rectangle(11, 2));

        ArrayList<Rectangle> filteredList = collectAll(recList);
        BigRectangleFilter recFilter = new BigRectangleFilter();

        System.out.println();
        System.out.println("Here are your bigger rectangles:");

        for (Rectangle rec : filteredList) {
            System.out.println(rec + " Perimeter: " + recFilter.perimeter(rec));

        }


    }


    public static ArrayList<Rectangle> collectAll(ArrayList<Rectangle> recList) {

        BigRectangleFilter recFilter = new BigRectangleFilter();
        ArrayList<Rectangle> newRecList = new ArrayList<>();

        for (Rectangle rec: recList) {
            boolean filtered = recFilter.accept(rec);

            if (filtered)
            {
                newRecList.add(rec);
            }

        }

        return newRecList;
    }
}
