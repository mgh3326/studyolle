package me.khmoon.studyolle.zone;

import me.khmoon.studyolle.domain.Zone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZoneRepository extends JpaRepository<Zone, Long> {
  Zone findByCityAndProvince(String cityName, String provinceName);
}
