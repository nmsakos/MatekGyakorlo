package home.akos.matekgyakorlo;

import java.util.List;

public interface Feladat {

    List<String> csinaljFeladatokat(int muveletekSzama, int szamkor);
    String getJel();
}
