import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;

import java.io.IOException;


public class TabelaWalut implements ExchangeRateService
{
    private final String FileName;
    TabelaWalut(String FileName)
    {
        this.FileName = FileName;
    }
    @Override
    public void getTable()
    {
        String link = "https://nbp.pl/statystyka-i-sprawozdawczosc/kursy/tabela-a/";
        try
        {
            Document doc = Jsoup.connect(link).get();
            //System.out.println("Tytuł : " + doc.title());

            Elements table = doc.select("table");

            Elements tr = table.select("tr");

            //System.out.println(tr);

            String tekstDoZapisu;

            for (Element row: tr)
            {
                //System.out.println(row);
                Elements cells = row.select("td , th");

                tekstDoZapisu = cells.text();

                //System.out.println(tekstDoZapisu);

                try(FileWriter writer = new FileWriter(FileName , true))
                {
                    writer.write(tekstDoZapisu);
                    writer.write(System.lineSeparator());
                }

                catch (IOException e)
                {
                    System.err.println("Błąd zapisu do pliku " + e.getMessage());
                }
            }
        }

        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

    }
}
