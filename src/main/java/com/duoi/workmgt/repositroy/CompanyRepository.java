package repositroy;

import com.duoi.workmgt.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    Optional<Company> findOneById(Long id);

    Optional<Company> findOneByCompanyName(String name);

    void deleteOneByCompanyName(String name);

    @Override
    void deleteById(Long aLong);

    @Override
    void deleteAll();
}
