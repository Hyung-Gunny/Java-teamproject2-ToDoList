package com.example.TODOLIST;

/*
- 파일명: ToDolist 만들기
- 클래스명: Class TodolistApplication
- 프로그램 목적 및 기능: 프로그램을 실행하도록 설정하는 클래스
- 프로그램 작성자: 김나은, 박형건
====================================================================================
- 프로그램 작성일: 2023.12.10
- 프로그램 최종 수정일: 2023.12.13
====================================================================================
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

}
