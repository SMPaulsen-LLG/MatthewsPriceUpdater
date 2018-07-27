/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matthewspriceupdater;

import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stephen M. Paulsen <steve@lowinglight.com>
 */
public class MatthewsPriceUpdater {

    private static final String     ITEMS_EXPORT    = "/Users/spaulsen/Documents/Items Export.txt";
    private static final String     PRICES_EXPORT   = "/Users/spaulsen/Documents/2018 VOLUME 44  2018-2019 PRICE LIST  3-26.csv";
    private static final String     TARGET_VENDOR   = "Matthews Studio Equipment";
    private static final String     ITEMS_UPDATE    = "/Users/spaulsen/Documents/Items Update.txt";

    private static Items            myItems;
    private static Item             workingItem;

    private static Prices           myPrices;
    private static Price            workingPrice;

    private static int              countPrices = 0;
    private static int              countItems  = 0;
    private static int              countUpdate = 0;

    // private final File              fileUpdate;
    private        FileWriter       fw;
    private static CSVWriter        cw;

    private static final char       TABCHAR     = '\t';
    private static final char       QUOTECHAR   = '\0';

    private static final String[]   UPDATE_HEADERS  = {
        "recno",
        "Item Number",
        "Item Name",
        "Buy",
        "Sell",
        "Income Acct",
        "Expense/COS Acct",
        "Custom Field 3",
        "Primary Vendor",
        "Vendor Item Number",
        "Buy Unit Measure",
        "Selling Price",
        "Sell Unit Measure",
        "Tax When Sold",
        "Quantity Break 1",
        "Price Level A, Qty Break 1",
        "Price Level B, Qty Break 1",
        "Standard Cost",
        "Web Store Price",
        "Description"
    } ;

    private static String[]         updateRecord = new String[20];

    private static final String     TIMESTAMP = new SimpleDateFormat("yyyy-MMM-dd HH:mm").format(new Date());


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        myItems     = new Items(ITEMS_EXPORT, TARGET_VENDOR);
        myPrices    = new Prices(PRICES_EXPORT);

        try {
            cw      = new CSVWriter(new FileWriter(ITEMS_UPDATE), TABCHAR, QUOTECHAR);
            cw.writeNext(UPDATE_HEADERS);
            countUpdate++;

        } catch (IOException ex) {
            Logger.getLogger(MatthewsPriceUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }

        myPrices.setIterator();
        workingPrice    = myPrices.getNext();

        while (workingPrice != null) {
            countPrices++;
            System.out.printf("%5d Item: %15s\n", countPrices, workingPrice.getItemNumber());

            workingItem = myItems.getItem(workingPrice.getItemNumber());

            if (workingItem == null) {
                System.out.println("--- New Item");
                workingItem = new Item();
                workingItem.setItemNumber("MAT NEW " + workingPrice.getItemNumber().trim());
                workingItem.setItemName(workingPrice.getDescription().trim());
                // workingItem.setSellingPrice(workingPrice.getListPrice().toString());
            } else {
                System.out.println("--- Update");
            }

            updateRecord[0]     = String.valueOf(countPrices);                  //  0 recno
            updateRecord[1]     = workingItem.getItemNumber();                  //  1 Item Number
            updateRecord[2]     = workingItem.getItemName();                    //  2 Item Name
            updateRecord[3]     = "B";                                          //  3 Buy
            updateRecord[4]     = "S";                                          //  4 Sell
            updateRecord[5]     = "4-5265";                                     //  5 Income Acct
            updateRecord[6]     = "5-5265";                                     //  6 Expense/COS Acct
            updateRecord[7]     = TIMESTAMP;                                    //  7 Custom Field 3
            updateRecord[8]     = TARGET_VENDOR;                                //  8 Primary Vendor
            updateRecord[9]     = workingPrice.getItemNumber().trim();          //  9 Vendor Item Number
            updateRecord[10]    = "Each";                                       // 10 Buy Unit Measure
            updateRecord[11]    = workingPrice.getListPrice().toString();       // 11 Selling Price
            updateRecord[12]    = "Each";                                       // 12 Sell Unit Measure
            updateRecord[13]    = "Y";                                          // 13 Tax When Sold
            updateRecord[14]    = "0";                                          // 14 Quantity Break 1
            updateRecord[15]    = workingPrice.getListPrice().toString();       // 15 Price Level A, Qty Break 1
            updateRecord[16]    = workingPrice.getSalePrice().toString();       // 16 Price Level B, Qty Break 1
            updateRecord[17]    = workingPrice.getStandardCost().toString();    // 17 Standard Cost
            updateRecord[18]    = workingPrice.getListPrice().toString();       // 18 Web Store Price

            if (workingPrice.getComments().length() > 0) {
                updateRecord[19]    = workingItem.getDescription().concat(" *** VENDOR NOTES: ").concat(workingPrice.getComments());
            } else {
                updateRecord[19]    = "";
            }

            cw.writeNext(updateRecord);

            workingPrice = myPrices.getNext();
        }

        try {
            cw.flush();
            cw.close();
        } catch (IOException ex) {
            Logger.getLogger(MatthewsPriceUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
