package core.repository;

import core.model.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
/**
 * Created by Alexandra on 20/06/2017.
 */
@NoRepositoryBean
@Transactional
public interface BaseRepository<T extends BaseEntity<ID>, ID extends Serializable> extends JpaRepository<T, ID> {
}
