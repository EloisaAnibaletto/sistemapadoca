import java.util.Objects;

/////CRIANDO CLASSE//////
public abstract class Estabelecimento {
    
    private int idEstabelecimento;
    private String nome;
    private String dtAbertura;
    private Endereco endereco;

    //////CRIANDO CONSTRUTOR//////
    protected Estabelecimento(
        int idEstabelecimento,
        String nome,
        String dtAbertura,
        int idLocal,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade
    ) {
        this.idEstabelecimento = idEstabelecimento;
        this.nome = nome;
        this.dtAbertura = dtAbertura;
        this.endereco = new Endereco(idLocal, cep, rua, numero, bairro, cidade, this);

        endereco.setEstabelecimento(this);
    }

    /////////METODOS SET, GET E ADICIONANDO RECEITA//////////
    protected void setIdEstabelecimento(int idEstabelecimento) {
        this.idEstabelecimento = idEstabelecimento;
    }

    protected int getIdEstabelecimento() {
        return this.idEstabelecimento;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    protected String getNome() {
        return this.nome;
    }

    protected void setDtAbertura(String dtAbertura) {
        this.dtAbertura = dtAbertura;
    }

    protected String getDtAbertura() {
        return this.dtAbertura;
    }

    //////COMPARAÇÃO DE VALORES/////
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Estabelecimento)) {
            return false;
        }
        Estabelecimento estabelecimento = (Estabelecimento) o;
        return Objects.equals(idEstabelecimento, estabelecimento.idEstabelecimento);
    }

    //////EXIBINDO DADOS DO CHEF////////
    @Override
    public String toString() {
        return"\nID estabelecimento =" + getIdEstabelecimento()
            + "\nNome estabelecimento=" + getNome()
            + "\nData de abertura=" + getDtAbertura()
            + "\nEndereço=" + this.endereco.toString();
    }
}
