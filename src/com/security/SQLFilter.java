package com.security;

public class SQLFilter {
	public String nameFilter(String s){
		String temp=s.replace("'", "��");
		temp.replace("\"", "��");
		temp.replace("\\","");
		temp.replace(",", "");
		temp.replace("/","");
		temp.replace("*","*");
		temp.replaceAll(";","��");
		return temp;
	}
	
public String chatFilter(String str){
	str = str.replace("'", "��");
	str = str.replaceAll("\"", "��");
    str = str.replace(";", "��");
    str = str.replace(",", ",");
    str = str.replace("?", "?");
    str = str.replace("<", "��");
    str = str.replace(">", "��");
    str = str.replace("(", "(");
    str = str.replace(")", ")");
    str = str.replace("@", "��");
    str = str.replace("=", "��");
    str = str.replace("+", "��");
    str = str.replace("*", "��");
    str = str.replace("&", "��");
    str = str.replace("#", "��");
    str = str.replace("%", "��");
    str = str.replace("$", "��");

    return str;

}
}
