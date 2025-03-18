package com.yonex.badminton.controller;

import com.yonex.badminton.entity.BadmintonEntity;
import com.yonex.badminton.repository.BadmintonRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// DI는, 빈 주입은 빈 객체만 가능함

@RestController
@RequestMapping("/api")
public class BadmintonController {
    @Autowired
    BadmintonRepository badmintonRepository;

    @GetMapping("/badminton")
    public List<BadmintonEntity> getBadminton() {
        return badmintonRepository.findAll();
    }

    @PostMapping("/badminton")
    public BadmintonEntity postBadminton(@RequestBody BadmintonEntity badminton) {
        BadmintonEntity badmintonEntity = new BadmintonEntity(badminton.getName(), badminton.getAge(), badminton.getRacketName());
        badmintonRepository.save(badmintonEntity);

        return badminton;
    }

    @DeleteMapping("/badminton/{id}")
    public BadmintonEntity deleteBadminton(@PathVariable("id") Long id) {
        BadmintonEntity deletedBadminton = badmintonRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 ID의 데이터가 없습니다: " + id));

        badmintonRepository.delete(deletedBadminton);

        return deletedBadminton;
    }

    @PutMapping("/badminton/{id}")
    public BadmintonEntity putBadminton(@PathVariable("id") Long id, @RequestBody BadmintonEntity badminton) {
        BadmintonEntity updatedBadminton = badmintonRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 ID의 데이터가 없습니다: " + id));

        updatedBadminton.setName(badminton.getName());
        updatedBadminton.setAge(badminton.getAge());
        updatedBadminton.setRacketName(badminton.getRacketName());
        badmintonRepository.save(updatedBadminton);

        return updatedBadminton;
    }


}
