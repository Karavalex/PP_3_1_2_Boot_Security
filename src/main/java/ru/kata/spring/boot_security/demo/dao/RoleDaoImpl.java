package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class RoleDaoImpl implements RoleDAO{
    @PersistenceContext
    private EntityManager entityManager;

    public RoleDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<RoleDAO> getAllRole() {
        return entityManager.createQuery("from Role", RoleDAO.class).getResultList();
    }

    public RoleDAO findRoleByAuthority(String authority) throws NoSuchElementException {
        return getAllRole().stream()
                .filter(r -> authority.equals(r.getAuthority()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(String.format("Role %s not found", authority)));
    }

    @Override
    public String getAuthority() {
        return null;
    }
}
