import java.time.LocalTime;

public class Riego extends Thread{

    private double lTotales = 0;

    public Riego() {

        super("riego");

    }

    @Override
    public void run() {

        for(int i = 0; i < 5; i++) {

            System.out.printf("%s [%s] Válvula ABIERTA\n", LocalTime.now(), getName());
            lTotales += 2.5;

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void informe() {

        System.out.println("Informe Riego: 5 ciclos, Litros totales: " + lTotales);

    }
}
