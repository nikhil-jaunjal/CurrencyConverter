package org.neptune.repo;

import org.neptune.model.CurrencyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<CurrencyEntity, Integer>
{
	CurrencyEntity findByCode(String code);
}
