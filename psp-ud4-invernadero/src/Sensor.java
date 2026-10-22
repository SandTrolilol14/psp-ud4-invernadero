import java.time.LocalTime;

public abstract class Sensor implements Runnable{
    private String nombre;
    private String unidad;
    private int periodo;
    private int nLecturas;
    private double uMinimo;
    private double uMaximo;
    private double suma = 0;
    private double min = Double.MAX_VALUE;
    private double max = Double.MIN_VALUE;
    private int alertas;

    public Sensor(String nombre, String unidad, int periodo, double uMinimo, double uMaximo) {
        this.nombre = nombre;
        this.unidad = unidad;
        this.periodo = periodo;
        this.uMinimo = uMinimo;
        this.uMaximo = uMaximo;
    }

    public abstract double medir();

    @Override
    public void run() {

        String nombre = Thread.currentThread().getName();
        for (int i = 1; i < nLecturas; i++) {

            double valor = medir();
            suma += valor;
            if (valor < min) min = valor;
            if (valor > max) max = valor;

            String alerta = (valor < uMinimo || valor > uMaximo) ? " A ALERTA": "";
            if (!alerta.isEmpty()) alertas++;

            System.out.printf("%s [%s] %s: %.2f %s%s\n", LocalTime.now(), Thread.currentThread().getName(), nombre, valor, unidad, alertas);

            try {

                Thread.sleep(1000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }

        System.out.println(nombre + " terminado");

    }

    public void informe() {

        System.out.println("Informe de: " + nombre + "\n" +
                           "Medias: " + (suma/nLecturas) + "\n" +
                           "Mínimo: " + uMinimo + "\n" +
                           "Máximo: " + uMaximo + "\n" +
                           "Alertas: " + alertas);

    }

}
