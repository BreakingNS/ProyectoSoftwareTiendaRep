package dao.interfaces;

import java.util.List;
import model.Pagado;

public interface PagadoDAO {
    public void crearPagado(Pagado pagado);
    public List<Pagado> obtenerPagados();
    public Pagado obtenerPagado(int id);
    public void actualizarPagado(Pagado pagado);
    public void eliminarPagado(int id);
    public boolean existePagado(String nombre);
    public Pagado obtenerPagadoPorNombre(String nombre);
}
