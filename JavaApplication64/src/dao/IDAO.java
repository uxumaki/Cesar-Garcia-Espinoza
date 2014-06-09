/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author FD314
 */
public interface IDAO <T>{
    List<T> findAll() throws IOException;
    boolean save(T medicamento) throws IOException;
    boolean update(T medicamento) throws IOException;
}
