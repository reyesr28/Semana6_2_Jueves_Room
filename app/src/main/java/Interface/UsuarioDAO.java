package Interface;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
import Beans.Usuarios;

@Dao
public interface UsuarioDAO {

    @Insert
    public void insert(Usuarios usu);

    @Query("SELECT * FROM usuarios")
    List<Usuarios> listaUsuarios();

}
