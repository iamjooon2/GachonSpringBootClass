package com.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);

        // 메모리 사용량 출력하기
        long heapSize = Runtime.getRuntime().totalMemory();
        System.out.println("Heap Size(M): " + heapSize / (1024 * 1024));
    }

}
