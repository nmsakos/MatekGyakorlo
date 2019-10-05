package home.akos.matekgyakorlo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.io.FileUtils;

public class Main {
    private static String ELVALASZTO = "\t\t\t";

    public static void main(String[] args) throws IOException {
        Config config = new Config(args);

        final List<List<String>> feladatok = config.getMuveletek().stream()
                .map(muv -> muv.getFeladat().csinaljFeladatokat(config.getMuveletekSzama(), config.getSzamkor()))
                .collect(Collectors.toList());

        final List<String> vegeredmeny = IntStream.range(0, config.getMuveletekSzama())
                .boxed()
                .map(i -> {
                    StringBuilder sor = new StringBuilder();
                    for (int m = 0; m < config.getMuveletek().size(); m++) {
                        sor.append(feladatok.get(m).get(i)).append(ELVALASZTO);
                    }
                    return sor.toString();
                })
                .collect(Collectors.toList());

        if (config.getKimenet() == Kimenet.FILE) {
            FileUtils.writeLines(new File("muveletek.txt"), vegeredmeny);
        } else {
            System.out.println(vegeredmeny);
        }
    }

}
