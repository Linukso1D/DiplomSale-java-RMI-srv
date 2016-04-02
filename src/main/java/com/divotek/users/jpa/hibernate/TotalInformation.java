/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.users.jpa.hibernate;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author maxxl
 * Общие сведения для учеников, ( Какая школа )
 * 
 */
@Entity
public class TotalInformation implements Serializable
{   
   @Id
   @Getter
   @Setter
   private int id;
   @Getter
   @Setter
   private String schoolName;
}

