//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class XMLSalesFormatter implements SalesFormatter {
    private static final String NEW_LINE = System.getProperty("line.separator");
    private static XMLSalesFormatter singletonInstance = null;

    public static XMLSalesFormatter getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new XMLSalesFormatter();
        }

        return singletonInstance;
    }

    private XMLSalesFormatter() {
    }

    public String formatSales(Sales var1) {
        String var2 = "<Sales>" + NEW_LINE;

        for(Order var4 : var1) {
            var2 = var2 + "  <Order total=\"" + var4.getTotalCost() + "\">" + NEW_LINE;

            for(OrderItem var6 : var4) {
                var2 = var2 + "    <OrderItem quantity=\"" + var6.getQuantity() + "\" price=\"" + var6.getProduct().getPrice() + "\">" + var6.getProduct().getCode() + "</OrderItem>" + NEW_LINE;
            }

            var2 = var2 + "  </Order>" + NEW_LINE;
        }

        var2 = var2 + "</Sales>";
        return var2;
    }
}
