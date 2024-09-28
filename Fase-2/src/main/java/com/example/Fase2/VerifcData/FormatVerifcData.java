package com.example.Fase2.VerifcData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FormatVerifcData {
    public String formartCPF(String cpf){

        String resultCPF = cpf.replaceAll("[^0-9]", "");

        StringBuilder stringBuilder = new StringBuilder(resultCPF);

        stringBuilder.insert(3,".");
        stringBuilder.insert(7,".");
        stringBuilder.insert(11,"-");

        return stringBuilder.toString();
    }

    public boolean verificCPF(String cpf){
        String resultCPF = cpf.replaceAll("[^0-9]", "");

        if(resultCPF.length() == 11){
            return true;
        }
        else{
            return false;
        }
    }

    public String formartCEP(String cep){

        String resultCEP = cep.replaceAll("[^0-9]", "");

        StringBuilder stringBuilder = new StringBuilder(resultCEP);

        stringBuilder.insert(5,"-");


        return stringBuilder.toString();
    }



    public boolean reverseDate(String date){

        LocalDate today = LocalDate.now();

        LocalDate dateNew = LocalDate.parse(date, DateTimeFormatter.ofPattern("ddMMyyyy"));

        if (dateNew.isBefore(today)) {
            return false;
        } else if (dateNew.isAfter(today)) {
            return true;
        } else {
            return true;
        }

    }

    public boolean reverseDate(String dateEntry, String dateExit){

        LocalDate today = LocalDate.now();

        LocalDate dateEntryNew = LocalDate.parse(dateEntry, DateTimeFormatter.ofPattern("ddMMyyyy"));
        LocalDate dateExitNew = LocalDate.parse(dateExit, DateTimeFormatter.ofPattern("ddMMyyyy"));


        if (dateEntryNew.isBefore(today) || dateExitNew.isBefore(dateEntryNew)) {
            return false;
        } else if (dateEntryNew.isAfter(today)) {
            return true;
        } else {
            return true;
        }

    }

    public boolean verifcDate(String date){

        String resultDate = date.replaceAll("[^0-9]", "");

        if(resultDate.length() == 8){
            return true;
        }
        else{
            return false;
        }
    }

    public String formatTelephone(String telephone){

        String resultTelephone = telephone.replaceAll("[^0-9]", "");

        StringBuilder stringBuilder = new StringBuilder(resultTelephone);

        stringBuilder.insert(0,"+");
        stringBuilder.insert(3,"(");
        stringBuilder.insert(6,")");

        return stringBuilder.toString();
    }

    public LocalDate revertDate(String dataString) {

        LocalDate localDate = parseDate(dataString);

        return localDate;
    }

    private static LocalDate parseDate(String dateString) {
        // Define o formato da data
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy");
        return LocalDate.parse(dateString, formatter);
    }
}




