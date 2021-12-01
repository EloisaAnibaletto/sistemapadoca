import java.util.Objects;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/////CRIANDO CLASSE//////
public class Chef extends Pessoa implements CalcularSalarioAno{
    
    private String especialidade;
    private double salario;
    private ArrayList<Receita> receita = new ArrayList<>();

    private final static String url = "jdbc:mysql://localhost:3306/sistemaPadoca?useTimezone=true&serverTimezone=UTC";
    private final static String user = "root";
    private final static String password = "";

    //////CRIANDO CONSTRUTOR//////
    public Chef(
        int id,
        String nome,
        String cpf,
        String dtNasc,
        String especialidade,
        double salario
    ) {
        super(id, nome, cpf, dtNasc);
        this.especialidade = especialidade;
        this.salario = salario;
    }

    public Chef(
        String nome,
        String cpf,
        String dtNasc,
        String especialidade,
        double salario
    ) {
        super(nome, cpf, dtNasc);
        this.especialidade = especialidade;
        this.salario = salario;
    }

    //////METODOS SET, GET E ADICIONAR RECEITA NO CHEF/////
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return this.especialidade;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getSalario() {
        return this.salario;
    }

    public void adicionarReceita(Receita receita) {
        this.receita.add(receita);
    }

    public ArrayList<Receita> getReceita() {
        return receita;
    }

    public double calcularSalarioAno() {
        return salario * 12;
    }

    public static void insertChefPS(Chef chef) {
        try{
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement stm = con.prepareStatement("INSERT INTO chef "
                            + "(nome, cpf, dtNasc, especialidade, salario) VALUES "
                            + "(?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            stm.setString(1, chef.getNome());
            stm.setString(2, chef.getCpf());
            stm.setString(3, chef.getDtNasc());
            stm.setString(4, chef.getEspecialidade());
            stm.setDouble(5, chef.getSalario());
            if (stm.executeUpdate() > 0) {
                ResultSet rs = stm.getGeneratedKeys();

                if (rs.next()) {
                    int generateId = rs.getInt(1);
                    ResultSet selectRs = con.createStatement().executeQuery("SELECT * FROM chef WHERE id = "+ generateId);
                    selectRs.next();

                    System.out.println(new Chef(
                        selectRs.getString("nome"),
                        selectRs.getString("cpf"),
                        selectRs.getString("dtNasc"),
                        selectRs.getString("especialidade"),
                        selectRs.getDouble("salario")
                    )); 
                }
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    
    public static void updateChefPS(Chef chef) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = con.prepareStatement("UPDATE chef SET "
                            + " nome = ?"
                            + ", cpf = ?"
                            + ", dtNasc = ?"
                            + ", especialidade = ?"
                            + ", salario = ?"
                            + " WHERE id = ?");
            pStm.setString(1, chef.getNome());
            pStm.setString(2, chef.getCpf());
            pStm.setString(3, chef.getDtNasc());
            pStm.setString(4, chef.getEspecialidade());
            pStm.setDouble(5, chef.getSalario());
            pStm.setInt(6, chef.getId());
            if (pStm.executeUpdate() <= 0) {
                System.out.println("Falha na execução.");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteChefPS(Chef chef) {
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            PreparedStatement pStm = con.prepareStatement("DELETE FROM chef WHERE id = ?");
            pStm.setInt(1, chef.getId());
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
        if (!(o instanceof Chef)) {
            return false;
        }
        Chef chef = (Chef) o;
        return Objects.equals(this.getId(), chef.getId());
    }

    //////EXIBINDO DADOS DO CHEF////////
    @Override
    public String toString() {
        String retorno =
            super.toString()
            + "\nEspecialidade =" + getEspecialidade()
            + "\nSalario =" + getSalario();
            retorno += Imprimir.arrayListToString(this.receita);
        return retorno;
    }

    public String carteira(){
        return super.toString()
        + "\nEspecialidade =" + getEspecialidade()
        + "\nSalario =" + getSalario();
    }

}
