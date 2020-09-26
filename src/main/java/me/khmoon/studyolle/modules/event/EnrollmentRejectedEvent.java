package me.khmoon.studyolle.modules.event;

import me.khmoon.studyolle.modules.event.event.EnrollmentEvent;

public class EnrollmentRejectedEvent extends EnrollmentEvent {

  public EnrollmentRejectedEvent(Enrollment enrollment) {
    super(enrollment, "모임 참가 신청을 거절했습니다.");
  }
}

