import java.math.BigDecimal;

public class Currency {
    private final String name;
    private final String code;
    private final BigDecimal rate;

    public Currency(String name , String code, BigDecimal rate)
    {
        this.name = name;
        this.code = code;
        this.rate = rate;
    }

    public String get_name()
    {
        return this.name;
    }

    public String get_code()
    {
        var code1 = this.code;
        return code1;
    }

    public BigDecimal get_rate()
    {
        var rate1 = this.rate;
        return rate1;
    }

}
