package me.khmoon.studyolle.modules.study.event;

import lombok.Getter;
import me.khmoon.studyolle.modules.study.Study;

@Getter
public class StudyCreatedEvent {

  private Study study;

  public StudyCreatedEvent(Study study) {
    this.study = study;
  }
}
