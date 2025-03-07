import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;

class Simulacion {
    private LinkedBlockingQueue<Proceso> colaReady = new LinkedBlockingQueue<>();
    private Memoria memoria;
    private CPU cpu;
    private Random random = new Random();
    
    public Simulacion(int capacidadMemoria, int instruccionesPorCiclo) {
        this.memoria = new Memoria(capacidadMemoria);
        this.cpu = new CPU(instruccionesPorCiclo);
    }
    
    public void agregarProceso() {
        int memoriaRequerida = random.nextInt(10) + 1;
        int instrucciones = random.nextInt(10) + 1;
        Proceso proceso = new Proceso(memoriaRequerida, instrucciones);
        if (memoria.asignarMemoria(memoriaRequerida)) {
            colaReady.add(proceso);
            //System.out.println("Proceso " + proceso.getId() + " listo para ejecutarse.");
        } else {
            //System.out.println("Memoria insuficiente para proceso " + proceso.getId() + ".");
        }
    }


    public void agregarMultiplesProcesos(int procesos){
        for(int i = 0; i < procesos; i++){
            this.agregarProceso();
        }
    }
    
    public void ejecutarProcesos() {
        while (!colaReady.isEmpty()) {
            Proceso proceso = colaReady.poll();
            cpu.procesar(proceso);
            if (proceso.terminado()) {
                //System.out.println("Proceso " + proceso.getId() + " terminado.");
                memoria.liberarMemoria(proceso.getMemoriaRequerida());
            } else {
                colaReady.add(proceso);
            }
        }
    }
}