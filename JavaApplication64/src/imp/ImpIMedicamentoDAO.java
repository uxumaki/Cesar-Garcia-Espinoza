/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imp;

import dao.IMedicamentoDAO;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import pojo.Medicamento;
import util.RandomUtil;

/**
 *
 * @author FD314
 */
public class ImpIMedicamentoDAO implements IMedicamentoDAO{
    private Medicamento medicamento;
    private List<Medicamento> medicamentos;
    private RandomAccessFile raf;
    private int tam = 1000;

    public ImpIMedicamentoDAO() {
    }

    @Override
    public Medicamento findByID(int id) throws IOException {
        RandomUtil.filename = "medicamento.dat";
        raf = RandomUtil.getCurrentConnection();
        raf.seek(0);
        int n = raf.readInt();
        if (id > n || id <= 0) {
            return null;
            }

        long pos = 4 + (id - 1) * tam;
        raf.seek(pos);

        medicamento = new Medicamento();
        medicamento.setId(raf.readInt());
        medicamento.setNombre(raf.readUTF());
        medicamento.setCategoria(raf.readUTF());
        medicamento.setDescripcion(raf.readUTF());
        medicamento.setCantidad(raf.readFloat());
        medicamento.setCosto(raf.readFloat());
        medicamento.setUnidad(raf.readUTF());
        return medicamento;
    }

@Override
        public List<Medicamento> findByName(String name) throws IOException {
        RandomUtil.filename = "medicamento.dat";
        raf = RandomUtil.getCurrentConnection();
        raf.seek(0);
        int n = raf.readInt();
        medicamentos = new ArrayList<Medicamento>();
        for(int i = 1;i <= n;i++){
            medicamento = findByID(i);
            if(medicamento.getNombre().toUpperCase().trim()
                    .startsWith(name.toUpperCase().trim())){
                medicamentos.add(medicamento);
            }
        }
        return medicamentos;
    }

    @Override
    public List<Medicamento> findByDescripcion(String descripcion) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Medicamento> findAll() throws IOException {
    RandomUtil.filename = "medicamento.dat";
        raf = RandomUtil.getCurrentConnection();
        raf.seek(0);
        int n = raf.readInt();
        medicamentos = new ArrayList<Medicamento>();
        for (int i = 1; i <= n; i++) {
            medicamento = findByID(i);
            medicamentos.add(medicamento);
        }

        return  medicamentos;
    }

    @Override
    public boolean save(Medicamento medicamento) throws IOException {
        boolean r = false;
        RandomUtil.filename = "producto.txt";
        raf = RandomUtil.getCurrentConnection();
        raf.seek(0);
        int n = raf.readInt();
        long pos = 4 + n * tam;

        raf.seek(pos);
        raf.writeInt(n + 1);
        raf.writeUTF(medicamento.getNombre());
        raf.writeUTF(medicamento.getCategoria());
        raf.writeUTF(medicamento.getDescripcion());
        raf.writeFloat(medicamento.getCantidad());
        raf.writeFloat(medicamento.getCosto());
        raf.writeUTF(medicamento.getUnidad());
        raf.seek(0);
        raf.writeInt(++n);
        r = true;

        
        return r;
    }

    @Override
    public boolean update(Medicamento medicamento) throws IOException {
         boolean r = false;
        RandomUtil.filename = "medicamento.dat";
        raf = RandomUtil.getCurrentConnection();

        raf.seek(0);
        int n = medicamento.getId() - 1;
        long pos = 4 + n * tam;

        raf.seek(pos);
        raf.writeInt(medicamento.getId());
        raf.writeUTF(medicamento.getNombre());
        raf.writeUTF(medicamento.getCategoria());
        raf.writeUTF(medicamento.getDescripcion());
        raf.writeFloat(medicamento.getCantidad());
        raf.writeFloat(medicamento.getCosto());
        raf.writeUTF(medicamento.getUnidad());        
        r = true;

        
        return r;
    }
    private void close() throws IOException {
        if (raf != null) {
            raf.close();
        }
    }
}
