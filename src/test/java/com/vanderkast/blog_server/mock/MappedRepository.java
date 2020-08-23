package com.vanderkast.blog_server.mock;

import com.vanderkast.blog_server.domain.SimplePublication;
import org.springframework.data.repository.CrudRepository;

import java.util.*;

public class MappedRepository<Obj> implements CrudRepository<Obj, String> {
    final Map<String, Obj> data = new HashMap<>();

    private final IdProvider<Obj> idProvider;

    public MappedRepository(IdProvider<Obj> idProvider) {
        this.idProvider = idProvider;
    }

    public interface IdProvider<Obj> {
        String create(Obj obj);

        Optional<String> check(Obj obj);
    }

    @Override
    public <S extends Obj> S save(S entity) {
        String id = idProvider.check(entity).orElse(null);
        if (id == null)
            return create(entity);
        return update(entity);
    }

    private <S extends Obj> S create(S entity) {
        var id = idProvider.create(entity);
        data.put(id, entity);
        return entity;
    }

    private <S extends Obj> S update(S entity) {
        var idOp = idProvider.check(entity);
        if (idOp.isPresent() && data.containsKey(idOp.get())) {
            data.replace(idOp.get(), entity);
            return entity;
        }
        return null;
    }

    @Override
    public <S extends Obj> Iterable<S> saveAll(Iterable<S> entities) {
        List<S> list = new LinkedList<>();
        entities.forEach(entity -> {
            list.add(save(entity));
        });
        return list;
    }

    @Override
    public Optional<Obj> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public boolean existsById(String id) {
        return data.containsKey(id);
    }

    @Override
    public Iterable<Obj> findAll() {
        return data.values();
    }

    @Override
    public Iterable<Obj> findAllById(Iterable<String> ids) {
        List<Obj> list = new LinkedList<>();
        ids.forEach(id -> list.add(data.get(id)));
        return list;
    }

    @Override
    public long count() {
        return data.size();
    }

    @Override
    public void deleteById(String id) {
        data.remove(id);
    }

    @Override
    public void delete(Obj entity) {
        idProvider.check(entity).ifPresent(data::remove);
    }

    @Override
    public void deleteAll(Iterable<? extends Obj> entities) {
        entities.forEach(entity ->
                idProvider.check(entity).ifPresent(data::remove));
    }

    @Override
    public void deleteAll() {
        data.clear();
    }
}
