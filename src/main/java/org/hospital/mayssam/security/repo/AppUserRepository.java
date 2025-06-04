package org.hospital.mayssam.security.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.hospital.mayssam.security.entities.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}
