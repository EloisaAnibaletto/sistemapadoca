import java.util.ArrayList;
import java.util.Objects;

/////CRIANDO CLASSE//////
public class Mercado extends Estabelecimento{

    private String promocao;
    private ArrayList<Receita> receita = new ArrayList<>();

    //////CRIANDO CONSTRUTOR//////
    protected Mercado(
        int idEstabelecimento,
        String nome,
        String dtAbertura,
        String promocao,
        int idLocal,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade
    ) {
        super(idEstabelecimento, nome, dtAbertura, idLocal, cep, rua, numero, bairro, cidade);
        this.promocao = promocao;
    }

    /////////METODOS SET, GET E ADICIONANDO RECEITA//////////
    public void setReceita(Receita receita) {
        this.receita.add(receita);
    }

    public void adicionarReceita(Receita receita) {
        this.receita.add(receita);
        receita.adicionarMercado(this);
    }

    public ArrayList<Receita> getReceita() {
        return this.receita;
    }

    public void setPromocao(String promocao) {
        this.promocao = promocao;
    }

    public String getPromocao() {
        return this.promocao;
    }

    //////COMPARAÇÃO DE VALORES/////
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Mercado)) {
            return false;
        }
        Mercado mercado = (Mercado) o;
        return Objects.equals(this.getIdEstabelecimento(), mercado.getIdEstabelecimento());
    }

    //////EXIBINDO DADOS DO CHEF////////
    @Override
    public String toString() {
        String retorno = 
        super.toString()
            +"\nPromoção=" + getPromocao();

        for (Receita receita : this.receita) {

            retorno += "\n   " + receita.toString();

        }
    return retorno;
    }

}
