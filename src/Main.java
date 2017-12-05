import java.lang.reflect.Array;
import java.util.*;

public class Main {

    enum Type {
        R, G, B
    }


    public static class Color implements Comparable<Color> {
        Type color;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Color color1 = (Color) o;
            return color == color1.color;
        }

        @Override
        public int hashCode() {

            return Objects.hash(color);
        }

        public Color(Type color) {

            this.color = color;
        }

        @Override
        public int compareTo(Color o) {
            if (this.color == o.color) {
                return 0;
            } else if (this.color == Type.G) {
                return -1;
            } else if (this.color == Type.B) {
                if (o.color == Type.G) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return 1;
        }
    }

    public static Set<Color> colorSet;
    //public static Map<Integer, Color> colorMap;
    public static List<Color> colorList;

    public static final Random rand = new Random();


    public static void checkRGB(Collection<Color> ins) {
        Iterator<Color> iterator = ins.iterator();
        Color temp;
        int r = 0, g = 0, b = 0;
        while (iterator.hasNext()) {
            temp = iterator.next();
            switch (temp.color) {
                case R:
                    r++;
                    break;
                case G:
                    g++;
                    break;
                case B:
                    b++;
                    break;
            }
        }
        info(ins.getClass().getCanonicalName(), r, g, b);

    }

    public static void checkRGB(Map<Integer, Color> ins) {
        if (ins != null) {
            checkRGB(ins.values());
        }

    }

    public static Type getRandomColorName() {
        //return colorsName[rand.nextInt(3)];
        return Type.values()[rand.nextInt(3)];
    }

    public static void info(String storageType, int r, int g, int b) {
        System.out.printf("Storage type: %s\nR:%d\tG:%d\tB:%d\n\n", storageType, r, g, b);
    }


    public static void main(String[] args) {
        colorSet = new HashSet<>();
        colorList = new ArrayList<>();
        colorList.forEach(v -> System.out.println(v.color));
        for (int i = 0; i < 50; i++) {
            colorList.add(new Color(getRandomColorName()));
            colorSet.add(new Color(getRandomColorName()));
        }

        System.out.println("Before");
        colorList.forEach(v -> System.out.printf("%s ", v.color));
        System.out.println();
        Collections.sort(colorList);
        System.out.println("After");
        colorList.forEach(v -> System.out.printf("%s ", v.color));
        System.out.println();
        checkRGB(colorList);

    }
}
