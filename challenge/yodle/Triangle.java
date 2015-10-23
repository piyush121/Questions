/*
 
 
 Yodle Challenge to find the maximum sum from triangle.txt
 
 Program works for any traingle with the size less than 100 rows.
 
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

class Triangle{

    public static void main(String[] str){
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("triangle.txt"));
            String line;
            ArrayList<String> lines= new ArrayList<String>();
            
            //logic to read from files
            while ((line=br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
            
            //logic to convert read data to two dimensional integer array which works for triangle sizes less than 100 rows and 100 columns
            int[][] triangleArray=new int[100][100];
            for(int i=0;i<lines.size();i++){
                for(int j=0;j<lines.get(i).split("\\s+").length;j++){
                    triangleArray[i][j]=Integer.parseInt(lines.get(i).split("\\s+")[j]);
                }
            }
            
            // Logic to find maximum sum
            for(int row=lines.size()-2;row>=0;row--){
               for(int col=0;col<=row;col++){
                    triangleArray[row][col]+= Math.max(triangleArray[row+1][col], triangleArray[row+1][col+1]);
                }
            }
            System.out.println("Answer is : "+triangleArray[0][0]);
            
        }
        catch(Exception e){
            System.out.println("Oops!! Something went wrong. Please provide triangle.txt file in correct format!!");
            //e.printStackTrace();
        }
        finally {
            
        }
        
    }

}