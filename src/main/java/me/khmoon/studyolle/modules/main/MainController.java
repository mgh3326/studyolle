package me.khmoon.studyolle.modules.main;

import lombok.RequiredArgsConstructor;
import me.khmoon.studyolle.modules.account.Account;
import me.khmoon.studyolle.modules.account.CurrentAccount;
import me.khmoon.studyolle.modules.study.Study;
import me.khmoon.studyolle.modules.study.StudyRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {

  private final StudyRepository studyRepository;

  @GetMapping("/")
  public String home(@CurrentAccount Account account, Model model) {
    if (account != null) {
      model.addAttribute(account);
    }

    return "index";
  }

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/search/study")
  public String searchStudy(String keyword, Model model,
                            @PageableDefault(size = 9, sort = "publishedDateTime", direction = Sort.Direction.DESC)
                                    Pageable pageable) {
    Page<Study> studyPage = studyRepository.findByKeyword(keyword, pageable);
    model.addAttribute("studyPage", studyPage);
    model.addAttribute("keyword", keyword);
    return "search";
  }

}
