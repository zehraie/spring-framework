package com.cydeo.repository;

import com.cydeo.entity.Course;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course,Long> {

    // find all courses by category
    List<Course> findByCategory(String category);

    // find all course by category and order the entities by name
    List<Course> findByCategoryOrderByName(String category);

    // checks if a course with the provided name exists. return true if course exists, false otherwise
    boolean existsByName(String name);

    // returns the count of courses for the provided category
    int countByCategory(String category);

    //find all courses that start with the provided course name
    List<Course> findByNameStartingWith(String name);

    // find all courses by category and returns a stream
    Stream<Course> streamByCategory(String category);

    @Query("select e from Course e where e.category= :category AND e.rating> :rating")
    List<Course> findAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("rating") int rating);





}
