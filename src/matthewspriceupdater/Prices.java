/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package matthewspriceupdater;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stephen M. Paulsen <steve@lowinglight.com>
 */
public class Prices {

    /* ********************************************************************** */
    /* STATIC FIELDS                                                          */
    /* ********************************************************************** */
    private static final char   COMMACHAR                   = ',';
    private static final char   TABCHAR                     = '\t';
    private static final char   QUOTECHAR                   = '"';
    private static final char   NULLCHAR                    = '\0';

    /* ********************************************************************** */
    /* STATIC INITIALIZERS                                                    */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* STATIC METHODS                                                         */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* FIELDS                                                                 */
    /* ********************************************************************** */
    private Boolean                 EOF         = FALSE;
    private int                     lineCount   = 0;

    private FileReader              pricesFile;
    private CSVReader               cr;
    private String[]                sourceLine;

    private Price                   tempPrice;
    private TreeMap<String, Price>  treePrices;

    private Set                     setPrices;
    private Iterator                iterator;
    private Map.Entry               mEntry;


    /* ********************************************************************** */
    /* INSTANCE INITIALIZERS                                                  */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* CONSTRUCTORS                                                           */
    /* ********************************************************************** */
    public Prices(String filename) {

        treePrices = new TreeMap<>();

        try {
            this.pricesFile  = new FileReader(filename);
            this.cr          = new CSVReader(this.pricesFile, COMMACHAR, QUOTECHAR);

            if (checkHeader()) {

                while(readLine()) {
                    tempPrice = new Price(sourceLine);
                    if (tempPrice.getIsValid()) {
                        treePrices.put(tempPrice.getItemNumber(), tempPrice);
                    } else {
                        System.out.println("--- Invalid? " + tempPrice.getItemNumber());
                    }
                }

                System.out.println("*** Prices Export Record Count: " + this.lineCount);
                System.out.println("*** Size of treePrices: "+ treePrices.size());

            } else {
            }

            closeMe();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Prices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* ********************************************************************** */
    /* METHODS                                                                */
    /* ********************************************************************** */

                                        /* ********** SET ITERATOR ********** */

    public void setIterator() {

        setPrices = treePrices.entrySet();
        iterator  = setPrices.iterator();
    }

                                            /* ********** GET NEXT ********** */
    public Price getNext() {
        Price retval = null;

        if (this.iterator.hasNext()) {
            this.mEntry = (Map.Entry)this.iterator.next();
            retval = (Price)this.mEntry.getValue();
        }

        return retval;
    }


    /* ********************************************************************** */
    /* STATIC CLASSES                                                         */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* INTERNALS                                                              */
    /* ********************************************************************** */

                                        /* ********** CHECK HEADER ********** */
    private Boolean checkHeader() {
        Boolean retval;
        Boolean hdrCheck    = TRUE;
        Price   hdr;

        if (readLine()) {
            hdr = new Price(this.sourceLine, hdrCheck);
            if (hdr.getIsValid()) {
                retval = TRUE;
            } else {
                retval = FALSE;
            }
        } else {
            retval = FALSE;
        }

        return retval;

    }

                                            /* ********** READLINE ********** */
    private Boolean readLine() {
        Boolean retval = TRUE;

        try {
            if ((this.sourceLine = this.cr.readNext()) != null ) {
                this.lineCount++;
            } else {
                this.EOF    = TRUE;
                retval      = FALSE;
            }
        } catch (IOException ex) {
            Logger.getLogger(Prices.class.getName()).log(Level.SEVERE, null, ex);
            retval = FALSE;
        }

        return retval;

    }


                                            /* ********** CLOSE ME ********** */
    private void closeMe() {
        try {
            this.cr.close();
            this.pricesFile.close();
        } catch (IOException ex) {
            Logger.getLogger(Prices.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
