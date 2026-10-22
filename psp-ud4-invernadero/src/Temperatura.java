import java.util.concurrent.ThreadLocalRandom;

public class Temperatura extends Sensor{

    public Temperatura() {

        super("Temperatura", "°C", 600, 50.0, 80.0);

    }

    @Override
    public double medir() {

        return ThreadLocalRandom.current().nextDouble(40.0, 90.0);

    }
}
