package com.tp7.flutter.repos;



import com.tp7.flutter.entities.ClassMat;
import com.tp7.flutter.entities.ClassMatId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassMatRepository extends JpaRepository<ClassMat, ClassMatId> {

}
