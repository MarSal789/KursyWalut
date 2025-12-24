import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator
{
    public BigDecimal exchangeToCurrency(BigDecimal counter , BigDecimal rate)
    {
        return counter.divide(rate, RoundingMode.FLOOR);
    }
    public BigDecimal exchangeToPLN(BigDecimal counter, BigDecimal rate)
    {
        return counter.multiply(rate);
    }
    public BigDecimal ExchangeCurrencyToCurrency(BigDecimal counter, BigDecimal rate1, BigDecimal rate2)
    {
        return exchangeToCurrency(exchangeToPLN(counter, rate1), rate2);
    }
}
