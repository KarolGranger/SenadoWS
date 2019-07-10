/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.exceptions.NonexistentEntityException;
import controller.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;
import persistencia.Auxilioimoveis;

/**
 *
 * @author rafae
 */
public class AuxilioimoveisJpaController implements Serializable {

    public AuxilioimoveisJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Auxilioimoveis auxilioimoveis) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(auxilioimoveis);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Auxilioimoveis auxilioimoveis) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            auxilioimoveis = em.merge(auxilioimoveis);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = auxilioimoveis.getCodAuxilio();
                if (findAuxilioimoveis(id) == null) {
                    throw new NonexistentEntityException("The auxilioimoveis with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Auxilioimoveis auxilioimoveis;
            try {
                auxilioimoveis = em.getReference(Auxilioimoveis.class, id);
                auxilioimoveis.getCodAuxilio();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The auxilioimoveis with id " + id + " no longer exists.", enfe);
            }
            em.remove(auxilioimoveis);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Auxilioimoveis> findAuxilioimoveisEntities() {
        return findAuxilioimoveisEntities(true, -1, -1);
    }

    public List<Auxilioimoveis> findAuxilioimoveisEntities(int maxResults, int firstResult) {
        return findAuxilioimoveisEntities(false, maxResults, firstResult);
    }

    private List<Auxilioimoveis> findAuxilioimoveisEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Auxilioimoveis.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Auxilioimoveis findAuxilioimoveis(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Auxilioimoveis.class, id);
        } finally {
            em.close();
        }
    }

    public int getAuxilioimoveisCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Auxilioimoveis> rt = cq.from(Auxilioimoveis.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
