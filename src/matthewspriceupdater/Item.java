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
public class Item {

    /* ********************************************************************** */
    /* STATIC FIELDS                                                          */
    /* ********************************************************************** */

private static final String[] ITEM_COLUMN_HEADERS            = {
        "Item Number",
        "Item Name",
        "Buy",
        "Sell",
        "Inventory",
        "Asset Acct",
        "Income Acct",
        "Expense/COS Acct",
        "Item Picture",
        "Description",
        "Use Desc. On Sale",
        "Custom List 1",
        "Custom List 2",
        "Custom List 3",
        "Custom Field 1",
        "Custom Field 2",
        "Custom Field 3",
        "Primary Vendor",
        "Vendor Item Number",
        "Tax When Bought",
        "Buy Unit Measure",
        "# Items/Buy Unit",
        "Reorder Quantity",
        "Minimum Level",
        "Selling Price",
        "Sell Unit Measure",
        "Tax When Sold",
        "# Items/Sell Unit",
        "Quantity Break 1",
        "Quantity Break 2",
        "Quantity Break 3",
        "Quantity Break 4",
        "Quantity Break 5",
        "Price Level A, Qty Break 1",
        "Price Level B, Qty Break 1",
        "Price Level C, Qty Break 1",
        "Price Level D, Qty Break 1",
        "Price Level E, Qty Break 1",
        "Price Level F, Qty Break 1",
        "Price Level A, Qty Break 2",
        "Price Level B, Qty Break 2",
        "Price Level C, Qty Break 2",
        "Price Level D, Qty Break 2",
        "Price Level E, Qty Break 2",
        "Price Level F, Qty Break 2",
        "Price Level A, Qty Break 3",
        "Price Level B, Qty Break 3",
        "Price Level C, Qty Break 3",
        "Price Level D, Qty Break 3",
        "Price Level E, Qty Break 3",
        "Price Level F, Qty Break 3",
        "Price Level A, Qty Break 4",
        "Price Level B, Qty Break 4",
        "Price Level C, Qty Break 4",
        "Price Level D, Qty Break 4",
        "Price Level E, Qty Break 4",
        "Price Level F, Qty Break 4",
        "Price Level A, Qty Break 5",
        "Price Level B, Qty Break 5",
        "Price Level C, Qty Break 5",
        "Price Level D, Qty Break 5",
        "Price Level E, Qty Break 5",
        "Price Level F, Qty Break 5",
        "Inactive Item",
        "Standard Cost",
        "Default Ship/Sell Location",
        "Default Recvd/Auto Location",
        "Brand",
        "Weight",
        "Unit of Weight",
        "Web Description",
        "Sold in Web Store",
        "Web Store Price",
        "Item Record ID",
        "Track Serial Number",
        "Warranty Applies when Sold",
        "Warranty Period",
        "Unit of Warranty Period",
        "Kit Item"
    };

    /* ********************************************************************** */
    /* STATIC INITIALIZERS                                                    */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* STATIC METHODS                                                         */
    /* ********************************************************************** */
    private static BigDecimal stripCurrency(String s) {

        if (s.length() == 0) {
            return BigDecimal.ZERO;
        } else {
            return new BigDecimal(s.replace("$", "").replace(",", ""));
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

    private String      itemNumber              = "";
    private String      itemName                = "";
    private Boolean     buy                     = FALSE;
    private Boolean     sell                    = FALSE;
    private Boolean     inventory               = FALSE;
    private String      assetAcct               = "";
    private String      incomeAcct              = "";
    private String      expenseAcct             = "";
    private String      itemPicture             = "";
    private String      description             = "";
    private Boolean     useDescOnSale           = FALSE;
    private String      customList1             = "";
    private String      customList2             = "";
    private String      customList3             = "";
    private String      customField1            = "";
    private String      customField2            = "";
    private String      customField3            = "";
    private String      primaryVendor           = "";
    private String      vendorItemNumber        = "";
    private Boolean     taxWhenBought           = FALSE;
    private String      buyUnitMeasure          = "";
    private BigDecimal  numItemsperBuyUnit      = new BigDecimal(0);
    private BigDecimal  reorderQuantity         = new BigDecimal(0);
    private BigDecimal  minimumLevel            = new BigDecimal(0);
    private BigDecimal  sellingPrice            = new BigDecimal(0);
    private String      sellUnitMeasure         = "";
    private Boolean     taxWhenSold             = FALSE;
    private BigDecimal  numItemsPerSellUnit     = new BigDecimal(0);

    private BigDecimal  quantityBreak1          = new BigDecimal(0);
    private BigDecimal  quantityBreak2          = new BigDecimal(0);
    private BigDecimal  quantityBreak3          = new BigDecimal(0);
    private BigDecimal  quantityBreak4          = new BigDecimal(0);
    private BigDecimal  quantityBreak5          = new BigDecimal(0);

    private BigDecimal  priceLevelAQtyBreak1    = new BigDecimal(0);
    private BigDecimal  priceLevelBQtyBreak1    = new BigDecimal(0);
    private BigDecimal  priceLevelCQtyBreak1    = new BigDecimal(0);
    private BigDecimal  priceLevelDQtyBreak1    = new BigDecimal(0);
    private BigDecimal  priceLevelEQtyBreak1    = new BigDecimal(0);
    private BigDecimal  priceLevelFQtyBreak1    = new BigDecimal(0);

    private BigDecimal  priceLevelAQtyBreak2    = new BigDecimal(0);
    private BigDecimal  priceLevelBQtyBreak2    = new BigDecimal(0);
    private BigDecimal  priceLevelCQtyBreak2    = new BigDecimal(0);
    private BigDecimal  priceLevelDQtyBreak2    = new BigDecimal(0);
    private BigDecimal  priceLevelEQtyBreak2    = new BigDecimal(0);
    private BigDecimal  priceLevelFQtyBreak2    = new BigDecimal(0);

    private BigDecimal  priceLevelAQtyBreak3    = new BigDecimal(0);
    private BigDecimal  priceLevelBQtyBreak3    = new BigDecimal(0);
    private BigDecimal  priceLevelCQtyBreak3    = new BigDecimal(0);
    private BigDecimal  priceLevelDQtyBreak3    = new BigDecimal(0);
    private BigDecimal  priceLevelEQtyBreak3    = new BigDecimal(0);
    private BigDecimal  priceLevelFQtyBreak3    = new BigDecimal(0);

    private BigDecimal  priceLevelAQtyBreak4    = new BigDecimal(0);
    private BigDecimal  priceLevelBQtyBreak4    = new BigDecimal(0);
    private BigDecimal  priceLevelCQtyBreak4    = new BigDecimal(0);
    private BigDecimal  priceLevelDQtyBreak4    = new BigDecimal(0);
    private BigDecimal  priceLevelEQtyBreak4    = new BigDecimal(0);
    private BigDecimal  priceLevelFQtyBreak4    = new BigDecimal(0);

    private BigDecimal  priceLevelAQtyBreak5    = new BigDecimal(0);
    private BigDecimal  priceLevelBQtyBreak5    = new BigDecimal(0);
    private BigDecimal  priceLevelCQtyBreak5    = new BigDecimal(0);
    private BigDecimal  priceLevelDQtyBreak5    = new BigDecimal(0);
    private BigDecimal  priceLevelEQtyBreak5    = new BigDecimal(0);
    private BigDecimal  priceLevelFQtyBreak5    = new BigDecimal(0);

    private Boolean     inactiveItem            = FALSE;
    private BigDecimal  standardCost            = new BigDecimal(0);
    private String      defaultSellLocation     = "";
    private String      defaultRecvdLocation    = "";
    private String      brand                   = "";
    private BigDecimal  weight                  = new BigDecimal(0);
    private String      unitOfWeight            = "";
    private String      webDescription          = "";
    private Boolean     soldInWebStore          = FALSE;
    private BigDecimal  webStorePrice           = new BigDecimal(0);
    private int         itemRecordID            = 0;
    private Boolean     trackSerialNumber       = FALSE;
    private Boolean     warrantyAppliesWhenSold = FALSE;
    private int         warrantyPeriod          = 0;
    private String      unitOfWarrantyPeriod    = "";
    private Boolean     kitItem                 = FALSE;

    private Boolean     isValid                 = TRUE;

    /* ********************************************************************** */
    /* INSTANCE INITIALIZERS                                                  */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* CONSTRUCTORS                                                           */
    /* ********************************************************************** */
    public Item(String[] arrString, Boolean hdrCheck) {

        for (int i = 0; i < ITEM_COLUMN_HEADERS.length; i++) {
            if (arrString[i].equals(ITEM_COLUMN_HEADERS[i])) {

            } else {
                this.isValid = FALSE;
            }
        }
    }

    public Item (String[] arrString) {

        setItemNumber(arrString[0]);
        setItemName(arrString[1]);
        setBuy(arrString[2]);
        setSell(arrString[3]);
        setInventory(arrString[4]);
        setAssetAcct(arrString[5]);
        setIncomeAcct(arrString[6]);
        setExpenseAcct(arrString[7]);
        setItemPicture(arrString[8]);
        setDescription(arrString[9]);
        setUseDescOnSale(arrString[10]);
        setCustomList1(arrString[11]);
        setCustomList2(arrString[12]);
        setCustomList3(arrString[13]);
        setCustomField1(arrString[14]);
        setCustomField2(arrString[15]);
        setCustomField3(arrString[16]);
        setPrimaryVendor(arrString[17]);
        setVendorItemNumber(arrString[18]);
        setTaxWhenBought(arrString[19]);
        setBuyUnitMeasure(arrString[20]);
        setNumItemsperBuyUnit(arrString[21]);
        setReorderQuantity(arrString[22]);
        setMinimumLevel(arrString[23]);
        setSellingPrice(arrString[24]);
        setSellUnitMeasure(arrString[25]);
        setTaxWhenSold(arrString[26]);
        setNumItemsPerSellUnit(arrString[27]);
        setQuantityBreak1(arrString[28]);
        setQuantityBreak2(arrString[29]);
        setQuantityBreak3(arrString[30]);
        setQuantityBreak4(arrString[31]);
        setQuantityBreak5(arrString[32]);
        setPriceLevelAQtyBreak1(arrString[33]);
        setPriceLevelBQtyBreak1(arrString[34]);
        setPriceLevelCQtyBreak1(arrString[35]);
        setPriceLevelDQtyBreak1(arrString[36]);
        setPriceLevelEQtyBreak1(arrString[37]);
        setPriceLevelFQtyBreak1(arrString[38]);
        setPriceLevelAQtyBreak2(arrString[39]);
        setPriceLevelBQtyBreak2(arrString[40]);
        setPriceLevelCQtyBreak2(arrString[41]);
        setPriceLevelDQtyBreak2(arrString[42]);
        setPriceLevelEQtyBreak2(arrString[43]);
        setPriceLevelFQtyBreak2(arrString[44]);
        setPriceLevelAQtyBreak3(arrString[45]);
        setPriceLevelBQtyBreak3(arrString[46]);
        setPriceLevelCQtyBreak3(arrString[47]);
        setPriceLevelDQtyBreak3(arrString[48]);
        setPriceLevelEQtyBreak3(arrString[49]);
        setPriceLevelFQtyBreak3(arrString[50]);
        setPriceLevelAQtyBreak4(arrString[51]);
        setPriceLevelBQtyBreak4(arrString[52]);
        setPriceLevelCQtyBreak4(arrString[53]);
        setPriceLevelDQtyBreak4(arrString[54]);
        setPriceLevelEQtyBreak4(arrString[55]);
        setPriceLevelFQtyBreak4(arrString[56]);
        setPriceLevelAQtyBreak5(arrString[57]);
        setPriceLevelBQtyBreak5(arrString[58]);
        setPriceLevelCQtyBreak5(arrString[59]);
        setPriceLevelDQtyBreak5(arrString[60]);
        setPriceLevelEQtyBreak5(arrString[61]);
        setPriceLevelFQtyBreak5(arrString[62]);
        setInactiveItem(arrString[63]);
        setStandardCost(arrString[64]);
        setDefaultSellLocation(arrString[65]);
        setDefaultRecvdLocation(arrString[66]);
        setBrand(arrString[67]);
        setWeight(arrString[68]);
        setUnitOfWeight(arrString[69]);
        setWebDescription(arrString[70]);
        setSoldInWebStore(arrString[71]);
        setWebStorePrice(arrString[72]);
        setItemRecordID(arrString[73]);
        setTrackSerialNumber(arrString[74]);
        setWarrantyAppliesWhenSold(arrString[75]);
        setWarrantyPeriod(arrString[76]);
        setUnitOfWarrantyPeriod(arrString[77]);
        setKitItem(arrString[78]);

    }

    public Item() {

    }

    /* ********************************************************************** */
    /* METHODS                                                                */
    /* ********************************************************************** */

                                             /* ********** SETTERS ********** */
    public void setItemNumber(String s) {
        this.itemNumber             = s;
    }

    public void setItemName(String s) {
        this.itemName               = s;
    }

    public void setBuy(String s) {
        this.buy                    = (s.equals("B"));
    }

    public void setSell(String s) {
        this.sell                   = (s.equals("S"));
    }

    public void setInventory(String s) {
        this.inventory              = (s.equals("I"));
    }

    public void setAssetAcct(String s) {
        this.assetAcct              = s;
    }

    public void setIncomeAcct(String s) {
        this.incomeAcct             = s;
    }

    public void setExpenseAcct(String s) {
        this.expenseAcct             = s;
    }

    public void setItemPicture(String s) {
        this.itemPicture            = s;
    }

    public void setDescription(String s) {
        this.description            = s;
    }

    public void setUseDescOnSale(String s) {
        this.useDescOnSale          = (s.equals("Y"));
    }

    public void setCustomList1(String s) {
        this.customList1            = s;
    }

    public void setCustomList2(String s) {
        this.customList2            = s;
    }

    public void setCustomList3(String s) {
        this.customList3            = s;
    }

    public void setCustomField1(String s) {
        this.customField1           = s;
    }

    public void setCustomField2(String s) {
        this.customField2           = s;
}

    public void setCustomField3(String s) {
        this.customField3           = s;
}

    public void setPrimaryVendor(String s) {
        this.primaryVendor          = s;
    }

    public void setVendorItemNumber(String s) {
        this.vendorItemNumber       = s;
    }

    public void setTaxWhenBought(String s) {
        this.taxWhenBought          = (s.trim().length() > 0);
    }

    public void setBuyUnitMeasure(String s) {
        this.buyUnitMeasure         = s;
    }

    public void setNumItemsperBuyUnit(String s) {
        this.numItemsperBuyUnit     = stripCurrency(s);
    }

    public void setReorderQuantity(String s) {
        this.reorderQuantity        = stripCurrency(s);
    }

    public void setMinimumLevel(String s) {
        this.minimumLevel           = stripCurrency(s);
    }

    public void setSellingPrice(String s) {
        this.sellingPrice           = stripCurrency(s);
    }

    public void setSellUnitMeasure(String s) {
        this.sellUnitMeasure        = s;
    }

    public void setTaxWhenSold(String s) {
        this.taxWhenSold            = (s.trim().length() > 0);
    }

    public void setNumItemsPerSellUnit(String s) {
        this.numItemsPerSellUnit    = stripCurrency(s);
    }

    public void setQuantityBreak1(String s) {
        this.quantityBreak1         = stripCurrency(s);
    }

    public void setQuantityBreak2(String s) {
        this.quantityBreak2         = stripCurrency(s);
    }

    public void setQuantityBreak3(String s) {
        this.quantityBreak3         = stripCurrency(s);
    }

    public void setQuantityBreak4(String s) {
        this.quantityBreak4         = stripCurrency(s);
    }

    public void setQuantityBreak5(String s) {
        this.quantityBreak5         = stripCurrency(s);
    }

    public void setPriceLevelAQtyBreak1(String s) {
        this.priceLevelAQtyBreak1   = stripCurrency(s);
    }

    public void setPriceLevelBQtyBreak1(String s) {
        this.priceLevelBQtyBreak1   = stripCurrency(s);
    }

    public void setPriceLevelCQtyBreak1(String s) {
        this.priceLevelCQtyBreak1   = stripCurrency(s);
    }

    public void setPriceLevelDQtyBreak1(String s) {
        this.priceLevelDQtyBreak1   = stripCurrency(s);
    }

    public void setPriceLevelEQtyBreak1(String s) {
        this.priceLevelEQtyBreak1   = stripCurrency(s);
    }

    public void setPriceLevelFQtyBreak1(String s) {
        this.priceLevelFQtyBreak1   = stripCurrency(s);
    }

    public void setPriceLevelAQtyBreak2(String s) {
        this.priceLevelAQtyBreak2   = stripCurrency(s);
    }

    public void setPriceLevelBQtyBreak2(String s) {
        this.priceLevelBQtyBreak2   = stripCurrency(s);
    }

    public void setPriceLevelCQtyBreak2(String s) {
        this.priceLevelCQtyBreak2   = stripCurrency(s);
    }

    public void setPriceLevelDQtyBreak2(String s) {
        this.priceLevelDQtyBreak2   = stripCurrency(s);
    }

    public void setPriceLevelEQtyBreak2(String s) {
        this.priceLevelEQtyBreak2   = stripCurrency(s);
    }

    public void setPriceLevelFQtyBreak2(String s) {
        this.priceLevelFQtyBreak2   = stripCurrency(s);
    }

    public void setPriceLevelAQtyBreak3(String s) {
        this.priceLevelAQtyBreak3   = stripCurrency(s);
    }

    public void setPriceLevelBQtyBreak3(String s) {
        this.priceLevelBQtyBreak3   = stripCurrency(s);
    }

    public void setPriceLevelCQtyBreak3(String s) {
        this.priceLevelCQtyBreak3   = stripCurrency(s);
    }

    public void setPriceLevelDQtyBreak3(String s) {
        this.priceLevelDQtyBreak3   = stripCurrency(s);
    }

    public void setPriceLevelEQtyBreak3(String s) {
        this.priceLevelEQtyBreak3   = stripCurrency(s);
    }

    public void setPriceLevelFQtyBreak3(String s) {
        this.priceLevelFQtyBreak3   = stripCurrency(s);
    }

    public void setPriceLevelAQtyBreak4(String s) {
        this.priceLevelAQtyBreak4   = stripCurrency(s);
    }

    public void setPriceLevelBQtyBreak4(String s) {
        this.priceLevelBQtyBreak4   = stripCurrency(s);
    }

    public void setPriceLevelCQtyBreak4(String s) {
        this.priceLevelCQtyBreak4   = stripCurrency(s);
    }

    public void setPriceLevelDQtyBreak4(String s) {
        this.priceLevelDQtyBreak4   = stripCurrency(s);
    }

    public void setPriceLevelEQtyBreak4(String s) {
        this.priceLevelEQtyBreak4   = stripCurrency(s);
    }

    public void setPriceLevelFQtyBreak4(String s) {
        this.priceLevelFQtyBreak4   = stripCurrency(s);
    }

    public void setPriceLevelAQtyBreak5(String s) {
        this.priceLevelAQtyBreak5   = stripCurrency(s);
    }

    public void setPriceLevelBQtyBreak5(String s) {
        this.priceLevelBQtyBreak5   = stripCurrency(s);
    }

    public void setPriceLevelCQtyBreak5(String s) {
        this.priceLevelCQtyBreak5   = stripCurrency(s);
    }

    public void setPriceLevelDQtyBreak5(String s) {
        this.priceLevelDQtyBreak5   = stripCurrency(s);
    }

    public void setPriceLevelEQtyBreak5(String s) {
        this.priceLevelEQtyBreak5   = stripCurrency(s);
    }
    public void setPriceLevelFQtyBreak5(String s) {
        this.priceLevelFQtyBreak5   = stripCurrency(s);
    }

    public void setInactiveItem(String s) {
        this.inactiveItem           = (s.trim().length() > 0);
    }

    public void setStandardCost(String s) {
        this.standardCost           = stripCurrency(s);
    }

    public void setDefaultSellLocation(String s) {
        this.defaultSellLocation    = s;
    }

    public void setDefaultRecvdLocation(String s) {
        this.defaultRecvdLocation   = s;
    }

    public void setBrand(String s) {
        this.brand                  = s;
    }

    public void setWeight(String s) {
        this.weight                 = stripCurrency(s);
    }

    public void setUnitOfWeight(String s) {
        this.unitOfWeight           = s;
    }

    public void setWebDescription(String s) {
        this.webDescription         = s;
    }

    public void setSoldInWebStore(String s) {
        this.soldInWebStore         = (s.trim().length() > 0);
    }

    public void setWebStorePrice(String s) {
        this.webStorePrice          = stripCurrency(s);
    }

    public void setItemRecordID(String s) {
        this.itemRecordID           = testInt(s);
    }

    public void setTrackSerialNumber(String s) {
        this.trackSerialNumber      = (s.trim().length() > 0);
    }

    public void setWarrantyAppliesWhenSold(String s) {
        this.warrantyAppliesWhenSold    = (s.trim().length() > 0);
    }

    public void setWarrantyPeriod(String s) {
        this.warrantyPeriod         = testInt(s);
    }

    public void setUnitOfWarrantyPeriod(String s) {
        this.unitOfWarrantyPeriod   = s;
    }

    public void setKitItem(String s) {
        this.kitItem                = (s.trim().length() > 0);
    }

                                             /* ********** GETTERS ********** */
    public String getItemNumber()               { return this.itemNumber; }
    public String getItemName()                 { return this.itemName; }
    public Boolean getBuy()                     { return this.buy; }
    public Boolean getSell()                    { return this.sell; }
    public Boolean getInventory()               { return this.inventory; }
    public String getAssetAcct()                { return this.assetAcct; }
    public String getIncomeAcct()               { return this.incomeAcct; }
    public String getExpenseAcct()              { return this.expenseAcct; }
    public String getItemPicture()              { return this.itemPicture; }
    public String getDescription()              { return this.description; }
    public Boolean getUseDescOnSale()           { return this.useDescOnSale; }
    public String getCustomList1()              { return this.customList1; }
    public String getCustomList2()              { return this.customList2; }
    public String getCustomList3()              { return this.customList3; }
    public String getCustomField1()             { return this.customField1; }
    public String getCustomField2()             { return this.customField2; }
    public String getCustomField3()             { return this.customField3; }
    public String getPrimaryVendor()            { return this.primaryVendor; }
    public String getVendorItemNumber()         { return this.vendorItemNumber; }
    public Boolean getTaxWhenBought()           { return this.taxWhenBought; }
    public String getBuyUnitMeasure()           { return this.buyUnitMeasure; }
    public BigDecimal getNumItemsperBuyUnit()   { return this.numItemsperBuyUnit; }
    public BigDecimal getReorderQuantity()      { return this.reorderQuantity; }
    public BigDecimal getMinimumLevel()         { return this.minimumLevel; }
    public BigDecimal getSellingPrice()         { return this.sellingPrice; }
    public String getSellUnitMeasure()          { return this.sellUnitMeasure; }
    public Boolean getTaxWhenSold()             { return this.taxWhenSold; }
    public BigDecimal getNumItemsPerSellUnit()  { return this.numItemsPerSellUnit; }

    public BigDecimal getQuantityBreak1()       { return this.quantityBreak1; }
    public BigDecimal getQuantityBreak2()       { return this.quantityBreak2; }
    public BigDecimal getQuantityBreak3()       { return this.quantityBreak3; }
    public BigDecimal getQuantityBreak4()       { return this.quantityBreak4; }
    public BigDecimal getQuantityBreak5()       { return this.quantityBreak5; }

    public BigDecimal getPriceLevelAQtyBreak1() { return this.priceLevelAQtyBreak1; }
    public BigDecimal getPriceLevelBQtyBreak1() { return this.priceLevelBQtyBreak1; }
    public BigDecimal getPriceLevelCQtyBreak1() { return this.priceLevelCQtyBreak1; }
    public BigDecimal getPriceLevelDQtyBreak1() { return this.priceLevelDQtyBreak1; }
    public BigDecimal getPriceLevelEQtyBreak1() { return this.priceLevelEQtyBreak1; }
    public BigDecimal getPriceLevelFQtyBreak1() { return this.priceLevelFQtyBreak1; }

    public BigDecimal getPriceLevelAQtyBreak2() { return this.priceLevelAQtyBreak2; }
    public BigDecimal getPriceLevelBQtyBreak2() { return this.priceLevelBQtyBreak2; }
    public BigDecimal getPriceLevelCQtyBreak2() { return this.priceLevelCQtyBreak2; }
    public BigDecimal getPriceLevelDQtyBreak2() { return this.priceLevelDQtyBreak2; }
    public BigDecimal getPriceLevelEQtyBreak2() { return this.priceLevelEQtyBreak2; }
    public BigDecimal getPriceLevelFQtyBreak2() { return this.priceLevelFQtyBreak2; }

    public BigDecimal getPriceLevelAQtyBreak3() { return this.priceLevelAQtyBreak3; }
    public BigDecimal getPriceLevelBQtyBreak3() { return this.priceLevelBQtyBreak3; }
    public BigDecimal getPriceLevelCQtyBreak3() { return this.priceLevelCQtyBreak3; }
    public BigDecimal getPriceLevelDQtyBreak3() { return this.priceLevelDQtyBreak3; }
    public BigDecimal getPriceLevelEQtyBreak3() { return this.priceLevelEQtyBreak3; }
    public BigDecimal getPriceLevelFQtyBreak3() { return this.priceLevelFQtyBreak3; }

    public BigDecimal getPriceLevelAQtyBreak4() { return this.priceLevelAQtyBreak4; }
    public BigDecimal getPriceLevelBQtyBreak4() { return this.priceLevelBQtyBreak4; }
    public BigDecimal getPriceLevelCQtyBreak4() { return this.priceLevelCQtyBreak4; }
    public BigDecimal getPriceLevelDQtyBreak4() { return this.priceLevelDQtyBreak4; }
    public BigDecimal getPriceLevelEQtyBreak4() { return this.priceLevelEQtyBreak4; }
    public BigDecimal getPriceLevelFQtyBreak4() { return this.priceLevelFQtyBreak4; }

    public BigDecimal getPriceLevelAQtyBreak5() { return this.priceLevelAQtyBreak5; }
    public BigDecimal getPriceLevelBQtyBreak5() { return this.priceLevelBQtyBreak5; }
    public BigDecimal getPriceLevelCQtyBreak5() { return this.priceLevelCQtyBreak5; }
    public BigDecimal getPriceLevelDQtyBreak5() { return this.priceLevelDQtyBreak5; }
    public BigDecimal getPriceLevelEQtyBreak5() { return this.priceLevelEQtyBreak5; }
    public BigDecimal getPriceLevelFQtyBreak5() { return this.priceLevelFQtyBreak5; }

    public Boolean getInactiveItem()            { return this.inactiveItem; }
    public BigDecimal getStandardCost()         { return this.standardCost; }
    public String getDefaultSellLocation()      { return this.defaultSellLocation; }
    public String getDefaultRecvdLocation()     { return this.defaultRecvdLocation; }
    public String getBrand()                    { return this.brand; }
    public BigDecimal getWeight()               { return this.weight; }
    public String getUnitOfWeight()             { return this.unitOfWeight; }
    public String getWebDescription()           { return this.webDescription; }
    public Boolean getSoldInWebStore()          { return this.soldInWebStore; }
    public BigDecimal getWebStorePrice()        { return this.webStorePrice; }
    public int getItemRecordID()                { return this.itemRecordID; }
    public Boolean getTrackSerialNumber()       { return this.trackSerialNumber; }
    public Boolean getWarrantyAppliesWhenSold() { return this.warrantyAppliesWhenSold; }
    public int getWarrantyPeriod()              { return this.warrantyPeriod; }
    public String getUnitOfWarrantyPeriod()     { return this.unitOfWarrantyPeriod; }
    public Boolean getKitItem()                 { return this.kitItem; }

    // public String getHeaderName(int i)          { return ITEM_COLUMN_HEADERS[i]; }
    // public int    getColumnCount()              { return ITEM_COLUMN_HEADERS.length; }

    public Boolean getIsValid()                 { return this.isValid; }


    /* ********************************************************************** */
    /* STATIC CLASSES                                                         */
    /* ********************************************************************** */

    /* ********************************************************************** */
    /* CLASSES                                                                */
    /* ********************************************************************** */

}
