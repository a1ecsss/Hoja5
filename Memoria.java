class Memoria {
    private int capacidad;
    private int disponible;
    
    public Memoria(int capacidad) {
        this.capacidad = capacidad;
        this.disponible = capacidad;
    }
    
    public boolean asignarMemoria(int cantidad) {
        if (cantidad <= disponible) {
            this.disponible -= cantidad;
            return true;
        }
        return false;
    }
    
    public void liberarMemoria(int cantidad) {
        this.disponible += cantidad;
    }
    
    public int getDisponible() { 
        return disponible; 
    }

    public void liberarTodaMemoria(){
        this.disponible = this.capacidad;
    }

}