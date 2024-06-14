package itca.dao; 
import java.util.List;

public interface CRUDInterface<T> {
    
    T findById(int id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    
}
