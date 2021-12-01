import java.util.ArrayList;
public class Imprimir {
    public static void imprimirElementos(ArrayList<?> elements) {
        for (Object o : elements) {
            System.out.println(o);
        }
    }

    public static String arrayListToString(ArrayList<?> elements) {
        String ret = "";

        for (Object object : elements) {
            ret += "\n   " + object;
        }

        return ret;
    }
}
