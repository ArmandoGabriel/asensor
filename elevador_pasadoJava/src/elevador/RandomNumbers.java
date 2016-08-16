package elevador;

import java.util.Random;

public final class RandomNumbers {

    private static Random r;

    public static int nextNumber() {
        if (r == null) {
            Seed();
        }

        return r.nextInt();
    }

    public static int nextNumber(int ceiling) {
        if (r == null) {
            Seed();
        }

        return r.nextInt(ceiling);
    }

    public static void Seed() {
        r = new Random();
    }

    public static void Seed(int seed) {
        r = new Random(seed);
    }
}
