import java.io.*;
import java.net.Inet4Address;
import java.nio.channels.ScatteringByteChannel;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class FileCatalogLoader implements CatalogLoader{

    private Product readProduct(String line) throws DataFormatException
    {
        StringTokenizer tokenizer=new StringTokenizer(line,"_");
        if(tokenizer.countTokens()!=4)
        {
            throw new DataFormatException("令牌数量不匹配，需四个字段："+line);
        }
        try{
            tokenizer.nextToken();
            String code=tokenizer.nextToken();
            String description=tokenizer.nextToken();
            double price= Double.parseDouble(tokenizer.nextToken());
            return new Product(code,description,price);
        }
        catch (NumberFormatException e)
        {
            throw new DataFormatException("产品数据格式有误："+line);
        }
    }

    private Coffee readCoffee(String line) throws DataFormatException
    {
        StringTokenizer tokenizer=new StringTokenizer(line,"_");
        if(tokenizer.countTokens()!=10)
        {
            throw new DataFormatException("令牌数量不匹配，需十个字段："+line);
        }
        try{
            tokenizer.nextToken();
            String code=tokenizer.nextToken();
            String description=tokenizer.nextToken();
            double price= Double.parseDouble(tokenizer.nextToken());
            String origin=tokenizer.nextToken();
            String roast=tokenizer.nextToken();
            String flavor=tokenizer.nextToken();
            String aroma=tokenizer.nextToken();
            String acidity=tokenizer.nextToken();
            String body=tokenizer.nextToken();
            Coffee coffee = new Coffee(code, description, price, origin, roast, flavor, aroma, acidity, body);
            return coffee;
        }
        catch (NumberFormatException e)
        {
            throw new DataFormatException("产品数据格式有误："+line);

        }
    }

    private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException
    {
        StringTokenizer tokenizer=new StringTokenizer(line,"_");
        if(tokenizer.countTokens()!=7){
            throw new DataFormatException("令牌数量不匹配，需七个字段："+line);
        }
        try{
            tokenizer.nextToken();
            String code=tokenizer.nextToken();
            String description= tokenizer.nextToken();
            double price=Double.parseDouble(tokenizer.nextToken());
            String model= tokenizer.nextToken();
            String waterSupply= tokenizer.nextToken();
            int numberOfCups=Integer.parseInt(tokenizer.nextToken());
            return new CoffeeBrewer(code,description,price,model,waterSupply,numberOfCups);
        }
        catch (NumberFormatException e)
        {
            throw new DataFormatException("产品数据格式有误："+line);
        }
    }
    @Override
    public Catalog loadCatalog(String fileName) throws FileNotFoundException, IOException, DataFormatException {
        Catalog catalog = new Catalog();
        try( BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product;
                if (line.startsWith("Product")) {
                    product = readProduct(line);
                }
                else if (line.startsWith("Coffee")) {
                    product = readCoffee(line);
                }
                else if (line.startsWith("Brewer")) {
                    product = readCoffeeBrewer(line);
                }
                else  {
                    throw new DataFormatException("未知的产品类型：" + line);
                }
                catalog.addProduct(product);
            }
            return catalog;
        }
    }
}