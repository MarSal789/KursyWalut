//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main
{
    public static void main(String[] args)
    {
        String fileName = "waluty.txt";
        Cleaner cleaner = new Cleaner(fileName);
        cleaner.clean();
        ExchangeRateService service = new TabelaWalut(fileName);
        CurrencyRepository currencyRepository2 = new Read();
        Calculator cal = new Calculator();
        service.getTable();
        //currencyRepository2.readTrue(fileName);
        //System.out.printf(currencyRepository2.readTrue(fileName).toString());

        UserInterface Usr = new UserInterface(service ,currencyRepository2.readTrue(fileName),cal);
        Usr.start();

    }
}