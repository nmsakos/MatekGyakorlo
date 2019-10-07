package home.akos.matekgyakorlo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Osszeadas extends Feladat {

    public Osszeadas(boolean negalt) {
        super(negalt);
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
        return !isNegalt() ? "+" : "-";
    }
}
