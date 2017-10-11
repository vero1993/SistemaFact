/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;
import java.util.ArrayList;;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;


public class AdaptadorDao<T> implements InterfazDao<T>{
    private Class<T> clazz;
    private EntityManager entityManager;
    
    public AdaptadorDao(Class<T> clazz, EntityManager entityManager)
    {
        this.clazz = clazz;
        this.entityManager = entityManager;
    }
    @Override
    public T obtener(Long id)
    {
        return entityManager.find(clazz, id);
    }
    
    @Override
    public List<T> listar() {//lista todos los elementos dr una tabla de nuestra bd
        List lista = new ArrayList();
        try {
            Query q = entityManager.createQuery("select t from " + clazz.getName() + " t");
            lista = q.getResultList();
        } catch (Exception e) {
        }
        return lista;
    }
    
    @Override
    public long contarTodos()
    {
        long aux = 0;
        try {
            Query q = entityManager.createNamedQuery(" select t from " + clazz.getName() + " t");
            aux = q.getResultList().size();
        } catch (Exception e) {
        }
        return aux;
    }
    
    @Override
    public void guardar(T obj)
    {
        entityManager.persist(obj);
    }
    
    @Override
    public void modificar(T obj)//modifica objetos de nuestra bd
    {
        entityManager.merge(obj);
    }
    
    @Override
    public void eliminar(T obj)
    {
        entityManager.remove(obj);
    }

    //Crear solo el getter
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}
