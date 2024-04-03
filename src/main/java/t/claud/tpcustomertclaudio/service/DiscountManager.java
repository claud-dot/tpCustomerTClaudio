/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t.claud.tpcustomertclaudio.service;

import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import t.claud.tpcustomertclaudio.entity.Discount;

/**
 * Façade pour gérer les discount.
 *
 * @author PC
 */
@RequestScoped
public class DiscountManager {

    @PersistenceContext(unitName = "customerPU")
    private EntityManager em;

    public Discount findById(String code) {
        return em.find(Discount.class, code);
    }

    /**
     * Retourne la liste de tous les Discount.
     */
    public List<Discount> getAllDiscounts() {
        Query query = em.createNamedQuery("Discount.findAll");
        return query.getResultList();
    }

    public List<Discount> getAllDiscountsDesc() {
        Query query = em.createNamedQuery("Discount.findAllOrderAsc");
        return query.getResultList();
    }

}
