package home.akos.matekgyakorlo;

import static home.akos.matekgyakorlo.Seged.dashOrInt;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Szorzas implements Feladat {

    private boolean negalt;
    private String jel;

    public Szorzas(boolean negalt, String jel) {
        this.negalt = negalt;
        this.jel = jel;
    }

    @Override
    public String getJel() {
        return jel;
    }

    @Override
    public List<String> csinaljFeladatokat(int muveletekSzama, int szamkor) {
        Random rand = new Random();
        int szamkorOverride = 10;
        return IntStream.range(0, muveletekSzama)
                .boxed()
                .map(i -> {
                    int elsoTag = rand.nextInt(szamkorOverride - 2) + 2;
                    int masodikTag = rand.nextInt(szamkorOverride - 2) + 2;
                    int eredmeny = elsoTag * masodikTag;
                    if (!negalt) {
                        return new int[]{elsoTag, masodikTag, eredmeny};
                    } else {
                        return new int[]{eredmeny, masodikTag, elsoTag};
                    }
                })
                .map(tagok -> {
                    int hianyzo = rand.nextInt(3);
                    String muvelet = dashOrInt(hianyzo, 0, tagok[0]) + " "
                            + getJel() + " "
                            + dashOrInt(hianyzo, 1, tagok[1]) + " "
                            + "= "
                            + dashOrInt(hianyzo, 2, tagok[2]);
                    return muvelet;
                })
                .collect(Collectors.toList());
    }
}
