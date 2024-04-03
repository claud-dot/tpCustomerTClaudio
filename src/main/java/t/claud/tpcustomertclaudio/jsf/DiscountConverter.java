/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t.claud.tpcustomertclaudio.jsf;

import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;
import jakarta.inject.Inject;
import t.claud.tpcustomertclaudio.entity.Discount;
import t.claud.tpcustomertclaudio.service.DiscountManager;

/**
 *
 * @author PC
 */
@FacesConverter(value = "discountConverter", managed = true)
public class DiscountConverter implements Converter<Discount> {

    @Inject
    private DiscountManager discountManager;

    /**
     * Convertit une String en Discount.
     *
     * @param value valeur à convertir
     */
    @Override
    public Discount getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value == null) return null;
        return discountManager.findById(value);
    }

    /**
     * Convertit un Discount en String.
     *
     * @param value valeur à convertir
     */
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Discount discount) {
        if (discount == null) return "";
        return discount.getCode();
    }
}
