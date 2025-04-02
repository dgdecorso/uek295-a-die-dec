package ch.noseryoung.uek295adiedec.domain.review;

import ch.noseryoung.uek295adiedec.domain.bookstore.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getReviews() {
        return reviewRepository.findAll();
    }

    public Review getReview(UUID id) {
        Optional<Review> review = reviewRepository.findById(id);
        return null;
    }

    public Review createReview(Review review) {
        if (review.getNumStars() > 10) {

        }
        return reviewRepository.save(review);
    }

    public void deleteReview(UUID id) {
        reviewRepository.deleteById(id);
    }


    public Review updateReview(UUID id, Review review) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            reviewOptional.get().setBook(review.getBook());
            reviewOptional.get().setNumStars(review.getNumStars());
            reviewOptional.get().setComment(review.getComment());
            reviewOptional.get().setVerified(review.isVerified());
            reviewRepository.save(reviewOptional.get());
            return reviewOptional.get();
        }
        return null;
    }

}