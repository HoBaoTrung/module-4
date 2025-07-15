package com.codegym.teluscospringsecurity.repo;

import com.codegym.teluscospringsecurity.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RoleRepo extends JpaRepository<Roles, Long> {
}
