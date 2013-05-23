import java.lang.*;
import java.text.SimpleDateFormat;

public class ListTest {

    public static void main(String[] args) {

        SimpleDateFormat sdfToDate = new SimpleDateFormat("03/08/1987");

        List list = new List();
        list.addFirst(4L, "Max", "Jando", sdfToDate,
                "Geschaeftsfuehrer");
        list.addLast(5L, "Fruh", "Patrick", sdfToDate,
                "Arbeiter 1");
        list.addLast(6L, "Mayer", "Patrick", sdfToDate,
                "Arbeiter 2");
        list.addLast(7L, "Hek", "Vogt", sdfToDate,
                "Arbeiter 3");

        List list2 = new List();
        list2.addFirst(8L, "Max", "Jando", sdfToDate,
                "Geschaeftsfuehrer");
        list2.addLast(9L, "Fruh", "Patrick", sdfToDate,
                "Arbeiter 1");
        list2.addLast(10L, "Mayer", "Patrick", sdfToDate,
                "Arbeiter 2");
        list2.addLast(11L, "Hek", "Vogt", sdfToDate,
                "Arbeiter 3");
        list.concat(list2.getFirst());

    }

}
