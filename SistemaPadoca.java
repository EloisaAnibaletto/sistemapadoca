import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SistemaPadoca {
    public static void main(String[] args) throws Exception{

        final String url = "jdbc:mysql://localhost:3306/sistemaPadoca?useTimezone=true&serverTimezone=UTC";
        final String user = "root";
        final String password = "";

        ///////////////Inserindo dados /////////////////// 
        Chef chefUm = new Chef(1, "Timotio", "111.222.333-44", "01/01/1970", "Fazer comida",15.000);
        Chef chefDois = new Chef(2, "Bastião", "555.666.777-88", "02/02/1980", "Fazer comida",10.000);
        Chef chefTres = new Chef(3, "Jubileu", "888.999.111-22", "03/03/1990", "Fazer comida",20.000);

        Padaria padariaUm = new Padaria(1, "Pão Bão", "01/01/2001", "15/01/1990", 1, "89223-100", "Av. Getulio", "100", "Anita", "Joinville");
        Padaria padariaDois = new Padaria(2, "Veio Du Céu", "02/02/2002", "20/10/2005", 2, "89100-200", "Av. João colin", "200", "Centro", "Joinville");
        Padaria padariaTres = new Padaria(3, "Só Coisa Boa", "03/03/2003", "05/15/2000", 3, "89333-121", "Av. Blumenau", "300", "Centro", "Joinville");

        Receita receitaUm = new Receita(1, "Fritar ovo", "Poím olio na frijidera e creba o ovo e frita", 3, 8.0, chefUm);
        Receita receitaDois = new Receita(2, "Reztó d'Onté", "Aquecer no micro e por no prato", 2, 0, chefUm);
        Receita receitaTres = new Receita(3, "Pão doce", "Abrir o pão passar banha e adicionar açucar", 3, 2.0, chefUm);
        Receita receitaQuatro = new Receita(4, "Macarrão com tempero diferenciado", "Abra o miojo, cozinhe por 5 minutos e tempere com o tempero que acompanha", 3, 4.0, chefDois);
        Receita receitaCinco = new Receita(5, "Mistão", "Pão de ontem, ovo frito, queijo, presunto, milho, ervilha, resto de almoço, maionese, ketchup, junta tudo oque puder e é só saborear", 8, 15.0, chefDois);
        Receita receitaSeis = new Receita(6, "Pirão d'agua", "Esquentar água, misturar farinha de mandioca com a água e acescentar temperos", 3, 12.0, chefDois);
        Receita receitaSete = new Receita(7, "Minestra", "Bater o feijão no liquidificador juntar feijão com arroz cozido ou macarrão e cozinhar", 3, 15.0, chefTres);
        Receita receitaOito = new Receita(8, "Brigadeiro", "Juntar em uma panela leite condensado, nescal, uma colher de margarina e ferver até engrossar", 2, 12.0, chefTres);
        Receita receitaNove = new Receita(9, "Beijinho", "Juntar em uma panela leite condensado, coco ralado e uma colher de margarina e ferver até engrossar", 2, 12.0, chefTres);
        Receita receitaDez = new Receita(10, "Bife acebolado com fritas", "Temperar bife, frita-lo e acrescentar a cebola", 3, 50.0, chefDois);

        Mercado mercadoUm = new Mercado(15, "Diasville", "10/03/1996", "Promocao picanha R$29.99", 4, "89222-222", "Rua Fátima", "740", "Fátima", "Joinville");
        Mercado mercadoDois = new Mercado(16, "Condor", "15/05/2000", "Promocao coxão mole R$19.99", 5, "89111-111", "Rua Florianopolis", "5000", "Guanabara", "Joinville");
        Mercado mercadoTres = new Mercado(17, "Big", "05/03/1980", "Promocao costela R$10.99", 6, "89333-333", "Av. Getulio", "105", "Anita", "Joinville");

       Cliente clienteUm = new Cliente(20, "Dona Benta", "222.666.999-00", "02/02/1969", "3422-7878");
        Cliente clienteDois = new Cliente(21, "Francisco Bento", "888.999.777-22", "15/01/1975", "99999-5252");
        Cliente clienteTres = new Cliente(22, "Euclides Correa", "555.111.333-77", "06/08/1972", "99888-1515");
        
        
        /////////Adicionando receitas as padarias///////////
        padariaUm.adicionarReceita(receitaUm);
        padariaUm.adicionarReceita(receitaDois);
        padariaUm.adicionarReceita(receitaTres);
        padariaUm.adicionarReceita(receitaQuatro);
        padariaUm.adicionarReceita(receitaCinco);

        padariaDois.adicionarReceita(receitaSeis);
        padariaDois.adicionarReceita(receitaSete);
        padariaDois.adicionarReceita(receitaOito);
        padariaDois.adicionarReceita(receitaNove);
        padariaDois.adicionarReceita(receitaUm);

        padariaTres.adicionarReceita(receitaDois);
        padariaTres.adicionarReceita(receitaTres);
        padariaTres.adicionarReceita(receitaQuatro);
        padariaTres.adicionarReceita(receitaCinco);
        padariaTres.adicionarReceita(receitaSeis);

        ////////Adicionando receitas aos mercados///////////////
        mercadoUm.adicionarReceita(receitaUm);
        mercadoUm.adicionarReceita(receitaDois);
        mercadoUm.adicionarReceita(receitaTres);

        mercadoDois.adicionarReceita(receitaQuatro);
        mercadoDois.adicionarReceita(receitaCinco);
        mercadoDois.adicionarReceita(receitaSeis);

        mercadoTres.adicionarReceita(receitaSete);
        mercadoTres.adicionarReceita(receitaOito);
        mercadoTres.adicionarReceita(receitaNove);

        ////////Adicionando receitas aos clientes//////////////
        clienteUm.adicionarReceita(receitaDez);
        clienteUm.adicionarReceita(receitaUm);
        clienteUm.adicionarReceita(receitaDois);

        clienteDois.adicionarReceita(receitaTres);
        clienteDois.adicionarReceita(receitaQuatro);
        clienteDois.adicionarReceita(receitaCinco);

        clienteTres.adicionarReceita(receitaSeis);
        clienteTres.adicionarReceita(receitaSete);
        clienteTres.adicionarReceita(receitaOito);
        
        ////////////////////////Imprimindo os chefs e suas receita////////////////////////////
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Escolha a opção");
            System.out.println("1- PADARIAS E SUAS RECEITAS");
            System.out.println("2- MERCADO E SUAS RECEITAS");
            System.out.println("3- CHEF SELECT");
            System.out.println("4- CHEF INSERT");
            System.out.println("5- CHEF UPDATE");
            System.out.println("6- CHEF DELETE");
            System.out.println("7- CLIENTE SELECT");
            System.out.println("8- CLIENTE INSERT");
            System.out.println("9- CLIENTE UPDATE");
            System.out.println("10- CLIENTE DELETE");
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 0:
                    System.out.println("Sair! Obrigado!");
                    break;
                case 1:
                    //Exibe os dados da padaria e suas receitas
                    System.out.println(Cores.RED_BOLD_BRIGHT + "\n+============+ " + Cores.PURPLE_BOLD_BRIGHT + "PADARIAS" + Cores.RED_BOLD_BRIGHT + " +============+" + Cores.RESET);
                    System.out.println(padariaUm);
                    System.out.println(padariaDois);
                    System.out.println(padariaTres);
                    break;
                case 2:
                    //Exibe os dados do mercado e suas receitas
                    System.out.println(Cores.RED_BOLD_BRIGHT + "\n+============+ " + Cores.PURPLE_BOLD_BRIGHT + "MERCADOS" + Cores.RED_BOLD_BRIGHT + " +============+" + Cores.RESET);
                    System.out.println(mercadoUm);
                    System.out.println(mercadoDois);
                    System.out.println(mercadoTres);
                    break;
                case 3:
                    try {
                        System.out.println(Cores.RED_BOLD_BRIGHT + "\n+============+ " + Cores.PURPLE_BOLD_BRIGHT + "SELECT CHEF" + Cores.RED_BOLD_BRIGHT + " +============+" + Cores.RESET);
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stm = con.prepareStatement("SELECT * FROM chef;");
                        ResultSet sql = stm.executeQuery();
                        while(sql.next()) {
                            System.out.println(new Chef(
                                sql.getInt("id"),
                                sql.getString("nome"),
                                sql.getString("cpf"),
                                sql.getString("dtNasc"),
                                sql.getString("especialidade"),
                                sql.getDouble("salario")
                            ));
                        }
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        System.out.println(Cores.RED_BOLD_BRIGHT + "\n+============+ " + Cores.PURPLE_BOLD_BRIGHT + "INSERINDO CHEF" + Cores.RED_BOLD_BRIGHT + " +============+" + Cores.RESET);
                        System.out.println("Informe o nome do chef");
                        String nome = scanner.nextLine();
                        System.out.println("Informe o CPF do chef");
                        String cpf = scanner.nextLine();
                        System.out.println("Informe a Data de Nascimento do chef");
                        String dtNasc = scanner.nextLine();
                        System.out.println("Informe o Especialidade do chef");
                        String especialidade = scanner.nextLine();
                        System.out.println("Informe o Salario do chef");
                        Double salario = scanner.nextDouble();

                        Chef chefQuatro = new Chef(nome, cpf, dtNasc, especialidade, salario);
                        Chef.insertChefPS(chefQuatro);
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        System.out.println(Cores.RED_BOLD_BRIGHT + "\n+============+ " + Cores.PURPLE_BOLD_BRIGHT + "UPDATE CHEF" + Cores.RED_BOLD_BRIGHT + " +============+" + Cores.RESET);
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        System.out.println("Informe o ID de alteração: ");
                        int id = scanner.nextInt();
                        ResultSet rs = stm.executeQuery("SELECT * FROM chef WHERE id = " + id);
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Chef chef = new Chef(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("dtNasc"),
                            rs.getString("especialidade"),
                            rs.getDouble("salario")
                        );
                        con.close();
                        System.out.println("Informe o nome do chef (Deixar vazio para manter)");
                        String nome = scanner.next();
                        if (nome.length() > 0){
                            chef.setNome(nome);
                        }
                        System.out.println("Informe o CPF do chef (Deixar vazio para manter)");
                        String cpf = scanner.next();
                        if (cpf.length() > 0){
                            chef.setCpf(cpf);
                        }
                        System.out.println("Informe a Data de Nascimento do chef (Deixar vazio para manter)");
                        String dtNasc = scanner.next();
                        if (dtNasc.length() > 0){
                            chef.setDtNasc(dtNasc);
                        }
                        System.out.println("Informe a Especialidade do chef (Deixar vazio para manter)");
                        String especialidade = scanner.next();
                        if (especialidade.length() > 0){
                            chef.setEspecialidade(especialidade);
                        }
                        System.out.println("Informe o Salario do chef (Deixar vazio para manter)");
                        Double salario = scanner.nextDouble();
                        if (salario != 0){
                            chef.setSalario(salario);
                        }
                        
                        Chef.updateChefPS(chef);
                        
                    } catch (SQLException e) {

                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    try {
                        System.out.println(Cores.RED_BOLD_BRIGHT + "\n+============+ " + Cores.PURPLE_BOLD_BRIGHT + "DELETE CHEF" + Cores.RED_BOLD_BRIGHT + " +============+" + Cores.RESET);
                        System.out.println("Informe o ID de exclusão: ");
                        int id = scanner.nextInt();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM chef WHERE id = " + id);
            
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        
                        Chef chef = new Chef(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("dtNasc"),
                            rs.getString("especialidade"),
                            rs.getDouble("salario")
                        );

                        Chef.deleteChefPS(chef);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                    case 7:
                    try {
                        System.out.println(Cores.RED_BOLD_BRIGHT + "\n+============+ " + Cores.PURPLE_BOLD_BRIGHT + "SELECT CLIENTE" + Cores.RED_BOLD_BRIGHT + " +============+" + Cores.RESET);
                        Connection con = DriverManager.getConnection(url, user, password);
                        PreparedStatement stm = con.prepareStatement("SELECT * FROM cliente;");
                        ResultSet sql = stm.executeQuery();
                        while(sql.next()) {
                            System.out.println(new Cliente(
                                sql.getInt("id"),
                                sql.getString("nome"),
                                sql.getString("cpf"),
                                sql.getString("dtNasc"),
                                sql.getString("telefone")
                            ));
                        }
                        con.close();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    try {
                        System.out.println(Cores.RED_BOLD_BRIGHT + "\n+============+ " + Cores.PURPLE_BOLD_BRIGHT + "INSERINDO CLIENTE" + Cores.RED_BOLD_BRIGHT + " +============+" + Cores.RESET);
                        System.out.println("Informe o nome do Cliente");
                        String nome = scanner.nextLine();
                        System.out.println("Informe o CPF do Cliente");
                        String cpf = scanner.nextLine();
                        System.out.println("Informe a Data de Nascimento do Cliente");
                        String dtNasc = scanner.nextLine();
                        System.out.println("Informe o Telefone do Cliente");
                        String telefone = scanner.nextLine();

                        Cliente clienteQuatro = new Cliente(nome, cpf, dtNasc, telefone);
                        Cliente.insertClientePS(clienteQuatro);
                        
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 9:
                    try {
                        System.out.println(Cores.RED_BOLD_BRIGHT + "\n+============+ " + Cores.PURPLE_BOLD_BRIGHT + "UPDATE CLIENTE" + Cores.RED_BOLD_BRIGHT + " +============+" + Cores.RESET);
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        System.out.println("Informe o ID de alteração: ");
                        int id = scanner.nextInt();
                        ResultSet rs = stm.executeQuery("SELECT * FROM cliente WHERE id = " + id);
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        Cliente cliente = new Cliente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("dtNasc"),
                            rs.getString("telefone")
                        );
                        con.close();
                        System.out.println("Informe o nome do cliente (Deixar vazio para manter)");
                        String nome = scanner.next();
                        if (nome.length() > 0){
                            cliente.setNome(nome);
                        }
                        System.out.println("Informe o CPF do cliente (Deixar vazio para manter)");
                        String cpf = scanner.next();
                        if (cpf.length() > 0){
                            cliente.setCpf(cpf);
                        }
                        System.out.println("Informe a Data de Nascimento do cliente (Deixar vazio para manter)");
                        String dtNasc = scanner.next();
                        if (dtNasc.length() > 0){
                            cliente.setDtNasc(dtNasc);
                        }
                        System.out.println("Informe o Telefone do cliente (Deixar vazio para manter)");
                        String telefone = scanner.next();
                        if (telefone.length() > 0){
                            cliente.setTelefone(telefone);
                        }
                        
                        Cliente.updateClientePS(cliente);
                        
                    } catch (SQLException e) {

                        System.out.println(e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        System.out.println(Cores.RED_BOLD_BRIGHT + "\n+============+ " + Cores.PURPLE_BOLD_BRIGHT + "DELETE CLIENTE" + Cores.RED_BOLD_BRIGHT + " +============+" + Cores.RESET);
                        System.out.println("Informe o ID de exclusão: ");
                        int id = scanner.nextInt();
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        ResultSet rs = stm.executeQuery("SELECT * FROM cliente WHERE id = " + id);
            
                        if(!rs.next()) {
                            throw new Exception("Id inválido");
                        }
                        
                        Cliente cliente = new Cliente(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("dtNasc"),
                            rs.getString("telefone")
                        );

                        Cliente.deleteClientePS(cliente);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                
                default:
                    System.out.println("Operação Inválida");
                    break;
            }
        } while(option != 0);
        scanner.close();
    }
}
