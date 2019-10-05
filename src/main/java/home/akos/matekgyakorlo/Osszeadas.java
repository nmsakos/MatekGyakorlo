package home.akos.matekgyakorlo;

import static home.akos.matekgyakorlo.Seged.dashOrInt;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Osszeadas implements Feladat {

    private boolean negalt;
    private String jel;

    public Osszeadas(boolean negalt, String jel) {
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
        return rand.ints(muveletekSzama, 2, szamkor)
                .boxed()
                .map(eredmeny -> {
                    final int elsoTag = rand.ints(1, 1, eredmeny)
                            .findFirst()
                            .orElse(1);
                    final int masodikTag = eredmeny - elsoTag;
                    if (!negalt) {
                        return new int[]{elsoTag, masodikTag, eredmeny};
                    } else {
                        return new int[]{eredmeny, masodikTag, elsoTag};
                    }
                })
                .map(ints -> {
                    int hianyzo = rand.nextInt(3);
                    return dashOrInt(hianyzo, 0, ints[0]) + " "
                            + getJel() + " "
                            + dashOrInt(hianyzo, 1, ints[1]) + " "
                            + "= "
                            + dashOrInt(hianyzo, 2, ints[2]);
                })
                .collect(Collectors.toList());
    }
}
