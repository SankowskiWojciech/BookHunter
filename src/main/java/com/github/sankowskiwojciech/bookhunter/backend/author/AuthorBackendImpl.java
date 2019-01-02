package com.github.sankowskiwojciech.bookhunter.backend.author;

import com.github.sankowskiwojciech.bookhunter.backend.author.transformer.AuthorEntityAndBookBasicInformationToAuthor;
import com.github.sankowskiwojciech.bookhunter.backend.repository.AuthorRepository;
import com.github.sankowskiwojciech.bookhunter.backend.repository.BookAuthorRelationRepository;
import com.github.sankowskiwojciech.bookhunter.model.author.Author;
import com.github.sankowskiwojciech.bookhunter.model.author.db.AuthorEntity;
import com.github.sankowskiwojciech.bookhunter.model.book.BookBasicInformation;
import com.github.sankowskiwojciech.bookhunter.model.book.db.BookEntity;
import com.github.sankowskiwojciech.bookhunter.model.relation.db.BookAuthorRelationEntity;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class AuthorBackendImpl implements AuthorBackend {

    private final AuthorRepository authorRepository;
    private final BookAuthorRelationRepository bookAuthorRelationRepository;

    @Override
    public Author findAuthorById(Long authorId) {
        Optional<AuthorEntity> authorEntityOptional = authorRepository.findById(authorId);
        if (!authorEntityOptional.isPresent()) {
            return null;
        }
        AuthorEntity authorEntity = authorEntityOptional.get();

        List<BookAuthorRelationEntity> bookAuthorRelationEntities = bookAuthorRelationRepository.findByAuthorEntityId(authorEntity.getId());
        List<BookBasicInformation> bookBasicInformationList = new ArrayList<>();
        if (bookAuthorRelationEntities != null && !bookAuthorRelationEntities.isEmpty()) {
            bookAuthorRelationEntities.forEach(relation -> {
                BookEntity bookEntity = relation.getBookEntity();
                bookBasicInformationList.add(
                        new BookBasicInformation(bookEntity.getIsbn(), bookEntity.getTitle()));
            });
        }
        return new AuthorEntityAndBookBasicInformationToAuthor().apply(bookBasicInformationList, authorEntity);
    }
}
