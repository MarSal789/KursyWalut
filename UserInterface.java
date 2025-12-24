import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


public class UserInterface
{
    private final List<Currency> Waluty;
    private final ExchangeRateService rateService;
    private final Scanner scan;
    private final Calculator cal;

    public UserInterface(ExchangeRateService rateService , List<Currency> Waluty, Calculator cal)
    {
        this.rateService = rateService;
        this.scan = new Scanner(System.in);
        this.Waluty = Waluty;
        rateService.getTable();
        this.cal = cal;
    }
    public void start()
    {
        showaRateCurrency(this.Waluty);
        showMainMenu();
    }
    private int showMainMenu()
    {
        int number = 0;
        while (number!=5)
        {
            System.out.println("Menu Startowe");
            System.out.println("1.Wymiana Pln na Inna Walute");
            System.out.println("2.Wymiana Waluta na Pln ");
            System.out.println("3.Wymiana waluty na inna walute");
            System.out.println("4.Ustawienia");
            System.out.println("5.Wyjście");
            System.out.print("wpisz numer aby wybrać opcję: ");
            int choose = scan.nextInt();
            number = choose;
            switch(choose)
            {
                case 1:
                    showaRateCurrency(this.Waluty);
                    exchangePLNToCurrency(this.Waluty);
                    break;
                case 2:
                    showaRateCurrency(this.Waluty);
                    exchangeCurrencyToPLN(this.Waluty);
                    break;
                case 3:
                    showaRateCurrency(this.Waluty);
                    exchnageCurrenyToOtherCurrency(this.Waluty);
                    break;
                case 4:
                    break;
                case 5:
                    return 5;
            }
        }
        return 5;
    }


    private void showaRateCurrency(List<Currency> Waluty2)
    {
        int i = 1;
        for (Currency waluta : Waluty2)
        {
            System.out.println(i + " "+ waluta.get_name() + " " + waluta.get_code() + " " + waluta.get_rate());
            i++;
        }
    }
    private void exchangeCurrencyToPLN(List<Currency> Waluty2)
    {
        System.out.println("Podaj jaką walute chcesz wymienić na Polskie złotówki: ");
        int number = scan.nextInt();
        System.out.println(Waluty2.get(number-1).get_name() + Waluty2.get(number-1).get_code() + Waluty2.get(number-1).get_rate());
        BigDecimal rate = Waluty2.get(number-1).get_rate();

        System.out.println("Podaj ile chcesz wymienić PLN na " + Waluty2.get(number-1).get_name()+": ");
        BigDecimal couter = scan.nextBigDecimal();
        BigDecimal liczba = cal.exchangeToPLN(couter, rate);
        System.out.println(liczba + " PLN");
    }
    private void exchangePLNToCurrency(List<Currency> Waluty2)
    {
        System.out.println("Podaj numer waluty na którą chcesz wymienić Polskie złotówki: ");
        int number = scan.nextInt();
        System.out.println(Waluty2.get(number-1).get_name() + Waluty2.get(number-1).get_code() + Waluty2.get(number-1).get_rate());
        BigDecimal rate = Waluty2.get(number-1).get_rate();
        System.out.println("Podaj ile chcesz wymienić PLN na " + Waluty2.get(number-1).get_name()+": ");
        BigDecimal counter = scan.nextBigDecimal();
        BigDecimal liczba = cal.exchangeToCurrency(counter , rate);
        System.out.println(liczba + " " + Waluty2.get(number-1).get_name());
    }
    private void exchnageCurrenyToOtherCurrency(List<Currency> Waluty2)
    {
        System.out.println("Podaj numer pierwotnej waluty");
        int number = scan.nextInt();
        System.out.println(Waluty2.get(number-1).get_name() + Waluty2.get(number-1).get_code() + Waluty2.get(number-1).get_rate());
        BigDecimal rate = Waluty2.get(number-1).get_rate();
        System.out.println("Podaj ile Chcesz wymienić na nową walute");
        BigDecimal numberC = scan.nextBigDecimal();
        System.out.println("Podaj druga walute");
        number = scan.nextInt();
        System.out.println(Waluty2.get(number-1).get_name() + " "+ Waluty2.get(number-1).get_code() + " "+ Waluty2.get(number-1).get_rate());
        BigDecimal rate1 = Waluty2.get(number-1).get_rate();
        BigDecimal liczba = cal.ExchangeCurrencyToCurrency(numberC , rate, rate1);
        System.out.println(liczba + " " + Waluty2.get(number-1).get_name());
    }
}