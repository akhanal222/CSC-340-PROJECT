package com.CSC_340_PROJECT4.Project4.sysadmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysAdminRepository extends JpaRepository<SysAdmin, Integer> {
    SysAdmin findByUsername(String username);
}
