package com.github.sankowskiwojciech.bookhunter.backend.repository;

import com.github.sankowskiwojciech.bookhunter.model.relation.db.BookAuthorRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorRelationRepository extends JpaRepository<BookAuthorRelationEntity, Long> {

    List<BookAuthorRelationEntity> findByBookEntityIsbn(String bookId);
}
