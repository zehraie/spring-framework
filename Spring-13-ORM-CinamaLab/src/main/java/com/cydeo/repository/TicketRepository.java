package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
  Integer countAllByUserAccountId(Long userId);
    //Write a derived query to list all tickets by specific email
List<Ticket> findAllByUserAccountEmail(String emil);
    //Write a derived query to count how many tickets are sold for a specific movie, Number of tickets
Integer countAllByMovieCinema_MovieName(String name);
    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime localDateTime2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.userAccount.id = ?1")
 List<Ticket> fetchAllTicketsByUserAccount(@Param("userId") Long userId);
    //Write a JPQL query that returns all tickets between a range of dates
 @Query("SELECT t from Ticket t where t.dateTime between ?1 AND ?2")
    List<Ticket> fetchAllTicketsBetweenRangeOfDateTimes(@Param("dateTime1") LocalDateTime dateTime1,
                                                        @Param("dateTime2") LocalDateTime dateTime2);
    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
@Query(value = "SELECT COUNT(*) FROM ticket where user_account_id = ?1", nativeQuery = true)
    Integer countAllTicketsByUserAccount(@Param("userId") Long userId);
    //Write a native query to count the number of tickets a user bought in a specific range of dates
@Query(value = "SELECT count (*) from ticket where user_account_id = ?1 AND date_time BETWEEN ?2 AND ?3", nativeQuery = true)
Integer countAllTicketsByUserInDateRange(@Param("userId") Long userId, @Param("dateTime1") LocalDateTime dateTime1,
                                         @Param("dateTime2") LocalDateTime dateTime2);
    //Write a native query to distinct all tickets by movie name
@Query(value = "select DISTINCT (m.name) from ticket t JOIN movie_cinema mc"
        +"ON mc.id = t.movie_cinema_id JOIN movie m"
        +"ON mc.movie_id = m.id", nativeQuery = true)
List<String> retrieveAllDistinctMovieNames();
    //Write a native query to find all tickets by user email-->  returns ticket
@Query(value = "SELECT * from ticket t JOIN user_account ua ON t.user_account_id = ua.id"
        + "where ua.email = ?1", nativeQuery = true)
List<Ticket> findAllByUserEmail(@Param("email") String email);
    //Write a native query that returns all tickets
@Query(value = "Select * from ticket ", nativeQuery = true)
List<Ticket> retrieAll();
    //Write a native query to list all tickets where a specific value should be containable in the username or name or movie name
@Query(value = "Select * from ticket t JOIN user_account ua ON t.user_account_id = ua.id"
        +"JOIN account_details ad ON ua.account_details_id = ad.id"
        +"JOIN movie_cinema mc ON t.movie_cinema_id = mc.id"
        +"JOIN movie m ON mc.movie.id = m.id"
        +"OR ad.name ILIKE concat('%',?1,'%')"
        +"OR m.name ILIKE concat('%',?1,'%')", nativeQuery = true)
    List<Ticket> retrieveAllBySearchCriteria(@Param("searchCriteria") String searchCriteria);
}
