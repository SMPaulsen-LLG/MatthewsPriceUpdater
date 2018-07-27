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
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stephen M. Paulsen <steve@lowinglight.com>
 */
public class Items {

    /* ********************************************************************** */
    /* STATIC FIELDS                                                          */
    /* ********************************************************************** */
    private static final char   TABCHAR                     = '\t';
    private static final char   QUOTECHAR                   = '\0';

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

    private FileReader              itemsFile;
    private CSVReader               cr;
    private String[]                sourceLine;

    private Item                    tempItem;
    private TreeMap<String, Item>   treeItems;


    /* ********************************************************************** */
    /* INSTANCE INITIALIZERS                                                  */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* CONSTRUCTORS                                                           */
    /* ********************************************************************** */
    public Items(String filename, String targetVendor) {

        treeItems = new TreeMap<>();

        try {
            this.itemsFile  = new FileReader(filename);
            this.cr         = new CSVReader(this.itemsFile, TABCHAR, QUOTECHAR);

            if (checkHeader()) {

                while(readLine()) {
                    tempItem = new Item(sourceLine);
                    if (tempItem.getIsValid()) {
                        if ((!targetVendor.isEmpty()) && (targetVendor.equals(tempItem.getPrimaryVendor()))) {
                            treeItems.put(tempItem.getVendorItemNumber(), tempItem);
                        } else {
                        }
                    } else {
                    }
                }

                System.out.println("*** Items Export Record Count: " + this.lineCount);
                System.out.println("*** Size of treeItems: "+ treeItems.size());

            } else {
            }

            closeMe();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* ********************************************************************** */
    /* METHODS                                                                */
    /* ********************************************************************** */

                                            /* ********** GET ITEM ********** */
    public Item getItem(String itemNumber) {
        Item retval = null;

        if(this.treeItems.containsKey(itemNumber)) {
            retval = this.treeItems.get(itemNumber);
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
        Item    hdr;

        if (readLine()) {
            hdr = new Item(this.sourceLine, hdrCheck);
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
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
            retval = FALSE;
        }

        return retval;

    }

                                            /* ********** CLOSE ME ********** */
    private void closeMe() {
        try {
            this.cr.close();
            this.itemsFile.close();
        } catch (IOException ex) {
            Logger.getLogger(Items.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
