public class Main {
    public static void main(String[] args) {
        int[] cantidadesProcesos = {25, 50, 100, 150, 200};
        
        for (int procesos : cantidadesProcesos) {
            Simulacion simulacion = new Simulacion(100, 3); // Memoria: 100, CPU ejecuta 3 instrucciones por ciclo
            
            long inicio = System.nanoTime();
            simulacion.agregarMultiplesProcesos(procesos);
            simulacion.ejecutarProcesos();
            long fin = System.nanoTime();
            
            System.out.println("Tiempo total de ejecución para " + procesos + " procesos: " + (fin - inicio) + " ns");
        }
    }
}