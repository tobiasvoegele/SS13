import java.util.Scanner;

public class GroßesProgramm {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String eingabe;

        System.out.println("Bitte geben Sie ein Wort ein: ");
        eingabe = in.nextLine();
        textAnalyse analyse = new textAnalyse(eingabe);

        int[] amount = analyse.getAnalyseAmount();
        printArray(amount);
        float[] percentage = analyse.getAnaylsePercents();
        printArray(percentage);
        System.out.println(analyse.getCaesarChiffre(1));
        System.out.println(analyse.getUpperLower(eingabe,true));
        System.out.println(analyse.getUpperLower(eingabe,false));
    }


    public static void printArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void printArray(float[] array){
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }


}
