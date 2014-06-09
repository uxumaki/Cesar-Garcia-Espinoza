/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.util.List;
import pojo.Medicamento;

/**
 *
 * @author FD314
 */
public interface IMedicamentoDAO extends IDAO<Medicamento> {
    Medicamento findByID(int id) throws IOException;
    List<Medicamento> findByName(String name) throws IOException;
    List<Medicamento> findByDescripcion(String descripcion) throws IOException;
}


