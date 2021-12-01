import java.util.ArrayList;
import java.util.Objects;

/////CRIANDO CLASSE//////
public class Receita {
    
    private int idReceita;
    private String nome;
    private String etapas;
    private int numEtapas;
    private double valor;
    private Chef chef;
    private ArrayList<Padaria> padaria = new ArrayList<>();
    private ArrayList<Cliente> cliente = new ArrayList<>();
    private ArrayList<Mercado> mercado = new ArrayList<>();

    //////CRIANDO CONSTRUTOR//////
    public Receita(
        int idReceita,
        String nome,
        String etapas,
        int numEtapas,
        double valor,
        Chef chef
    ) {
        this.idReceita = idReceita;
        this.nome = nome;
        this.etapas = etapas;
        this.numEtapas = numEtapas;
        this.valor = valor;
        this.chef = chef;

        chef.adicionarReceita(this);
    }

    //////METODOS SET, GET E ADICIONANDO CHEF, CLIENTE, PADARIA E MERCADO NA RECEITA/////
    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public int getIdReceita() {
        return this.idReceita;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }

    public void setEtapas(String etapas) {
        this.etapas = etapas;
    }

    public String getEtapas() {
        return this.etapas;
    }

    public void setNumEtapas(int numEtapas) {
        this.numEtapas = numEtapas;
    }

    public int getNumEtapas() {
        return this.numEtapas;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return this.valor;
    }

    public void setChef(Chef chef) {
        this.chef = chef;
    }

    public Chef getChef() {
        return this.chef;
    }

    public void setPadaria(Padaria padaria) {
        this.padaria.add(padaria);
    }

    public ArrayList<Padaria> getPadaria() {
        return this.padaria;
    }

    public void adicionarPadaria(Padaria padaria) {
        this.padaria.add(padaria);

    }

    public void setCliente(Cliente cliente) {
        this.cliente.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return this.cliente;
    }

    public void adicionarCliente(Cliente clientes) {
        this.cliente.add(clientes);
    }

    public void setMercado(Mercado mercado) {
        this.mercado.add(mercado);
    }

    public ArrayList<Mercado> getMercado() {
        return this.mercado;
    }

    public void adicionarMercado(Mercado mercado) {
        this.mercado.add(mercado);

    }

    //////COMPARAÇÃO DE VALORES/////
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Receita)) {
            return false;
        }
        Receita receita = (Receita) o;
        return Objects.equals(this.getIdReceita(), receita.getIdReceita());
    }

    //////EXIBINDO DADOS DO CHEF////////
    @Override
    public String toString() {
        return "\nID receita =" + getIdReceita()
            + "\nNome receita =" + getNome()
            + "\nEtapas =" + getEtapas()
            + "\nNúmeros etapas =" + getNumEtapas()
            + "\nValor =" + getValor();
    }

}
