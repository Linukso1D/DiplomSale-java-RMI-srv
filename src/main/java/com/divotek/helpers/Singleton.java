/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.helpers;

import com.divotek.users.jpa.hibernate.Person;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author maxxl
 */
public class Singleton
{
 /**
  * хранение обектов класса Person 
  */
   private Map PersonList = new LinkedHashMap<Integer,Person>();
   private int countListP=0;
   
   private EntityManager em;
   private Singleton()
   {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("com.divotek.users.jpa.hibernate");
	this.em = entityManagerFactory.createEntityManager();
   }
   public static Singleton getInstance()
   {
	return SingletonHolder.INSTANCE;
   }
   private static class SingletonHolder
   {
	private static final Singleton INSTANCE = new Singleton();
   }
   public EntityManager getManager()
   {
	return this.em;
   }
   /**
    * 
    * @param i Ключ по которому достаеться елемент из коллекции (для jlist)
    * @return Получение екземпляра класса Person
    */
   public Person getOnePerson(Integer i)
   {
    return (Person)this.PersonList.get(i);
   }
   /**
    *@param p добавление/изменение существуещего ученика(Person - {@link com.divotek.users.jpa.hibernate.Person})
    */
   public void setOnePerson(Person p)
   {
	this.PersonList.put(countListP,p);
	countListP++;
   }
   public Map getAllPerson()
   {
    return PersonList;
   }
   
}
