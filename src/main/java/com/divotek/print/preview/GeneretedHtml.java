/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.divotek.print.preview;

import static com.divotek.R.autoBox.cutter;
import static com.divotek.date.Gettoday.getDate;
import com.divotek.helpers.Singleton;
import com.divotek.users.jpa.hibernate.Person;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.BiConsumer;
import javafx.scene.input.KeyCode;

/**
 *
 * @author maxxl
 */
public class GeneretedHtml {
   private static boolean Wooman;
 
   public static String Create(Person person)
   {
	String fix="";
	String fix3="";
	String fix2="";
	Wooman=person.getSex();
	if(Wooman){
	fix="ла";
	fix2="a";
	fix3="ла";
	}
	else {fix="в";fix2="";fix3="ов";}
	Singleton ins= Singleton.getInstance();
	ArrayList List= cutter(ins.getInfo());
	
	 Map subject = new LinkedHashMap(24);
	
	 //Форма сохранения не даст вбить в базу больше 24 предметов
	 subject.putAll(person.getSubjects());

ArrayList sbk = new ArrayList();
ArrayList sbv = new ArrayList();
subject.forEach((k,v)->{int i=0;sbk.add(i, k);sbv.add(i, v);i++;});
	Collections.reverse(sbk);
	Collections.reverse(sbv);
for(int i=subject.size();i<24;i++)
{
   sbk.add(i, "&nbsp;");
    sbv.add(i, "&nbsp;");
}

Map examSubject = new LinkedHashMap();
examSubject.putAll(person.getExamSubject());

ArrayList Esbk = new ArrayList();
ArrayList Esbv = new ArrayList();
examSubject.forEach((k,v)->{int i=0;Esbk.add(i, k);Esbv.add(i, v);i++;});
Collections.reverse(Esbk);
	Collections.reverse(Esbv);
for(int i=examSubject.size();i<6;i++)
{
   Esbk.add(i, "&nbsp;");
   Esbv.add(i, "&nbsp;");
}

//факультативы 
ArrayList addis=person.getAdditionalSubject();
for(int i=addis.size();i<5;i++)
{
addis.add(i,"&nbsp;");
}

 String FirstPage="<html lang=\"uk\">\n" +
"\n" +
"<head>\n" +
"	<meta charset=\"UTF-8\">\n" +
"	<title>Document</title>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"	<table border=\"0\" width=\"100%\">\n" +
"		<tr>\n" +
"			<td width=\"50%\" valign=\"top\">\n" +
"				<p style=\"margin-top:0px;margin-bottom:0px;font-weight:bold;text-align:center;text-transform:uppercase;\">ДОДАТОК ДО АТЕСТАТА</p>\n" +
"				<p style=\"margin-top:0px;margin-bottom:0px;text-align:center;\">про повну загальню середню освіту</p>\n" +
"				<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"					<tr>\n" +
"						<td align=\"center\">\n" +
"							<table cellpadding=\"0\" cellspacing=\"0\">\n" +
"								<tr>\n" +
"									<td style=\"border-bottom:2px solid #000;padding-left:10px;padding-right:10px;\">"+person.getSeria()+"</td>\n" +
"									<td>№</td>\n" +
"									<td style=\"border-bottom:2px solid #000;padding-left:10px;padding-right:10px;\">"+person.getNumber()+"</td>\n" +
"								</tr>\n"
	    + "<tr><td colspan=\"3\" style=\"text-align:center;\"><small> (без атестата не дійсний)</small></td></tr>" +
"							</table>\n" +
"						</td>\n" +
"					</tr>\n" +
"				</table>\n" +
"				<p style=\"margin-top:6px;margin-bottom:6px;border-bottom: 2px solid black;text-align:center;margin-bottom:0px\">"+person.getSurname()+"&nbsp;"+person.getName()+"</p>\n" +
"				<div style=\"text-align:center;\">\n" +
"					<small> (призвище ім'я по батькові)</small>\n" +
"				</div>\n" +
"				<p style=\"margin-top:0px;margin-bottom:0px;border-bottom: 2px solid black;text-align:center;\">"+person.getLastname()+"</p>\n" +
"				<table cellpadding=\"3\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
"					<tr>\n" +
"						<span>Закінчи"+fix+" у 2016 році </span>\n" +
"						<td style=\"border-bottom:2px solid #000;padding-left:10px;padding-right:10px;width:63%;\">"+fixSpace(List.get(0).toString())+"</td>\n" +
"					</tr>\n" +
"				</table>\n" +
"				<p style=\"margin-top:6px;margin-bottom:6px;border-bottom: 2px solid black;text-align:center;margin-bottom:0px\">"+fixSpace(List.get(1).toString())+"</p>\n" +
"				<div style=\"text-align:center;\">\n" +
"					<small> (назва навчального закладу)</small>\n" +
"				</div>\n" +
"<p style=\"margin-top:0px;margin-bottom:0px;border-bottom: 2px solid black;text-align:center;\">"+fixSpace(List.get(2).toString())+"</p>\n" +
"				<span>з такими балами:</span>\n" +
"				<table cellpadding=\"1\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
"					<tr>\n" +
"						<td style=\"width:70%;text-align:center;margin:0;\">назва предмету</td>\n" +
"						<td style=\"width:30%;text-align:center;margin:0;\">бал</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(0).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(0).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(1).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(1).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(2).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(2).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(3).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(3).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(4).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(4).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(5).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(5).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(6).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(6).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(7).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(7).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(8).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(8).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(9).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(9).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(10).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(10).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(11).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(11).toString())+"</td>\n" +
"					</tr>\n" +
"				</table>\n" +
"\n" +
"\n" +
"\n" +
"\n" +
"			</td>\n" +
"			<td width=\"50%\" valign=\"top\">\n" +
"\n" +
"				<table cellpadding=\"1\" cellspacing=\"0\" border=\"0\" width=\"100%\">\n" +
"\n" +
"					<tr >\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;margin-top:10px; \">"+fixSpace(sbk.get(12).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(12).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(13).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(13).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(14).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(14).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(15).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(15).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(16).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(16).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(17).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(17).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(18).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(18).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(19).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(19).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(20).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(20).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(21).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(21).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(22).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(22).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(sbk.get(23).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(sbv.get(23).toString())+"</td>\n" +
"					</tr>\n" +
"				</table>\n" +
"				<p style=\"margin-top:5px;margin-bottom:0px;\">пройш"+fix3+" державну підсумкову атестацію з таких предметів</p>\n" +
"				<table cellpadding=\"1\" cellspacing=\"0\" border=\"0\" width=\"100%\" style=\"margin-top:53px;\">\n" +
"					<tr>\n" +
"						<td style=\"width:70%;text-align:center;margin:0;\">назва предмету</td>\n" +
"						<td style=\"width:30%;text-align:center;margin:0;\">бал</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(Esbk.get(0).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(Esbv.get(0).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(Esbk.get(1).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(Esbv.get(1).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(Esbk.get(2).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(Esbv.get(2).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(Esbk.get(3).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(Esbv.get(3).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+Esbk.get(4)+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(Esbv.get(4).toString())+"</td>\n" +
"					</tr>\n" +
"					<tr>\n" +
"						<td style=\"width:60%;border-bottom:2px solid black;\">"+fixSpace(Esbk.get(5).toString())+"</td>\n" +
"						<td style=\"width:30%;border-bottom:2px solid black;margin-left:20px;\">"+fixSpace(Esbv.get(5).toString())+"</td>\n" +
"					</tr>\n" +
"				</table>\n" +
"			</td>\n" +
"		</tr>\n" +
"	</table>\n " +
"<table border=\"0\" width=\"100%\">\n" +
"		<tr>\n" +
"			<td width=\"50%\" valign=\"top\">\n" +
"			<p style=\"margin-top:0px;margin-bottom:0px;text-align:left;\">Успішно засвої"+fix+" програму факультативних курсів:</p>\n" +
"			<p style=\"margin-top:6px;margin-bottom:6px;border-bottom: 2px solid black;text-align:center;margin-bottom:0px\">"+fixSpace(addis.get(0).toString())+"</p>\n" +
"				<div style=\"text-align:center;\">\n" +
"					<small> (назва)</small>\n" +
"				</div>\n" +
"				<p style=\"margin-top:6px;margin-bottom:6px;border-bottom: 2px solid black;text-align:center;margin-bottom:0px\">"+fixSpace(addis.get(1).toString())+"</p>\n" +
"				<p style=\"margin-top:6px;margin-bottom:6px;border-bottom: 2px solid black;text-align:center;margin-bottom:0px\">"+fixSpace(addis.get(2).toString())+"</p>\n" +
"				<p style=\"margin-top:6px;margin-bottom:6px;border-bottom: 2px solid black;text-align:center;margin-bottom:0px\">"+fixSpace(addis.get(3).toString())+"</p>\n" +
"				<p style=\"margin-top:6px;margin-bottom:6px;border-bottom: 2px solid black;text-align:center;margin-bottom:0px\">"+fixSpace(addis.get(4).toString())+"</p>\n" +
"				\n" +
"<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"					<tr>\n" +
"					\n" +
"							\n" +
"								\n" +
"					<td>За</td>\n" +
"					<td style=\"border-bottom:2px solid #000;padding-left:10px;padding-right:10px;\">"+person.getAchievements()+"</td>\n" +
"							<td style=\"padding-left:10px;\">досягнення у</td>\n" +
"				\n" +
"					</tr>\n" +
"					\n" +
"</table>\n" +
"		<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"					<tr>\n" +
"					<td>нагороджен"+fix2+"</td>\n" +
"					</tr>			\n" +
"		</table>\n" +
"		<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"					<tr>\n" +
"<td style=\"border-bottom:2px solid #000;padding-left:10px;padding-right:10px;\">"+person.getMedal()+"</td>\n" +
"<td style=\"padding-left:10px;\">медаллю </td>	\n" +
"					</tr>\n" +
"					\n" +
"</table>\n" +
"	<p style=\"margin-top:9px;margin-bottom:6px;margin-bottom:0px\">За особливі досягнення у вивченні:</p>\n" +
"	<p style=\"margin-top:6px;margin-bottom:6px;border-bottom: 2px solid black;text-align:center;margin-bottom:0px\">"+person.getAchievementsStudy()+"</p>\n" +
"		<p style=\"margin-top:6px;margin-bottom:6px;margin-bottom:0px\">за особливі нагороджен"+fix2+"</p>	\n" +
"			<p style=\"margin-top:6px;margin-bottom:6px;margin-bottom:0px\">Похвальною грамотою</p>\n" +
"		<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"					<tr>\n" +
"					\n" +
"							\n" +
"								\n" +
"					<td>Директор</td>\n" +
"					<td style=\"border-bottom:2px solid #000;padding-left:10px;padding-right:10px;\">"+person.getDirector()+"</td>\n" +
"						\n" +
"				\n" +
"					</tr>\n" +
"					\n" +
"</table>\n" +
"<p style=\"margin-top:30px;margin-bottom:6px;margin-bottom:0px\">М.П.</p>	\n" +
"<table style=\"margin-top:30px;\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"					<tr>\n" +
"						<td align=\"left\">\n" +
"							<table cellpadding=\"0\" cellspacing=\"0\">\n" +
"								<tr>\n" +
"									<td style=\"border-bottom:2px solid #000;padding-left:10px;padding-right:10px;\">"+getDate()+"</td>\n" +					
"								</tr>\n" +
"							</table>\n" +
"						</td>\n" +
"					</tr>\n" +
"				</table>		\n" +
"		\n" +
"		<table style=\"margin-top:30px;\" width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
"					<tr>\n" +
"						<td align=\"center\">\n" +
"							<table cellpadding=\"0\" cellspacing=\"0\">\n" +
"								<tr>\n" +
"									<td style=\"padding-left:10px;padding-right:10px;\">реестраційний номер</td>\n" +
"									<td>&nbsp;</td>\n" +
"									\n" +
"									<td style=\"border-bottom:2px solid #000;padding-left:10px;padding-right:10px;\">"+person.getNumber()+"</td>\n" +
"								</tr>\n" +
"							</table>\n" +
"						</td>\n" +
"					</tr>\n" +
"				</table>	\n" +
"		\n" +
"			</td>\n" +
"			<td width=\"50%\" valign=\"top\">\n" +
"<p style=\"margin-top:180px;margin-bottom:6px;margin-bottom:0px;text-align:center;\">ДОДАТОК</p>\n" +
"		<p style=\"margin-top:6px;margin-bottom:6px;margin-bottom:0px;text-align:center;\">ДО АТЕСТАТА</p>\n" +
"		<p style=\"margin-top:6px;margin-bottom:6px;margin-bottom:0px;text-align:center;\">про повну загальню середню освіту</p>\n" +
"		<p style=\"margin-top:170px;margin-bottom:6px;margin-bottom:0px;text-align:center;\">"+person.getSeria()+"&nbsp;&nbsp;№&nbsp;&nbsp;"+person.getRegCode()+"</p>\n" +
"			</td>\n" +
"		</tr>\n	</table></body></html>";
	
   return FirstPage;
   }
 
   private static String fixSpace(String s)
   {
   return s.replace(" ", "&nbsp;");
   }
}
