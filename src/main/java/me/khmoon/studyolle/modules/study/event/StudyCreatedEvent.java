package me.khmoon.studyolle.modules.study.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.khmoon.studyolle.modules.study.Study;

@Getter
@RequiredArgsConstructor
public class StudyCreatedEvent {

  private final Study study;

}
