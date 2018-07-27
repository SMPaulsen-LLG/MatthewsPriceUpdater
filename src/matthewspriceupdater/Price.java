/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matthewspriceupdater;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.math.BigDecimal;

/**
 *
 * @author Stephen M. Paulsen <steve@lowinglight.com>
 */
public class Price {

    /* ********************************************************************** */
    /* STATIC FIELDS                                                          */
    /* ********************************************************************** */

private static final String[] ITEM_COLUMN_HEADERS            = {
        "PAGE #",
        "Item #",
        "Description",
        "List Price",
        "Comments"
    };

    /* ********************************************************************** */
    /* STATIC INITIALIZERS                                                    */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* STATIC METHODS                                                         */
    /* ********************************************************************** */
    private static BigDecimal stripCurrency(String s) {

        if (s.trim().length() == 0) {
            return BigDecimal.ZERO;
        } else {
            return new BigDecimal(s.replace("$", "").replace(",", "").trim());
        }

    }

    private static int testInt(String s) {
        if (s.length() == 0) {
            return 0;
        } else {
            return Integer.parseInt(s);
        }
    }

    /* ********************************************************************** */
    /* FIELDS                                                                 */
    /* ********************************************************************** */

    private int         pageNumber              = 0;
    private String      itemNumber              = "";
    private String      description             = "";
    private BigDecimal  listPrice               = new BigDecimal(0);
    private String      comments                = "";

    private Boolean     isValid                 = TRUE;

    /* ********************************************************************** */
    /* INSTANCE INITIALIZERS                                                  */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* CONSTRUCTORS                                                           */
    /* ********************************************************************** */
    public Price(String[] arrString, Boolean hdrCheck) {

        for (int i = 0; i < ITEM_COLUMN_HEADERS.length; i++) {
            if (arrString[i].trim().equals(ITEM_COLUMN_HEADERS[i])) {

            } else {
                this.isValid = FALSE;
            }
        }
    }

    public Price (String[] arrString) {

        setPageNumber(arrString[0]);
        setItemNumber(arrString[1]);
        setDescription(arrString[2]);
        setListPrice(arrString[3]);
        setComments(arrString[4]);


    }

    /* ********************************************************************** */
    /* METHODS                                                                */
    /* ********************************************************************** */

                                             /* ********** SETTERS ********** */
    public void setPageNumber(String s) {
        this.pageNumber             = testInt(s);
    }

    public void setItemNumber(String s) {
        this.itemNumber             = s;
    }

    public void setDescription(String s) {
        this.description            = s;
    }

    public void setListPrice(String s) {
        this.listPrice              = stripCurrency(s);
    }

    public void setComments(String s){
        this.comments               = s;
    }


                                             /* ********** GETTERS ********** */
    public int getPageNumber()                  { return this.pageNumber; }
    public String getItemNumber()               { return this.itemNumber; }
    public String getDescription()              { return this.description; }
    public BigDecimal getListPrice()            { return this.listPrice; }
    public String getComments()                 { return this.comments; }

    public BigDecimal getStandardCost() {
        BigDecimal retval     = BigDecimal.ZERO;
        BigDecimal discFactor = new BigDecimal(0.60);

        /* ********** Special Cases ********** */

        if (this.comments.length() == 0) {
            discFactor  = BigDecimal.valueOf(0.60);

        } else {
            if (this.comments.contains("00%")) {
                discFactor  = BigDecimal.valueOf(1.00);

            } else if (this.comments.contains("20%")) {
                discFactor  = BigDecimal.valueOf(0.80);

            } else if (this.comments.contains("30%")) {
                discFactor  = BigDecimal.valueOf(0.70);

            } else if (this.comments.contains("35%")) {
                discFactor  = BigDecimal.valueOf(0.65);

            } else if (this.comments.contains("50%")) {
                discFactor  = BigDecimal.valueOf(0.50);

            } else if (this.comments.contains("Minimum order of 100 pcs. required ")) {
                discFactor  = BigDecimal.valueOf(1.00);

            } else if (this.comments.contains("No allowable discount")) {
                discFactor  = BigDecimal.valueOf(1.00);
            }
        }


        retval = this.listPrice.multiply(discFactor).setScale(0, BigDecimal.ROUND_UP);

        return retval;
    }

    public BigDecimal getSalePrice() {
        BigDecimal retval  = BigDecimal.ZERO;
        BigDecimal stdCost = getStandardCost();
        BigDecimal markup  = BigDecimal.valueOf(1.33);
        BigDecimal trial   = stdCost.multiply(markup);

        if (trial.compareTo(this.listPrice) == -1) {
            retval = trial.setScale(0, BigDecimal.ROUND_UP);
        } else {
            retval = this.listPrice;
        }

        return retval;
    }

    public Boolean getIsValid()                 { return this.isValid; }


    /* ********************************************************************** */
    /* STATIC CLASSES                                                         */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* CLASSES                                                                */
    /* ********************************************************************** */

}
