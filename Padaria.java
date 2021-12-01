import java.util.ArrayList;
import java.util.Objects;

/////CRIANDO CLASSE//////
public class Padaria extends Estabelecimento{
    private String horarioFunc;
    ArrayList<Receita> receita = new ArrayList<>();

    //////CRIANDO CONSTRUTOR//////
    public Padaria(
        int idEstabelecimento,
        String nome,
        String dtAbertura,
        String horarioFunc,
        int idLocal,
        String cep,
        String rua,
        String numero,
        String bairro,
        String cidade

    ) {
        super(idEstabelecimento, nome, dtAbertura, idLocal, cep, rua, numero, bairro, cidade);
        this.horarioFunc = horarioFunc;
    }

    /////////METODOS SET, GET E ADICIONANDO RECEITA//////////
    public void setReceita(Receita receita) {
        this.receita.add(receita);
    }

    public void adicionarReceita(Receita receita) {
        this.receita.add(receita);
        receita.adicionarPadaria(this);
    }

    public ArrayList<Receita> getReceitas() {
        return this.receita;
    }

    public void setHorarioFunc(String horarioFunc) {
        this.horarioFunc = horarioFunc;
    }

    public String getHorarioFunc() {
        return this.horarioFunc;
    }

    //////COMPARAÇÃO DE VALORES/////
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Padaria)) {
            return false;
        }
        Padaria padaria = (Padaria) o;
        return Objects.equals(this.getIdEstabelecimento(), padaria.getIdEstabelecimento());
    }

    //////EXIBINDO DADOS DO CHEF////////
    @Override
    public String toString() {
        String retorno = 
            super.toString()
            +"\nHorário de estabelecimento =" + getHorarioFunc();

            for (Receita receita : this.receita) {

                retorno += "\n   " + receita.toString();

            }
        return retorno;
    }
}