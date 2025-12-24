import java.io.FileWriter;
import java.io.IOException;

public class Cleaner
{
    private final String filename;

    public Cleaner(String filename)
    {
        this.filename = filename;
    }
    public void clean()
    {
        try (FileWriter writer = new FileWriter(filename))
        {
            writer.write("");
        }
        catch (IOException e)
        {
            System.err.println("Nie udało się wyczyścić pliku: " + e.getMessage());
        }
    }
}
