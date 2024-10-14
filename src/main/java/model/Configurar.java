package model;

public class Configurar {
    private String ubicacionBD;
    private int stockBajoMinimo;
    private int stockMedioMinimo;

    public Configurar() {
    }

    public Configurar(String ubicacionBD, int stockBajoMinimo, int stockMedioMinimo) {
        this.ubicacionBD = ubicacionBD;
        this.stockBajoMinimo = stockBajoMinimo;
        this.stockMedioMinimo = stockMedioMinimo;
    }

    public String getUbicacionBD() {
        return ubicacionBD;
    }

    public int getStockBajoMinimo() {
        return stockBajoMinimo;
    }

    public int getStockMedioMinimo() {
        return stockMedioMinimo;
    }

    public void setUbicacionBD(String ubicacionBD) {
        this.ubicacionBD = ubicacionBD;
    }

    public void setStockBajoMinimo(int stockBajoMinimo) {
        this.stockBajoMinimo = stockBajoMinimo;
    }

    public void setStockMedioMinimo(int stockMedioMinimo) {
        this.stockMedioMinimo = stockMedioMinimo;
    }
    
    
}
