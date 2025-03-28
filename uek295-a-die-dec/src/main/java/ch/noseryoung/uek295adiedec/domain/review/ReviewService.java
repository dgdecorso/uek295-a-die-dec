package ch.noseryoung.uek295adiedec.domain.review;

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
        return reviewRepository.save(review);
    }

    public Review updateReview(UUID id, Review review) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (reviewOptional.isPresent()) {
            Review updatedReview = reviewOptional.get();
            review.setId(updatedReview.getId());
            review.setVerified(updatedReview.isVerified());
            review.setNumStars(updatedReview.getNumStars());
            return reviewRepository.save(updatedReview);

        }
        return null;
    }

    public void deleteReview(UUID id) {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
    }

}