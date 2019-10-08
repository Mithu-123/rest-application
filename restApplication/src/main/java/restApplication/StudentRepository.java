package restApplication;

import java.util.List;



import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

@Configuration
@EnableTransactionManagement
public interface StudentRepository extends CrudRepository<Student, Long> {

	List<Student> findAll();

	@Query(value = "SELECT address FROM rakutendb.student12", nativeQuery = true)
	public List<String> findListOfAddress();

	@Query(value = "SELECT school_name FROM rakutendb.student12", nativeQuery = true)
	public List<String> findListOfSchoolName();

	@Query(value = "SELECT school_address FROM rakutendb.student12", nativeQuery = true)
	public List<String> findListOfSchoolAddress();

	@Query(value = "SELECT student_id FROM rakutendb.student12", nativeQuery = true)
	public List<String> findListOfStudentId();
	
	@Transactional
	@Modifying(clearAutomatically = true)
    @Query(value = "UPDATE rakutendb.student12 s  SET s.school_address = :address WHERE s.student_id = :id",nativeQuery = true)
    int updateAddress(@Param("id")  Long id, @Param("address") String address);

}

