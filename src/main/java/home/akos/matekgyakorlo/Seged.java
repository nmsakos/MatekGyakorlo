package home.akos.matekgyakorlo;

public class Seged {

    public static String dashOrInt(int hianyzo, int sorban, int szam) {
        return hianyzo == sorban ? Character.toString(95).repeat(2) : String.format("%2d", szam);
    }

}
