package com.example.nutrient.study;

import org.springframework.stereotype.Service;

@Service
public class PathService {
    public PathResponse findPath(Long source, Long target) {
        return new PathResponse(10, 10, 10);
    }
}
