package me.khmoon.studyolle.event;

import lombok.RequiredArgsConstructor;
import me.khmoon.studyolle.domain.Account;
import me.khmoon.studyolle.domain.Event;
import me.khmoon.studyolle.domain.Study;
import me.khmoon.studyolle.form.event.EventForm;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class EventService {

  private final EventRepository eventRepository;
  private final ModelMapper modelMapper;

  public Event createEvent(Event event, Study study, Account account) {
    event.setCreatedBy(account);
    event.setCreatedDateTime(LocalDateTime.now());
    event.setStudy(study);
    return eventRepository.save(event);
  }

  public void updateEvent(Event event, EventForm eventForm) {
    modelMapper.map(eventForm, event);
    // TODO 모집 인원을 늘린 선착순 모임의 경우에, 자동으로 추가 인원의 참가 신청을 확정 상태로 변경해야 한다. (나중에 할 일)
  }
}