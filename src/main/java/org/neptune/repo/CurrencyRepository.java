package org.neptune.repo;

import org.neptune.model.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer>
{
	CurrencyEntity findByCode(String code);
}
