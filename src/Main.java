import java.util.*;

public class Main {

    public static class Color {
        private String colorName;

        public void setColorName(String colorName) {
            this.colorName = colorName;
        }

        public String getColorName() {

            return colorName;
        }

        public Color(String colorName) {

            this.colorName = colorName;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this)
                return true;
            if (obj == null || obj.getClass() != this.getClass())
                return false;
            Color guest = (Color) obj;
            return colorName == guest.getColorName()
                    || (colorName != null && (colorName.equals(guest.getColorName())));
        }

        @Override
        public int hashCode() {
            int prime = 24;
            int result = 1;
            result = prime * result + (colorName == null ? 0 : colorName.hashCode());
            return result;
        }
    }

    public static Set<Color> colorSet;
    public static Map<Integer, Color> colorMap;
    public static List<Color> colorList;

    public static final Random rand = new Random();
    public static final String[] colorsName = {"R", "G", "B"};
    public static final Color[] colorsInstance = new Color[]{
            new Color("R"),
            new Color("G"),
            new Color("B")
    };

    public static void checkRGB(Collection<Color> ins) {
        Iterator<Color> iterator = ins.iterator();
        Color temp;
        int r = 0, g = 0, b = 0;
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.equals(colorsInstance[0])) r++;
            if (temp.equals(colorsInstance[1])) g++;
            if (temp.equals(colorsInstance[2])) b++;
        }
        info(ins.getClass().getCanonicalName(), r, g, b);
    }

    public static void checkRGB(Map<Integer, Color> ins) {
        int r = 0, g = 0, b = 0;
        for (Map.Entry<Integer, Color> pair : ins.entrySet()) {
            if (pair.getValue().equals(colorsInstance[0])) r++;
            if (pair.getValue().equals(colorsInstance[1])) g++;
            if (pair.getValue().equals(colorsInstance[2])) b++;
        }
        info(ins.getClass().getCanonicalName(), r, g, b);
    }

    public static String getRandomColorName() {
        return colorsName[rand.nextInt(3)];
    }

    public static void info(String storageType, int r, int g, int b) {
        System.out.printf("Storage type: %s\nR:%d\tG:%d\tB:%d\n\n", storageType, r, g, b);
    }

    public static void test1() {
        System.out.println("test1");
        colorSet = new HashSet<>();
        colorList = new ArrayList<>();
        colorMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            colorList.add(new Color(getRandomColorName()));
            colorMap.put(i, new Color(getRandomColorName()));
            colorSet.add(new Color(getRandomColorName()));
        }
        checkRGB(colorList);
        checkRGB(colorSet);
        checkRGB(colorMap);
        System.out.println();
    }

    public static void test2() {
        System.out.println("test2");
        colorSet = new HashSet<>();
        colorList = new ArrayList<>();
        colorMap = new HashMap<>();
        Color temp;
        for (int i = 0; i < 100; i++) {
            temp = new Color(getRandomColorName());
            colorList.add(temp);
            colorSet.add(temp);
            colorMap.put(i, temp);
        }
        checkRGB(colorList);
        checkRGB(colorSet);
        checkRGB(colorMap);
        System.out.println();
    }

    public static void main(String[] args) {
        test1();
        test2();
    }
}
