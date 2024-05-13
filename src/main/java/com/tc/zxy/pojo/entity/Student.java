package com.tc.zxy.pojo.entity;

import com.tc.zxy.common.cenum.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * 设计⼀个名为Student的实体类，包含以下属性：
 * ▪ id: 学⽣ID（整数型，⾃增）
 * ▪ name: 学⽣姓名（字符串型）
 * ▪ age: 学⽣年龄（整数型）
 * ▪ gender: 学⽣性别（枚举型，可选值为Male、Female）
 * ▪ grade: 学⽣年级（整数型）
 */
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity(name = "tb_student")
@DynamicUpdate
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "student_name", length = 64)
    private String name;
    @Column(name = "student_age")
    private Integer age;
    @Column(name = "student_gender")
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @Column(name = "student_grade")
    private Integer grade;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Student student = (Student) o;
        return getId() != null && Objects.equals(getId(), student.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
