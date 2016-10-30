package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Calendar;
import java.util.List;


/**
 * The persistent class for the LOCACAO database table.
 * 
 */
@Entity
@NamedQuery(name="Locacao.findAll", query="SELECT l FROM Locacao l")
public class Locacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private int codigo;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_CANCELADO")
	private Calendar dtCancelado;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_DEVOLVIDO")
	private Calendar dtDevolvido;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_LOCACAO")
	private Calendar dtLocacao;

	@Temporal(TemporalType.DATE)
	@Column(name="DT_PREVISTA")
	private Calendar dtPrevista;

	private Double valor;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="COD_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to LocacaoProd
	@OneToMany(mappedBy="locacao")
	private List<LocacaoProd> locacaoProds;

	public Locacao() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDtCancelado() {
		return this.dtCancelado;
	}

	public void setDtCancelado(Calendar dtCancelado) {
		this.dtCancelado = dtCancelado;
	}

	public Calendar getDtDevolvido() {
		return this.dtDevolvido;
	}

	public void setDtDevolvido(Calendar dtDevolvido) {
		this.dtDevolvido = dtDevolvido;
	}

	public Calendar getDtLocacao() {
		return this.dtLocacao;
	}

	public void setDtLocacao(Calendar dtLocacao) {
		this.dtLocacao = dtLocacao;
	}

	public Calendar getDtPrevista() {
		return this.dtPrevista;
	}

	public void setDtPrevista(Calendar dtPrevista) {
		this.dtPrevista = dtPrevista;
	}

	public Double getValor() {
		return this.valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<LocacaoProd> getLocacaoProds() {
		return this.locacaoProds;
	}

	public void setLocacaoProds(List<LocacaoProd> locacaoProds) {
		this.locacaoProds = locacaoProds;
	}

	public LocacaoProd addLocacaoProd(LocacaoProd locacaoProd) {
		getLocacaoProds().add(locacaoProd);
		locacaoProd.setLocacao(this);

		return locacaoProd;
	}

	public LocacaoProd removeLocacaoProd(LocacaoProd locacaoProd) {
		getLocacaoProds().remove(locacaoProd);
		locacaoProd.setLocacao(null);

		return locacaoProd;
	}

}