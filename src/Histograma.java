import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Histograma {
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("divina_comedia_sp.txt"));

            Map<Integer, Integer> contando = new HashMap<>();


            String lector;
            while ((lector = br.readLine()) != null) {
                String[] palabras = lector.split("\s"); //con el while hacemos que se lean todas las líneas del texto y con el split dividimos la línea de texto con los espacios

                for (String palabra : palabras) {
                    int longitudP = 0;
                    StringBuilder palabra2 = new StringBuilder();
                    for (int i = 0; i < palabra.length(); i++) {
                        if (Character.isLetter(palabra.charAt(i))) {
                            palabra2.append(palabra.charAt(i));
                            longitudP++;
                        }
                    }//con el fori se comprueba la longitud de las palabras, usando el metodo isLetter que revisa si el caracter es una letra
                    //con foreach se agregan las palabra a la lista, con el StringBuilder se crea la misma palabra de letra por letra para poder verificar su longitud

                    if (longitudP >= 2 && longitudP <= 10) {
                        contando.put(longitudP, contando.getOrDefault(longitudP, 0) + 1);
                    }//se agregan las palabras de entre 2 y 10 letras con el put al Map que ya habiamos creado, ademas de la longitud de la palabra
                }
            }


            for (int i = 2; i <= 10; i++) {
                System.out.println("Hay " + contando.getOrDefault(i, 0) + " palabras de: "+ i + " letras");
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
