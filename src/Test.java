import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String args[]) {
    	 String str = "北京市(海淀区)(朝阳区)(西城区)";
    	 
         String patStr = "(.*?)(?=\\()";
          
         Pattern pattern = Pattern.compile(patStr);
          
         Matcher matcher = pattern.matcher(str);
          
         if(matcher.find())
         {
             System.out.println(matcher.group(0));
         }
         else
         {
             System.out.println(matcher.group(0));
         }

         System.out.println("\\");


    }
}
