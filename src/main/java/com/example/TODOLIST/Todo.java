package com.example.TODOLIST;

import jakarta.persistence.*;
/*
- 파일명: ToDolist 만들기
- 클래스명: Class Todo
- 프로그램 목적 및 기능: 값을 받아 올 수 있게 하는 변수들을 선언하고 this로 값을 받아 오도록 하게 설계했다.
- 프로그램 작성자: 김나은, 박형건
====================================================================================
- 프로그램 작성일: 2023.12.10
- 프로그램 최종 수정일: 2023.12.13
====================================================================================
 */
@Entity//@Entity 주석은 이 클래스의 인스턴스가 엔터티가 됨을 나타냅니다. 즉, 관계형 데이터베이스에 유지된다는 의미입니다.
public class Todo
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//필드의 값이 데이터베이스의 ID 열을 사용하여 자동으로 생성되도록 지정합니다.

    private Long id;

    private String title;
    private String message;
    private boolean completed;

    public Todo() {
    }

    public Todo(String title, String message, boolean completed) {
        //기본 생성자: 초기값을 지정하지 않고 인스턴스를 생성하는 데 사용되는 빈 생성자입니다.
        //매개변수화된 생성자: 세 가지 매개변수(제목, 메시지, 완료됨)를 취하고 해당 필드를 초기화합니다.
        this.title = title;
        this.message = message;
        this.completed = completed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
