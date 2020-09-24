package me.khmoon.studyolle.modules.notification;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import me.khmoon.studyolle.modules.account.Account;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Notification {

  @Id
  @GeneratedValue
  private Long id;

  private String title;

  private String link;

  private String message;

  private boolean checked;

  @ManyToOne
  private Account account;

  private LocalDateTime createdDateTime;

  @Enumerated(EnumType.STRING)
  private NotificationType notificationType;

}
