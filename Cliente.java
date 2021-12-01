import java.util.Objects;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/////////CRIANDO CLASSE//////////
public class Cliente extends Pessoa{

    private String telefone;
    private ArrayList<Receita> receita = new ArrayList<>();

    private final static String url = "jdbc:mysql://localhost:3306/sistemaPadoca?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    //////CRIANDO CONSTRUTOR//////
    public Cliente(
        int id,
        String nome,
        String cpf,
        String dtNasc,
        String telefone
    ) {
        super(id, nome, cpf, dtNasc);
        this.telefone = telefone;
        BancoDeDados.setCliente(this);
    }

    public Cliente(
        String nome,
        String cpf,
        String dtNasc,
        String telefone
    ) {
        super(nome, cpf, dtNasc);
        this.telefone = telefone;
        BancoDeDados.setCliente(this);
    }
    //////METODOS SET, GET E ADICIONAR RECEITA NO CLIENTE/////
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setReceita(Receita receita) {
        this.receita.add(receita);
    }

    public void adicionarReceita(Receita receita) {
        this.receita.add(receita);
        receita.adicionarCliente(this);
    }

    public ArrayList<Receita> getReceita() {
        return this.receita;
    }

    public static void insertClientePS(Cliente cliente) {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = con.prepareStatement("INSERT INTO cliente "
                            + "(nome, cpf, dtNasc, telefone) VALUES "
                            + "(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1, cliente.getNome());
            stm.setString(2, cliente.getCpf());
            stm.setString(3, cliente.getDtNasc());
            stm.setString(4, cliente.getTelefone());
            if (stm.executeUpdate() > 0) {
                ResultSet rs = stm.getGeneratedKeys();

                if (rs.next()) {
                    System.out.println(new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getString("dtNasc"),
                        rs.getString("telefone")
                    )); 
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateClientePS(Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = con.prepareStatement("UPDATE cliente SET "
                            + " nome = ?"
                            + ", cpf = ?"
                            + ", dtNasc = ?"
                            + ", telefone = ?"
                            + " WHERE id = ?");
            pStm.setString(1, cliente.getNome());
            pStm.setString(2, cliente.getCpf());
            pStm.setString(3, cliente.getDtNasc());
            pStm.setString(4, cliente.getTelefone());
            pStm.setInt(5, cliente.getId());
            if (pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteClientePS(Cliente cliente) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = con.prepareStatement("DELETE FROM cliente WHERE id = ?");
            pStm.setInt(1, cliente.getId());
            if(pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //////COMPARAÇÃO DE VALORES/////
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(this.getId(), cliente.getId());
    }

    //////EXIBINDO DADOS DO CLIENTE////////
    @Override
    public String toString() {
        String retorno =
            super.toString()
            + "\nTelefone =" + getTelefone();

            for (Receita receita : this.receita) {

                retorno += "\n   " + receita.toString();

            }
        return retorno;
    }

    public String carteira(){
        return super.toString()
        + "\nTelefone =" + getTelefone();
    }
}
