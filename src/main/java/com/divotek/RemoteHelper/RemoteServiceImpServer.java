/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.RemoteHelper;


import com.divotek.form.mainForm;
import com.divotek.helpers.Singleton;
import com.divotek.users.jpa.hibernate.Person;
import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author maxxl
 */
public class RemoteServiceImpServer implements RemoteServiceAllPerson,Runnable
{
     public RemoteServiceImpServer()
    {
  
    }
    
   public final String BINDING_NAME = "SendPToServer";
   @Override
   public Object sendOnePerson(Person person) throws RemoteException
   {
       if(person!=null)
       {
     
       System.err.println("SendOnePerson -> "+ person.getName()+" "+ person.getSurname()+" "+person.getRegCode());
	// Нужно  записать обьекты Персон в бд если их там нету , если есть то перезаписать, и обновить список учеников на форме
     Singleton instance = Singleton.getInstance();
     instance.setRFalse();
     instance.getAllPerson().forEach((k,value)->
             {
                 if(value.equals(person))
                    {
                    System.err.println("SendOnePerson -> Найдено совпадение");
                        instance.getManager().getTransaction().begin();
                        instance.getManager().remove(instance.getManager().contains(value) ? value : instance.getManager().merge(value));
                        instance.getManager().getTransaction().commit();
                    System.err.println("SendOnePerson -> del old"+value.toString());            
                        /* Если совпадение найдено */
                        instance.getManager().getTransaction().begin();
                        instance.getManager().persist(instance.getManager().contains(person) ? person : instance.getManager().merge(person));
                        instance.getManager().getTransaction().commit();
                        System.err.println("SendOnePerson -> add new "+person.toString());                           
                        instance.setRTrue();
                    }
             });
       if(!instance.getRewrite())
       {
      final String listUpdated = "Добавлен новый ученик: \n Имя: \n " +person.getName()+"Фамилия: \n "+person.getSurname()+ " Отчество: \n"+person.getLastname() + "\n Регистрационный номер " +person.getRegCode().toString() + " \n Класс: "+ person.getClassName(); 

           System.out.println("Добавление ученика из вне \n " + listUpdated);
           instance.getManager().getTransaction().begin();
           Person p = instance.getManager()
                    .contains(person)
                    ? person
                    : Singleton.getInstance().getManager()
                    .merge(person);
            instance.getManager().getTransaction().commit();
           
                        instance.getManager().getTransaction().begin();
                        instance.getManager().persist(p);
                        instance.getManager().getTransaction().commit();
                        instance.setRFalse();
                        
           new Thread(() -> {
                 JOptionPane.showMessageDialog(null, "Выполнено добавление нового ученика: "); 
             }).start();             
                        
           
       }
       
       
       JList tme = mainForm.mF.getListPerson();
       DefaultListModel lm = mainForm.loadJlistUsers(mainForm.mF.getCombo1());
       tme.setModel(lm);
       //mainForm.mF.getListPerson().setModel(mainForm.mF.loadJlistUsers(mainForm.mF.getCombo1()));//Обновление списка учеников
	
	// UnicastRemoteObject.getClientHost() ип от кого 
	
	return "Сервер: Ваши данные успешно обновлены";
       }
       return " Person is null ";
   }
   @Override
   public void run()
   {
       System.err.println("CREATE RMI INSTANCE");
	try
	{
	final Registry registry;
        
       // LocateRegistry.getRegistry("localhost",2099);
        
	registry = LocateRegistry.createRegistry(2099);
        final RemoteServiceAllPerson service = new RemoteServiceImpServer();
	Remote stub = UnicastRemoteObject.exportObject(service, 0);
	registry.bind(BINDING_NAME, stub);
        System.err.println("Binding RMI");
	}
	catch (RemoteException | AlreadyBoundException ex)
	{
	   System.out.println("Ошибка инициализации слушателя:\n\n\n\n " + ex);
	}
	
   }

    @Override
    public Map <String, Person> getAllPerson() throws RemoteException {
       return Singleton.getInstance().getAllPerson();
    }

    @Override
    public Object testString(String a) throws RemoteException {
        System.out.println("String a = " + a );
        return "Сервер в сети " ;
    }
}
