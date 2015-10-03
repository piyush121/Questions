import java.util.Map;
import java.util.HashMap;
class LognestSuquenceWORepeation{
  public static void main(String[] args){
    LognestSuquenceWORepeation l = new LognestSuquenceWORepeation();
    System.out.println(l.getLongestSequence("ABDEFGABEF"));
    System.out.println(l.getLongestSequence("GEEKSFORGEEKS"));
  }

  int getLongestSequence(String str){
    Map<Character,Integer> map = new HashMap<>();
    int maxLength = 0;
    int currentLength = 0;
    for(int i=0; i<str.length();i++){
      int previousPosition=-1;
      if(map.get(str.charAt(i))!=null){
        previousPosition =map.get(str.charAt(i));
      }

      if(previousPosition==-1|| i-currentLength>previousPosition){
        currentLength++;
      }
      else{
        currentLength=i-previousPosition;
      }
      if(currentLength>maxLength){
        maxLength = currentLength;
      }
      map.put(str.charAt(i),i);
    }
    return maxLength;
  }
}
