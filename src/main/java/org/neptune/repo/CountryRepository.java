package org.neptune.repo;

import org.neptune.model.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface CountryRepository extends CrudRepository<Country, Integer>
{

	// CountryDTO save(CountryDTO country);

}
