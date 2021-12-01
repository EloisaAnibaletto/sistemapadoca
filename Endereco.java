import java.util.Objects;

/////CRIANDO CLASSE//////
public class Endereco {
    private int idLocal;
    private String cep;
    private String rua;
    private String numero;
    private String bairro;
    private String cidade;
    private Estabelecimento estabelecimento;

    //////CRIANDO CONSTRUTOR//////
    public Endereco(
        int idLocal,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade,
        Estabelecimento estabelecimento
    ) {
        this.idLocal = idLocal;
        this.cep = cep;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estabelecimento = estabelecimento;
    }

    /////////METODOS SET GET //////////
    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public int getIdLocal() {
        return this.idLocal;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return this.cep;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getRua() {
        return this.rua;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return this.numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return this.bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return this.cidade;
    }

    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    public Estabelecimento getEstabelecimento() {
        return this.estabelecimento;
    }

    //////COMPARAÇÃO DE VALORES/////
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Endereco)) {
            return false;
        }
        Endereco endereco = (Endereco) o;
        return Objects.equals(idLocal, endereco.idLocal);
    }

    //////EXIBINDO DADOS DO CHEF////////
    @Override
    public String toString() {
        return"\nCEP =" + getCep() 
            + "\nRua=" + getRua()  
            + "\nNúmero=" + getNumero()
            + "\nBairro=" + getBairro()
            + "\nCidade=" + getCidade();
    }
}
