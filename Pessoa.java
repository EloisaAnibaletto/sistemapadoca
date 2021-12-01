import java.util.Objects;

/////CRIANDO CLASSE///////
public abstract class Pessoa {
    
    private int id;
    private String nome;
    private String cpf;
    private String dtNasc;

    //////CRIANDO CONSTRUTOR//////
    protected Pessoa(int id, String nome, String cpf, String dtNasc) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
    }

    protected Pessoa(String nome, String cpf, String dtNasc) {
        this.nome = nome;
        this.cpf = cpf;
        this.dtNasc = dtNasc;
    }

    /////////METODOS SET E GET//////////
    protected void setId(int id) {
        this.id = id;
    }

    protected int getId() {
        return this.id;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getNome() {
        return this.nome;
    }

    protected void setCpf(String cpf) {
        this.cpf = cpf;
    }

    protected String getCpf() {
        return this.cpf;
    }

    protected void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }

    protected String getDtNasc() {
        return this.dtNasc;
    }

    //////COMPARAÇÃO DE VALORES/////
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pessoa)) {
            return false;
        }
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id);
    }

    ///////EXIBINDO DADOS DA PESSOA///////
    @Override
    public String toString() {
        return "\nID =" + getId() 
            + "\nNome =" + getNome() 
            + "\nCPF=" + getCpf() 
            + "\nData de nascimento=" + getDtNasc();
    }

    public abstract String carteira();
}