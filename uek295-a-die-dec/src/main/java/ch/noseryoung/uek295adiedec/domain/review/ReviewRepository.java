package  ch.noseryoung.uek295adiedec.domain.review;

import ch.noseryoung.uek295adiedec.domain.bookstore.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {


    @Query("select r from Review r order by r.numStars")
    List<Review> sortByStars();

}
