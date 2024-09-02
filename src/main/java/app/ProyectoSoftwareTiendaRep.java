package app;

import config.ConexionDataBase;

public class ProyectoSoftwareTiendaRep {

    public static void main(String[] args) throws ClassNotFoundException {
        ConexionDataBase conexionDataBase = new ConexionDataBase();
        
        conexionDataBase.getConexionDBH2();
    }
}
