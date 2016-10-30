package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the LOCACAO_PROD database table.
 * 
 */
@Entity
@Table(name="LOCACAO_PROD")
@NamedQuery(name="LocacaoProd.findAll", query="SELECT l FROM LocacaoProd l")
public class LocacaoProd implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private int codigo;

	//bi-directional many-to-one association to Locacao
	@ManyToOne
	@JoinColumn(name="COD_LOCACAO")
	private Locacao locacao;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="COD_PRODUTO")
	private Produto produto;

	public LocacaoProd() {
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Locacao getLocacao() {
		return this.locacao;
	}

	public void setLocacao(Locacao locacao) {
		this.locacao = locacao;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}