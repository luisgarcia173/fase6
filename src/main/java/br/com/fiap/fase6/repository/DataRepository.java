package br.com.fiap.fase6.repository;

import br.com.fiap.fase6.domain.datainfo.DataInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<DataInfo, Long> {

}
