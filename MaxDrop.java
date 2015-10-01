class MaxDrop{
  public static void main(String[] args){
    int[] array = {0,2002,1,99,0,100,0,200};
    MaxDrop md = new MaxDrop();
    System.out.println(md.maxDrop(array));
  }
  int maxDrop(int[] array){
    if(array.length<=1){
      return -1;
    }
    int maxDiff = 0;
    int min = array[0];
    int max = array[1];
    int currentDiff = array[1]-array[0];
    for(int i=1;i<array.length;i++){
      if(array[i]>max){
        max= array[i];
        maxDiff = array[i]-min;
      }
      if(array[i]<min){
        min=array[i];
        max=array[i+1];
        currentDiff=max-min;
      }
      if(currentDiff>maxDiff){
        maxDiff=currentDiff;
      }
    }
    return maxDiff;
  }
}
