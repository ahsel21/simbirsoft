package com.ahsel.simbirsoft.repo;

import com.ahsel.simbirsoft.models.Words;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WordsRepository extends CrudRepository<Words, Long> {
}
