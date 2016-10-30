package EJB;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Produto;

/**
 * Session Bean implementation class GeneralRegister
 */
@Stateless
@LocalBean
public class RegisterProduto {
	
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public RegisterProduto() {
		// TODO Auto-generated constructor stub
	}

	public Produto createSampleProduto() {

		Produto produto = new Produto();

		produto.setTitulo("<TITULO>");

		produto = em.merge(produto);

		return produto;
	}

	public void remove(Produto Produto) {
		em.remove(em.merge(Produto));
	}

	public Produto findOrUpdate(Produto Produto) {
		
		Produto result = em.merge(Produto);

		return result;
	}
	
    @SuppressWarnings("unchecked")
	public List<Produto> listProdutos() {
    	Query query = em.createNamedQuery("Produto.findAll");
    	
    	return query.getResultList();
    }
    
    public Produto findProdutoByID(long id) {
    	return em.find(Produto.class, id);
    }
    
    public Produto findProdutoByName(String nomeProd) {
    	Query query = em.createQuery("SELECT c FROM Produto c WHERE c.titulo = :titulo");
    	query.setParameter("titulo", nomeProd);
    	
    	return (Produto) query.getSingleResult();
    }

}
