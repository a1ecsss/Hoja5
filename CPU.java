class CPU {
    private int instruccionesPorCiclo;
    
    public CPU(int instruccionesPorCiclo) {
        this.instruccionesPorCiclo = instruccionesPorCiclo;
    }
    
    public void procesar(Proceso proceso) {
        proceso.ejecutarInstrucciones(instruccionesPorCiclo);
    }
}