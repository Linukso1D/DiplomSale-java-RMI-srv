/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.users.jpa.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

/**
 *
 * @author maxxl
 * @version 1.0
 * Описывает учеников и методы сохранения получения с бд
 */
@SuppressWarnings("PMD")
@Entity
public class Person implements Serializable
{
   /**
    * Ид
    */
   @Id
   @GeneratedValue
   @Getter
   @Setter
   private Integer id;
    /**
    * Серия атестат
    */
   @Getter
   @Setter
   private String seria;
    /**
    * Номер атестат
    */
   @Getter
   @Setter
   private String number;
    /**
    * Фамилия ученика
    */
   @Getter
   @Setter
   private String surname;
   /**
    * Имя ученика
    */
   @Getter
   @Setter
   private String name;
   /**
    * Отчество ученика
    */
   @Getter
   @Setter
   private String lastname;
    /**
    * Перечень предметов и оценок
    */
   @Type(type = "serializable")
   @Getter
   @Setter
   public Map subjects = new LinkedHashMap<String, String>();
   /**
    * Сохранение оценок по екзаменам 
    */
   @Type(type = "serializable")
   @Getter
   @Setter
   private Map examSubject = new LinkedHashMap<>();
   /**
    * Факультативы
    */
   @Type(type = "serializable")
   @Getter
   @Setter
   private ArrayList additionalSubject = new ArrayList();
   @Getter
   @Setter
   /**
    * Достижения
    */
   private String achievements;
   @Getter
   @Setter
   /**
    *  Достижения по учебе
    */
   private String achievementsStudy;
   /**
    * Фио директора
    */
   @Getter
   @Setter
   private String director;    
   /**
    * Регистрационный номер приложения
    */
   @Getter
   @Setter
   private Integer regCode;
   /**
    * Дата регистрации
    */
   @Getter
   @Setter
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date dateregister;
}
