import java.util.Currency;
import java.util.List;

public interface ExchangeRateProvider
{
    List<Currency> provide();
}
