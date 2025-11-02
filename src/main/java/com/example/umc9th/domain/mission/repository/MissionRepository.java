package com.example.umc9th.domain.mission.repository;

import com.example.umc9th.domain.mission.entity.Mission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface MissionRepository extends JpaRepository<Mission, Long> {

    //5주차 미션 홈 화면 마감일이 남은(도전이 가능한) 미션만 불러오기 페이징 포함
    @Query(
            value = """
            select m
            from Mission m
            join fetch m.store s
            join fetch s.location l
            where l.name = :locationName
              and m.deadline >= :today
              and not exists (
                  select 1
                  from UserMission um
                  where um.user.id = :userId
                    and um.mission = m
              )
            order by m.createdAt desc
            """,
            countQuery = """
            select count(m)
            from Mission m
            join m.store s
            join s.location l
            where l.name = :locationName
              and m.deadline >= :today
              and not exists (
                  select 1
                  from UserMission um
                  where um.user.id = :userId
                    and um.mission = m
              )
            """
    )
    Page<Mission> findAvailableMissionsInLocation(
            @Param("userId") Long userId,
            @Param("locationName") String locationName,
            @Param("today") LocalDate today,
            Pageable pageable
    );
}
