package repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;
import repository.BaseRepository;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

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
    public boolean delete(Object t) {
        Object o = entityManager.find(Object.class, t);
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
