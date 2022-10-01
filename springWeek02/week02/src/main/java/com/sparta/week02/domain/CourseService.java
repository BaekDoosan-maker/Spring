package com.sparta.week02.domain;
import org.hibernate.sql.Update;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CourseService {
    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final CourseRepository courseRepository;
    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }
    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, Course course) {
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        course1.update(course);
        return course1.getId();
    }
   // 데이터 업데이트 (Update)
    //    @Bean
//    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
//        return (args) -> {
//            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));
//
//            System.out.println("데이터 인쇄");
//            List<Course> courseList = courseRepository.findAll();
//            for (int i=0; i<courseList.size(); i++) {
//                Course course = courseList.get(i);
//                System.out.println(course.getId());
//                System.out.println(course.getTitle());
//                System.out.println(course.getTutor());
//            }
//
//            Course new_course = new Course("웹개발의 봄, Spring", "임민영");
//            courseService.update(1L, new_course);
//            courseList = courseRepository.findAll();
//            for (int i=0; i<courseList.size(); i++) {
//                Course course = courseList.get(i);
//                System.out.println(course.getId());
//                System.out.println(course.getTitle());
//                System.out.println(course.getTutor());
//            }
//        };
//    }
    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            Course new_course = new Course("웹개발의 봄, Spring", "임민영");
            courseService.update(1L, new_course);
            courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
            courseRepository.deleteAll();
        };

    }
}
