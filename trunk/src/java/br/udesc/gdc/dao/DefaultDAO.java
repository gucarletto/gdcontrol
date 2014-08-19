package java.br.udesc.gdc.dao;

import java.util.List;

/**
 * 
 * @author gustavo
 */
public interface DefaultDAO<T extends Object> {
    
    public boolean inserir(T t);
//    public boolean alterar(T t);
//    public boolean excluir(T t);
//    public T pesquisar(long id);
//    public List<T> listarTodos();
    public int getQuantidadeRegistro();
}
