/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp4;

/**
 *
 * @author admin
 */
public class MP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ordered();
    }
    
    
    public static void ordered(){
        Student student1, student2;
        try {
            student1 = new Student("Ala", "Kota", "s13", 3, 0);
            student2 = new Student("Tomasz", "Mokira", "s3", 5, 1);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        try {
        
            Student student3 = new Student("COPYTomasz", "COPYMokira", "s3", 5, 1);
        } catch (Exception e) {
            System.out.println("Execption about not unique student");
            System.err.println(e.getMessage());
        }
        
    }
}
