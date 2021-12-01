import java.util.ArrayList;

public class BancoDeDados {
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Chef> chefs = new ArrayList<>();
    
    public static void setCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setChef(Chef chef) {
        chefs.add(chef);
    }

    public static ArrayList<Chef> getChefs() {
        return chefs;
    }


    
}