package home.akos.matekgyakorlo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Szorzas extends Feladat {
    private static int SZAMKOR_OVERRIDE = 10;

    public Szorzas(boolean negalt) {
        super(negalt);
    }

    @Override
    public List<String> csinaljFeladatokat(int muveletekSzama, int szamkor) {
        Random rand = new Random();
        return IntStream.range(0, muveletekSzama)
                .boxed()
                .map(i -> {
                    int elsoTag = rand.nextInt(SZAMKOR_OVERRIDE - 2) + 2;
                    int masodikTag = rand.nextInt(SZAMKOR_OVERRIDE - 2) + 2;
                    final int hanyJegyuLegyen = hanyJegyuLegyen(szamkor);
                    if (hanyJegyuLegyen>2) {
                        final int melyiket = rand.nextInt(3);
                        if (melyiket==0) {
                            elsoTag *= Math.pow(10, hanyJegyuLegyen - 2);
                        } else if (melyiket==1) {
                            masodikTag *= Math.pow(10,hanyJegyuLegyen-2);
                        }
                    }
                    int eredmeny = elsoTag * masodikTag;
                    if (!isNegalt()) {
                        return new int[]{elsoTag, masodikTag, eredmeny};
                    } else {
                        return new int[]{eredmeny, masodikTag, elsoTag};
                    }
                })
                .map(this::sorOsszefuzes)
                .collect(Collectors.toList());
    }

    private int hanyJegyuLegyen(int szamkor) {
        final int hossz = String.valueOf(szamkor).length();
        if (hossz > 2) {
            return hossz - 1;
        } else {
            return 2;
        }
    }

    @Override
    protected String getJel() {
        return !isNegalt() ? "*" : ":";
    }
}
