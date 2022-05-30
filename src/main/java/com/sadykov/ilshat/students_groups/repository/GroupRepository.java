package com.sadykov.ilshat.students_groups.repository;

import com.sadykov.ilshat.students_groups.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

}
