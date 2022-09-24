package dataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import Beans.Usuarios;
import Interface.UsuarioDAO;

@Database(entities = {Usuarios.class},
version = 1)
public abstract class appDataBase extends RoomDatabase {

    public static appDataBase INSTANCE;

    public abstract UsuarioDAO usuariosDAO();

        public static appDataBase getInstance(Context context){
            if(INSTANCE==null){
                INSTANCE= Room.databaseBuilder(context,
                        appDataBase.class,"dbUsuarios")
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        .build();
            }
            return INSTANCE;
        }
}
