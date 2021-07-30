package lessons_challenges;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class StringManipulation {
    public static void exercicioUm() {
        String str = "A B C D E F G";
        char[] charArray;

        charArray = str.toCharArray();

        for (int i = (charArray.length - 1) ; i > 0 ; i--) {
            System.out.println(charArray[i]);
        }
    }

    public static void exercicioDois() {
        String text = "Walk Melchizidek shrine descender " +
                "At Lebanon - priest ascending " +
                "And back toward Lebanon priest ascending " +
                "Menyelek now proceeds " +
                "Through the Red Sea " +
                "Reabsorbed on the peak of mountain " +
                "And reabsorb on the peak of mountain ";

        String[] textArray = text.split(" ");
        Map<Character, Integer> charOccurrences = new HashMap<Character, Integer>();

        for (int i = 0 ; i < textArray.length ; i++) {
            char[] wordArray = textArray[i].toCharArray();
            for (int j = 0 ; j < wordArray.length ; j++) {
                if(charOccurrences.containsKey(wordArray[j])) {
                    charOccurrences.replace(wordArray[j], (charOccurrences.get(wordArray[j]) + 1));
                } else {
                    charOccurrences.put(wordArray[j], 1);
                }
            }
        }
        System.out.println(charOccurrences.toString());
    }

    public static void exercicioQuatro() {
        String text = "rje_taime7@pfmretire.com sended an email to mali123a56@2990303.ru";

        String censoredText = text.replaceAll("[0-9]", "#");

        System.out.println(censoredText);
    }

    public static void ceaserCipher(int alphabetShift, String txt) {
        txt = txt.replaceAll("\\s+","").toUpperCase(Locale.ROOT);
        char[] charArray = txt.toCharArray();

        for (int i = 0 ; i < charArray.length ; i++) {
            if ((int) charArray[i] + alphabetShift > 90) {
                int asciiOffset = (int) charArray[i] + alphabetShift;
                asciiOffset = asciiOffset - 90;

                charArray[i] = (char) (((int) charArray[i] + alphabetShift) - 25+asciiOffset);
            } else {
                charArray[i] = (char) ((int) charArray[i] + alphabetShift);
            }
        }

        System.out.println(new String(charArray));
    }

    public static void main(String[] args) {
        // Exercícios propostos na aula "Desenvolvimento básico Java - Strings e o pacote java.lang"

        //1) Utilizando o método toCharArray para iterar sobre a string e imprimir ao contrário.
        exercicioUm();

        //2) Utilizando o método split na análise de uma cadeia para encontrar a quantidade de ocorrências de cada caractér.
        exercicioDois();

        //3) Utilizando concat invés do operador +.
        System.out.println("O".concat("M").concat(" Addis"));

        //4) Substituindo os números de uma cadeia utilizando replaceall com regex.
        exercicioQuatro();

        //Exercício extra implementando a cifra de césar. (Como no exercício 1253 da https://www.urionlinejudge.com.br/).
        ceaserCipher(2, "Given your sentence youre handed the snakes of divine");
    }
}
