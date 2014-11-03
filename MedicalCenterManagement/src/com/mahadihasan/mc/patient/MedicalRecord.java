
package com.mahadihasan.mc.patient;

import java.util.ArrayList;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class MedicalRecord {
   private ArrayList<String> date;
   private ArrayList<String> disease;
   private ArrayList<String> medicine;
   
   
   
   public MedicalRecord(ArrayList<String> d,
           ArrayList<String> dis, ArrayList<String> medi) {
       
       setDate(d);
       setDisease(dis);
       setMedicine(medi);
       
       
   }
   
   private void setDate(ArrayList<String> dt) {
       date = dt;
   }
   public ArrayList<String> getDate() {
       return date;
   }
   private void setDisease(ArrayList<String> dis) {
       disease = dis;
   }
   public ArrayList<String> getDisease() {
       return disease;
   }
   private void setMedicine(ArrayList<String> medi) {
       medicine = medi;
   }
   public ArrayList<String> getMedicine() {
       return medicine;
   }
}
