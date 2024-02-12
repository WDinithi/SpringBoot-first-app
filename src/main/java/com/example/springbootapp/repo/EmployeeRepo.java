package com.example.springbootapp.repo;

import com.example.springbootapp.entity.EmployeeEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class EmployeeRepo implements JpaRepository<EmployeeEntity, Integer> {

    @Override
    public List<EmployeeEntity> findAll() {
        return null;
    }

    @Override
    public List<EmployeeEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<EmployeeEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<EmployeeEntity> findAllById(Iterable<Integer> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(EmployeeEntity employeeEntity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> iterable) {

    }

    @Override
    public void deleteAll(Iterable<? extends EmployeeEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends EmployeeEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends EmployeeEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<EmployeeEntity> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends EmployeeEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public <S extends EmployeeEntity> List<S> saveAllAndFlush(Iterable<S> iterable) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<EmployeeEntity> iterable) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public EmployeeEntity getOne(Integer integer) {
        return null;
    }

    @Override
    public EmployeeEntity getById(Integer integer) {
        return null;
    }

    @Override
    public <S extends EmployeeEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends EmployeeEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends EmployeeEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends EmployeeEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends EmployeeEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends EmployeeEntity> boolean exists(Example<S> example) {
        return false;
    }
}
