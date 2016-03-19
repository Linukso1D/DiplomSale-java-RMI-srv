/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.users.jpa.hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author maxxl
 */
@SuppressWarnings("PMD")
@Entity
public class Person
{

   @Id
   @GeneratedValue
   @Getter
   @Setter
   private Integer id;

}
