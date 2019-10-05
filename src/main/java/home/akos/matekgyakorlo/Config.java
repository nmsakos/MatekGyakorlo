package home.akos.matekgyakorlo;

import java.util.List;
import java.util.stream.Collectors;

public class Config {

    private static final String MUVELETEK_SZAMA = "muveletekSzama";
    private static final String SZAMKOR = "szamkor";
    private static final String KIMENET = "kimenet";
    private static final String MUVELETEK = "muveletek";

    private int muveletekSzama = 10;
    private int szamkor = 100;
    private Kimenet kimenet = Kimenet.FILE;
    private List<Muvelet> muveletek = List.of(Muvelet.OSSZEADAS, Muvelet.KIVONAS, Muvelet.SZORZAS, Muvelet.OSZTAS);

    public Config(String... args) {
        for (int i = 0; i < args.length; i++) {
            final String[] param = args[i].split("=");
            if (MUVELETEK_SZAMA.equals(param[0])) {
                muveletekSzama = Integer.parseInt(param[1]);
            }
            if (SZAMKOR.equals(param[0])) {
                szamkor = Integer.parseInt(param[1]);
            }
            if (KIMENET.equals(param[0])) {
                kimenet = Kimenet.valueOf(param[1]);
            }
            if (MUVELETEK.equals(param[0])) {
                muveletek = param[1].chars()
                        .boxed()
                        .map(Character::toString)
                        .map(Muvelet::byJel)
                        .collect(Collectors.toList());
            }
        }
    }

    public int getMuveletekSzama() {
        return muveletekSzama;
    }

    public int getSzamkor() {
        return szamkor;
    }

    public Kimenet getKimenet() {
        return kimenet;
    }

    public List<Muvelet> getMuveletek() {
        return muveletek;
    }
}
