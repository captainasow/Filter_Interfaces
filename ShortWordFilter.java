public class ShortWordFilter implements filter{
    @Override
    public boolean accept(Object x) {
        String word = (String) x;

        if (word.length() < 5) {
            System.out.println(word  + "-True");
            return true;
        }

        System.out.println(word + "-False");

        return false;

    }
}
