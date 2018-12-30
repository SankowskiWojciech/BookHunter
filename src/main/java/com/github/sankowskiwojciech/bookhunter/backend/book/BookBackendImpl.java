package com.github.sankowskiwojciech.bookhunter.backend.book;

import com.github.sankowskiwojciech.bookhunter.backend.book.transformer.BookEntityAndAuthorBasicInformationToBook;
import com.github.sankowskiwojciech.bookhunter.backend.repository.BookAuthorRelationRepository;
import com.github.sankowskiwojciech.bookhunter.backend.repository.BookRepository;
import com.github.sankowskiwojciech.bookhunter.model.author.AuthorBasicInformation;
import com.github.sankowskiwojciech.bookhunter.model.author.db.AuthorEntity;
import com.github.sankowskiwojciech.bookhunter.model.book.Book;
import com.github.sankowskiwojciech.bookhunter.model.book.db.BookEntity;
import com.github.sankowskiwojciech.bookhunter.model.relation.db.BookAuthorRelationEntity;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BookBackendImpl implements BookBackend {

    private final BookRepository bookRepository;
    private final BookAuthorRelationRepository bookAuthorRelationRepository;

    @Override
    public Book findBookById(String bookId) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(bookId);
        if (!bookEntityOptional.isPresent()) {
            return null;
        }
        BookEntity bookEntity = bookEntityOptional.get();
        List<BookAuthorRelationEntity> bookAuthorRelationEntities = bookAuthorRelationRepository.findByBookEntityIsbn(bookEntity.getIsbn());
        List<AuthorBasicInformation> authorBasicInformationList = new ArrayList<>();
        if (bookAuthorRelationEntities != null && !bookAuthorRelationEntities.isEmpty()) {
            bookAuthorRelationEntities.forEach(relation -> {
                AuthorEntity authorEntity = relation.getAuthorEntity();
                authorBasicInformationList.add(
                        new AuthorBasicInformation(authorEntity.getId(), authorEntity.getName(), authorEntity.getSurname()));
            });
        }
        return new BookEntityAndAuthorBasicInformationToBook().apply(authorBasicInformationList, bookEntity);
    }
}
