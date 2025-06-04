package org.hospital.mayssam.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.hospital.mayssam.security.entities.AppRole;

public interface AppRoleRepository extends JpaRepository<AppRole, String> {
}