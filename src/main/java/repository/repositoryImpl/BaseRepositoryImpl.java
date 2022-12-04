package repository.repositoryImpl;

import gr.ed.studentmanagement.StudentManagement;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import repository.BaseRepository;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {
static final Logger logger = LoggerFactory.getLogger(BaseRepository.class);
    protected EntityManager entityManager;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public abstract Class<T> getEntityClass();
    public abstract String getClassName();

    @Override
    public Optional<T> create(T t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(t);
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.of(t);

    }

    @Override
    public Optional<T> read(int id) {
        T t = entityManager.find(getEntityClass(), id);
        if (t != null) {
            return Optional.of(t);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<T> read() {
        return entityManager.createQuery("from " + getClassName()).getResultList();
    }

    @Override
    public boolean delete(T t) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            logger.warn("Something went wrong with deleting entity " + t ,e);
            return false;
        }

    }

}
