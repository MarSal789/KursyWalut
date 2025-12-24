import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Read implements CurrencyRepository
{
    @Override
    public List<Currency> readTrue(String FileName)
    {
        System.out.println("ok");
        try(BufferedReader reader = new BufferedReader(new FileReader(FileName)))
        {

            List<Currency> Waluty = new ArrayList<>();

            String linia;
            reader.readLine();
            while((linia = reader.readLine()) != null)
            {

                String[] MyArray = linia.split(" ");

                StringBuilder name = new StringBuilder();

                for(int i=0; i<MyArray.length-3; i++)
                {
                    name.append(MyArray[i]).append(" ");
                }

                //System.out.println(name);

                name.deleteCharAt(name.length()-1);

                String code = MyArray[MyArray.length-2];

                BigDecimal rate = new BigDecimal((MyArray[MyArray.length-1].replace(",", ".")));

                BigDecimal PLNToCurrency = new BigDecimal(MyArray[MyArray.length-3]);

                //System.out.println(name);
                Waluty.add(new Currency(name.toString(), code, rate.divide(PLNToCurrency)));
            }
            return Waluty;
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
