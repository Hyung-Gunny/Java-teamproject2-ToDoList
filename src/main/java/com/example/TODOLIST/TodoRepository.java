package com.example.TODOLIST;
/*
- 파일명: ToDolist 만들기
- 클래스명: Class TodolistApplication
- 프로그램 목적 및 기능: interface를 생성하여 인터페이스는 To do 엔터티에 대한 기본 데이터베이스와의 상호 작용을 처리하고 지속성 컨텍스트를 관리하며 일반적인 데이터베이스 작업을 위한 메서드를 제공한다.
- 프로그램 작성자: 김나은, 박형건
====================================================================================
- 프로그램 작성일: 2023.12.10
- 프로그램 최종 수정일: 2023.12.13
====================================================================================
 */
import org.springframework.data.jpa.repository.JpaRepository;
public interface TodoRepository extends JpaRepository<Todo, Long>
{
}
