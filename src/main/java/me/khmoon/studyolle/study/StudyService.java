package me.khmoon.studyolle.study;


import lombok.RequiredArgsConstructor;
import me.khmoon.studyolle.domain.Account;
import me.khmoon.studyolle.domain.Study;
import me.khmoon.studyolle.study.form.StudyDescriptionForm;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudyService {

  private final StudyRepository repository;
  private final ModelMapper modelMapper;

  public Study createNewStudy(Study study, Account account) {
    Study newStudy = repository.save(study);
    newStudy.addManager(account);
    return newStudy;
  }

  public Study getStudyToUpdate(Account account, String path) {
    Study study = this.getStudy(path);
    if (!account.isManagerOf(study)) {
      throw new AccessDeniedException("해당 기능을 사용할 수 없습니다.");
    }

    return study;
  }

  public Study getStudy(String path) {
    Study study = this.repository.findByPath(path);
    if (study == null) {
      throw new IllegalArgumentException(path + "에 해당하는 스터디가 없습니다.");
    }

    return study;
  }

  public void updateStudyDescription(Study study, StudyDescriptionForm studyDescriptionForm) {
    modelMapper.map(studyDescriptionForm, study);
  }
}