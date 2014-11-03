
package com.mahadihasan.mc.db;

import com.mahadihasan.mc.patient.MedicalRecord;
import com.mahadihasan.mc.patient.Patient;
import java.sql.ResultSetMetaData;

/**
 *
 * @author MAHADI HASAN NAHID
 */
public class AllInformation extends Database {
    
    public AllInformation() {
        connectToDatabase();
    }
    
    public  Patient getPersonalInformation(String key) {
        /**
         * 
         * 
         * 
         * 
         */
        String sql, s;
        String[] data = new String[12];
        
        sql = "SELECT * FROM patient WHERE id = '" + key + "'";
        
        
        try {
            resultSet = statement.executeQuery(sql);


            ResultSetMetaData metaData = resultSet.getMetaData();
            int numberOfColumns = metaData.getColumnCount();

            System.out.println("--------------");


            while (resultSet.next()) {

                for (int i = 1; i <= numberOfColumns; i++) {

                    data[i] = resultSet.getObject(i).toString();
                    System.out.printf("%-8s\t", data[i]);
                   
                }

                System.out.println();
            }
        } catch (Exception exception) {
            System.out.println("Exception");
        }
        
        
        
        Patient patient = new Patient(data[1], data[2], data[3],data[4],
                data[5], data[6], data[7], data[8], data[9], data[10]);
        return patient;
        
    }
    
    public MedicalRecord getMedicalRecord(String key) {
        /**
         * three arrays... insert data 4rm Db into arrays
         * then convert them into three Arraylist
         * 
         * 
         */
        MedicalRecord medicalRecord = new MedicalRecord(null, null, null);
        return medicalRecord;
    }
    
    
    
}
