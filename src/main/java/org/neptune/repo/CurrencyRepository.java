package org.neptune.repo;

import org.neptune.model.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface CurrencyRepository extends CrudRepository<Currency, Integer>
{
	Currency findByCode(String code);

	Currency findByCurrencyId(Integer currencyId);
}
