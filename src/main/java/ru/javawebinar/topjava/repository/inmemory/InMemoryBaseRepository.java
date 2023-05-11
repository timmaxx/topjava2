package ru.javawebinar.topjava.repository.inmemory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.javawebinar.topjava.model.AbstractBaseEntity;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class InMemoryBaseRepository<T extends AbstractBaseEntity> {
    static final Logger log = LoggerFactory.getLogger(InMemoryBaseRepository.class);

    private static final AtomicInteger counter = new AtomicInteger(0);

    private final Map<Integer, T> map = new ConcurrentHashMap<>();

    public T save(T entity) {
        log.info("save {}", entity);
        if (entity.isNew()) {
            entity.setId(counter.incrementAndGet());
            map.put(entity.getId(), entity);
            return entity;
        }
        return map.computeIfPresent(entity.getId(), (id, oldT) -> entity);
    }

    public boolean delete(int id) {
        log.info("delete {}", id);
        return map.remove(id) != null;
    }

    public T get(int id) {
        log.info("get {}", id);
        return map.get(id);
    }

    Collection<T> getCollection() {
        return map.values();
    }
}