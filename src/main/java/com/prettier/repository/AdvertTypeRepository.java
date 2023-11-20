package com.prettier.repository;


import com.prettier.entity.concretes.AdvertType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdvertTypeRepository extends JpaRepository<AdvertType, Long> {
}
