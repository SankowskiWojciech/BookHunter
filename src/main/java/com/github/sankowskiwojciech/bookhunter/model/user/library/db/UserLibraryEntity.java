package com.github.sankowskiwojciech.bookhunter.model.user.library.db;

import com.github.sankowskiwojciech.bookhunter.model.user.authentication.db.UserAuthenticationEntity;
import com.github.sankowskiwojciech.bookhunter.model.user.library.db.converter.RecentlyViewedBooksConverter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "USER_LIBRARY")
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
public class UserLibraryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserAuthenticationEntity userAuthenticationEntity;

    @Convert(converter = RecentlyViewedBooksConverter.class)
    @Column(name = "RECENTLY_VIEWED", nullable = false)
    private List<String> recentlyViewedBooks;
}
