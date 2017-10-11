/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controlador.Dao;

import java.util.List;


public interface InterfazDao <T>{
    
    //Los metodos son sin cuerpo las cinterfaes se caracterizan por no tener metodos sin cuerpo 
    T obtener (Long id);
    List<T> listar();
    long contarTodos();
    void guardar(T obj);
    void modificar(T obj);
    void eliminar(T obj);
}
