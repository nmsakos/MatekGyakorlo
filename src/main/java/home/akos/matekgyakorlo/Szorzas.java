package home.akos.matekgyakorlo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Szorzas extends Feladat {

    public Szorzas(boolean negalt) {
        super(negalt);
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
                    if (!isNegalt()) {
                        return new int[]{elsoTag, masodikTag, eredmeny};
                    } else {
                        return new int[]{eredmeny, masodikTag, elsoTag};
                    }
                })
                .map(this::sorOsszefuzes)
                .collect(Collectors.toList());
    }

    @Override
    protected String getJel() {
        return !isNegalt() ? "*" : ":";
    }
}
