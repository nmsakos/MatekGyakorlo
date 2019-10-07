package home.akos.matekgyakorlo;

import static home.akos.matekgyakorlo.Seged.dashOrInt;

import java.util.List;
import java.util.Random;

public abstract class Feladat {
    private String jel;
    private boolean negalt;

    protected Feladat(boolean negalt) {
        this.negalt = negalt;
    }

    public abstract List<String> csinaljFeladatokat(int muveletekSzama, int szamkor);

    protected abstract String getJel();

    public boolean isNegalt() {
        return negalt;
    }

    protected String sorOsszefuzes(int[] ints) {
        int hianyzo = new Random().nextInt(3);
        return dashOrInt(hianyzo, 0, ints[0]) + " "
                + getJel() + " "
                + dashOrInt(hianyzo, 1, ints[1]) + " "
                + "= "
                + dashOrInt(hianyzo, 2, ints[2]);
    }

}
