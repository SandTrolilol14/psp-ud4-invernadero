import java.time.LocalTime;

public class ProgramadorRiego extends Thread{

    private double lTotales = 0;

    public ProgramadorRiego() {

        super("riego");

    }

    @Override
    public void run() {

        for(int i = 0; i < 5; i++) {

            System.out.printf("%s [%s] Válvula abierta\n", LocalTime.now(), getName());
            lTotales += 2.5;

            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.printf("%s [%s] Válvula cerrada\n", LocalTime.now(), getName());
        }
    }

    public void informe() {

        System.out.println("Informe Riego: 5 ciclos, Litros totales: " + lTotales);

    }
}
