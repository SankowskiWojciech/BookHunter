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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class BookBackendImpl implements BookBackend {

    private final BookRepository bookRepository;
    private final BookAuthorRelationRepository bookAuthorRelationRepository;

    @Override
    public Book findBookById(String bookId) {
        Optional<BookEntity> bookEntityOptional = bookRepository.findById(bookId);
        if (bookEntityOptional.isPresent()) {
            return getInformationAboutAuthorsAndTransformBookEntityToBook(bookEntityOptional.get(), new BookEntityAndAuthorBasicInformationToBook());
        }
        return null;
    }

    @Override
    public List<Book> findByTitleIgnoreCaseContainingSequence(String searchValue) {
        List<BookEntity> bookEntityList = bookRepository.findByTitleIgnoreCaseContaining(searchValue);
        if (bookEntityList != null && !bookEntityList.isEmpty()) {
            List<Book> bookList = new ArrayList<>();
            BookEntityAndAuthorBasicInformationToBook transformer = new BookEntityAndAuthorBasicInformationToBook();
            bookEntityList.forEach(bookEntity -> {
                Book book = getInformationAboutAuthorsAndTransformBookEntityToBook(bookEntity, transformer);
                bookList.add(book);
            });
            return bookList;
        }
        return Collections.emptyList();
    }

    private Book getInformationAboutAuthorsAndTransformBookEntityToBook(BookEntity bookEntity, BookEntityAndAuthorBasicInformationToBook transformer) {
        List<BookAuthorRelationEntity> bookAuthorRelationEntities = bookAuthorRelationRepository.findByBookEntityIsbn(bookEntity.getIsbn());
        List<AuthorBasicInformation> authorBasicInformationList = getAuthorsBasicInformations(bookAuthorRelationEntities);
        return transformer.apply(authorBasicInformationList, bookEntity);
    }

    private List<AuthorBasicInformation> getAuthorsBasicInformations(List<BookAuthorRelationEntity> bookAuthorRelationEntityList) {
        List<AuthorBasicInformation> authorBasicInformationList = new ArrayList<>();
        if (bookAuthorRelationEntityList != null && !bookAuthorRelationEntityList.isEmpty()) {
            bookAuthorRelationEntityList.forEach(relation -> {
                AuthorEntity authorEntity = relation.getAuthorEntity();
                authorBasicInformationList.add(
                        new AuthorBasicInformation(authorEntity.getId(), authorEntity.getName(), authorEntity.getSurname()));
            });
        }
        return authorBasicInformationList;
    }
}
