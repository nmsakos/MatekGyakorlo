package home.akos.matekgyakorlo;

import java.util.Arrays;

public enum Muvelet {
    ISMERETLEN(null),
    OSSZEADAS(new Osszeadas(false, "+")),
    KIVONAS(new Osszeadas(true, "-")),
    SZORZAS(new Szorzas(false, "*")),
    OSZTAS(new Szorzas(true, ":"));

    private final Feladat feladat;

    Muvelet(Feladat feladat) {
        this.feladat = feladat;
    }

    public Feladat getFeladat() {
        return feladat;
    }

    public static Muvelet byJel(String jel) {
        return Arrays.stream(values())
                .filter(muv -> muv != ISMERETLEN)
                .filter(muv -> muv.feladat.getJel().equals(jel))
                .findFirst()
                .orElse(ISMERETLEN);
    }
}
