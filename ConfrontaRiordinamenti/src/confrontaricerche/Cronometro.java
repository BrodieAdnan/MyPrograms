package confrontaricerche;

public class Cronometro {

    private boolean fermo;
    private long tempI;
    private long tempF;
    private long tempTot;

    public Cronometro() {
        fermo = true;
        tempI = 0;
        tempF = 0;
        tempTot = 0;
    }

    public void start() {
        if (fermo) {
            tempI = System.currentTimeMillis();
            fermo = false;
        }
    }

    public void stop() {
        if (!fermo) {
            tempF = System.currentTimeMillis();
            fermo = true;
        }
    }

    public void reset() {
        if (fermo) {
            tempTot = 0;
        }
    }

    public double getTime() {
        tempTot += tempF - tempI;
        return tempTot / 1.0;
    }
}
