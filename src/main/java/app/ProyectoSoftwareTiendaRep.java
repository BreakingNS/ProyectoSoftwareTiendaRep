package app;

import config.ConexionDataBase;
import dao.impl.MarcaDAOImpl;
import java.util.List;
import model.Marca;

public class ProyectoSoftwareTiendaRep {

    public static void main(String[] args) throws ClassNotFoundException {  
        ConexionDataBase conexionDataBase = new ConexionDataBase();
        
        //Funcionamiento Tabla Marca
        MarcaDAOImpl marcasDAO = new MarcaDAOImpl(conexionDataBase.getConexionDBH2());
        
    }
}
