package com.office.analysis.entity;

public class Paper {
    private String a1;  // 作者缩写，字段名和类型按你实际定义

    private String au;  // 作者全名

    private Long id;    // 论文id

    // 需要生成getter和setter

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getAu() {
        return au;
    }

    public void setAu(String au) {
        this.au = au;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // 其他字段和方法...
}
