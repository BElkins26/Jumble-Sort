import java.util.*;
import java.io.*;
public class JumbleSort
{
public static void main( String args[] ) throws Exception
    {
        // ALWAYS TEST FIRST TO VERIFY USER PUT REQUIRED INPUT FILE NAME ON THE COMMAND LINE
        if (args.length < 2 )
        {
            System.out.println("\nusage: C:\\> java JumbleSort <dictionary filename> <jumbled filename> \n\n");
            System.exit(0);
        }
        BufferedReader inFileD = new BufferedReader( new FileReader ( args[0] ) ); 
        BufferedReader inFileJ = new BufferedReader( new FileReader (args[1] ) ); 
        ArrayList <String> dict = new ArrayList <String>(); 
        ArrayList <String> jumb = new ArrayList <String>(); 
        HashMap<String, String> map = new HashMap<String,String>();
        while(inFileD.ready())
        {
            dict.add(inFileD.readLine());
        }
        inFileD.close();
        while(inFileJ.ready())
        {
            jumb.add(inFileJ.readLine());
        }
        inFileJ.close();
        Collections.sort(jumb);
        String alphaJ = "";
        for(int i = 0; i<dict.size(); i++)
        {
                char [] sorted = (dict.get(i)).toCharArray();
                Arrays.sort(sorted);
                String alpha = new String(sorted);
        if(!map.containsKey(alpha))
        {
            map.put(alpha, dict.get(i));
        }
        else
            map.put(alpha, map.get(alpha) +  " " + dict.get(i) );
        }
        for(String word: jumb)
        {
          System.out.print(word);
            char [] sortedJ = word.toCharArray();
            Arrays.sort(sortedJ);
            alphaJ = new String(sortedJ);
        
        if(map.containsKey(alphaJ))
        {
            System.out.print(" " + map.get(alphaJ));
        }
        System.out.println();
        }
    }
    }