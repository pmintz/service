package com.pdfservice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSV {

        String csvFile;
        BufferedReader br;
        String line;
        String cvsSplitBy;
        String [] ASR;
        ASR asr = new ASR();
        
        CSV(){
        	 String csvFile = "dummydata.csv";
             BufferedReader br = null;
             String line = "";
             String cvsSplitBy = ",";
             String [] ASR = new String[6];
             
             try {

                 br = new BufferedReader(new FileReader(csvFile));
                 while ((line = br.readLine()) != null) {

                     // use comma as separator
                     ASR = line.split(cvsSplitBy);

                 }
                	  
                 /*asr.setApplicationNumber(ASR[0]);
                 asr.seteCTD(ASR[1]);
                 asr.setCoreID(ASR[2]);
                 asr.setContactInfo(ASR[3]);
                 asr.setTechAssistant(ASR[4]);
                 asr.setOther(ASR[5]);*/

             } catch (FileNotFoundException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             } finally {
                 if (br != null) {
                     try {
                         br.close();
                     } catch (IOException e) {
                         e.printStackTrace();
                     }
                 }
             }
        }

        

    
}

