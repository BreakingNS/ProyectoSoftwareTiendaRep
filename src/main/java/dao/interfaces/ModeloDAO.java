package dao.interfaces;

import java.util.List;
import model.Modelo;

public interface ModeloDAO {
    public void crearModelo(Modelo modelo);
    public List<Modelo> obtenerModelos();
    public List<Modelo> listarModelosOrdenadasPorNombre();
    public Modelo obtenerModelo(int id);
    public void actualizarModelo(Modelo modelo);
    public void eliminarModelo(int id);
    public boolean existeModelo(String nombre);
    public Modelo obtenerModeloPorNombre(String nombre);

}
