package me.khmoon.studyolle.event;

import me.khmoon.studyolle.domain.Account;
import me.khmoon.studyolle.domain.Enrollment;
import me.khmoon.studyolle.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
  boolean existsByEventAndAccount(Event event, Account account);

  Enrollment findByEventAndAccount(Event event, Account account);
}
