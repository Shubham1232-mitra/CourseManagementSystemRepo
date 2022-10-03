package com.emeritus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emeritus.modal.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Integer>{

}
