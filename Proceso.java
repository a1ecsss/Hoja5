class Proceso {
    private static int ContadorGeneral = 0;
    private int id;
    private int memoriaRequerida;
    private int instruccionesRestantes;
    
    public Proceso(int memoriaRequerida, int instruccionesRestantes) {
        this.id = ++ContadorGeneral;
        this.memoriaRequerida = memoriaRequerida;
        this.instruccionesRestantes = instruccionesRestantes;
    }
    
    public int getMemoriaRequerida() { 
        return memoriaRequerida; 
    }

    public int getInstruccionesRestantes() { 
        return instruccionesRestantes; 
    }

    public void ejecutarInstrucciones(int cantidad) {
        instruccionesRestantes = Math.max(0, instruccionesRestantes - cantidad);
    }

    public boolean terminado() { 
        return instruccionesRestantes == 0; 
    }

    public int getId() { 
        return id; 
    }
}