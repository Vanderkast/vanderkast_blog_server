package com.vanderkast.blog_server.helper;

import com.vanderkast.blog_server.database.dto.SimplePublication;
import com.vanderkast.blog_server.database.repository.SimplePublicationRepository;

import java.util.*;

public class MockSimplePublicationRepository implements SimplePublicationRepository {
    private final Map<String, SimplePublication> data = new HashMap<>();

    @Override
    @SuppressWarnings("unchecked")
    public <S extends SimplePublication> S save(S entity) {
        String key = UUID.randomUUID().toString();
        SimplePublication publication = new SimplePublication();
        publication.setId(key);
        publication.setTitle(entity.getTitle());
        publication.setContent(entity.getContent());
        publication.setTimestamp(new Date().getTime());
        data.put(key, publication);
        return (S) publication;
    }

    @Override
    public <S extends SimplePublication> Iterable<S> saveAll(Iterable<S> entities) {
        List<S> list = new LinkedList<>();
        entities.forEach(entity -> list.add(save(entity)));
        return list;
    }

    @Override
    public Optional<SimplePublication> findById(String id) {
        return Optional.ofNullable(data.get(id));
    }

    @Override
    public boolean existsById(String id) {
        return data.containsKey(id);
    }

    @Override
    public Iterable<SimplePublication> findAll() {
        return data.values();
    }

    @Override
    public Iterable<SimplePublication> findAllById(Iterable<String> strings) {
        List<SimplePublication> result = new LinkedList<>();
        strings.forEach(s -> findById(s).ifPresent(result::add));
        return result;
    }

    @Override
    public long count() {
        return data.size();
    }

    @Override
    public void deleteById(String s) {
        data.remove(s);
    }

    @Override
    public void delete(SimplePublication entity) {
        data.remove(entity.getId(), entity);
    }

    @Override
    public void deleteAll(Iterable<? extends SimplePublication> entities) {
        entities.forEach(entity -> data.remove(entity.getId(), entity));
    }

    @Override
    public void deleteAll() {
        data.clear();
    }
}
