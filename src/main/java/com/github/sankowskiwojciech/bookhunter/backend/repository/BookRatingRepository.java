package com.github.sankowskiwojciech.bookhunter.backend.repository;

import com.github.sankowskiwojciech.bookhunter.model.book.rating.db.BookRatingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRatingRepository extends JpaRepository<BookRatingEntity, String> {
}
