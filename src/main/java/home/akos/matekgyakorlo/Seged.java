package home.akos.matekgyakorlo;

public class Seged {

    public static String dashOrInt(int hianyzo, int sorban, int szam) {
        int hossz = 4;
        final String pattern = "%"+hossz+"d";
        return hianyzo == sorban ? Character.toString(95).repeat(hossz) : String.format(pattern, szam);
    }

}
