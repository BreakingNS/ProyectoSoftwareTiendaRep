package model;

public class Pagado {
    private int id_pagado;
    private String nombre_pago;

    public Pagado() {
    }

    public Pagado(int id_pagado, String nombre_pago) {
        this.id_pagado = id_pagado;
        this.nombre_pago = nombre_pago;
    }

    public int getId_pagado() {
        return id_pagado;
    }

    public String getNombre_pago() {
        return nombre_pago;
    }

    public void setId_pagado(int id_pagado) {
        this.id_pagado = id_pagado;
    }

    public void setNombre_pago(String nombre_pago) {
        this.nombre_pago = nombre_pago;
    }
    
    
}
