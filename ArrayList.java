public class ArrayList{
       
   //array to store actual elements in ArrayList
   private int[] items;
   //keep track of how many elements are in the array
   private int numItems;

   public ArrayList(){
      this.items = new int[10];
      this.numItems = 0;
   }


   public void add(int element){
      //check if there's room in array
      if(this.numItems < this.items.length){
         //add element to end of array
         this.items[this.numItems] = element;
         this.numItems++;
     }else{
         //double the size of the array
         int[] temp = new int[this.items.length*2];
         //copy array across
         for(int i = 0; i < this.numItems; i++){
             temp[i] = this.items[i];
         }
         //convert back to items array
         this.items = temp;
         this.items[this.numItems] = element;
         this.numItems++;
     }
   }      

   public void add(int index, int element){
      //make sure there is room in array
      if(this.numItems >= this.items.length){
         //double the size of the array
         int[] temp = new int[this.items.length*2];
         //copy array across
         for(int i = 0; i < this.numItems; i++){
            temp[i] = this.items[i];
         }
         //convert back to items array
         this.items = temp;
      }
         //add element to array at index
         //make sure index falls in data set
         if(index < numItems && index >= 0){
             //copy array across values from point index onwards in new array
             int[] temp = new int[numItems - index];
             for(int i = index; i < index + temp.length; i++){
                 temp[i-index] = this.items[i];
             }
             //insert element in items array
             this.items[index] = element;
             this.numItems++;
             //reinsert values above index in original array
             for(int i = 0; i < temp.length; i++){
                 this.items[index + i + 1] = temp[i];
             }
         }else if(index == numItems){
            //throw exception
            //tell user to use add method to add to end of array
            throw new IndexOutOfBoundsException("Use the add method to insert element at the end of the ArrayList");
         } else{
            //throw exception
            //no values stored between end of array and index
            throw new IndexOutOfBoundsException("There's no value stored before index " + index);
         }
     }

   public int get(int index){
      //do some simple error checking
      //if there is nothing to look at
      if(this.isEmpty()){
         throw new IndexOutOfBoundsException("The list is empty");
      }
      //make sure index lies within data set
      if(index < numItems && index >= 0){
         //return item at array index
         return this.items[index];
      }else{
         throw new IndexOutOfBoundsException("No number exists at index " + index);
      }
   }

   public int remove(int index){
      //error checking if there is nothing to look at
      if(this.isEmpty()){
         throw new IndexOutOfBoundsException("The list is empty");
      }
      //make sure index lies within data set
      if(index < numItems && index >= 0){
         //copy array across value from point index onwards in new array
         int[] temp = new int[this.items.length];
         for(int i = index; i < this.items.length; i++){
            temp[i-index] = this.items[i];
         }
         //remove element in items array
         //copy temp array across items array excluding removed element
         for(int i = index; i < temp.length; i++){
            this.items[i] = temp[i-index + 1];
         }
         numItems--;
         //return removed number
         return temp[0];
      }else{
         //throw exception
         //index of array is empty
         throw new IndexOutOfBoundsException("No number exists at index " + index);
      }
   }

   public int size(){
      return this.numItems;
   }

   public boolean isEmpty(){
      return this.numItems == 0;
   }

   public static void main(String[] args) {
      //test out ArrayList
      ArrayList myNumbers = new ArrayList();
        myNumbers.add(8);
        myNumbers.add(9);
        myNumbers.add(11);
        myNumbers.add(12);
        myNumbers.add(13);
        myNumbers.add(21);
        myNumbers.add(6);
        myNumbers.add(100);
        myNumbers.add(2);
        myNumbers.add(33);
        myNumbers.add(49);
        myNumbers.add(6);
        myNumbers.add(8);
        myNumbers.add(12);
        myNumbers.add(8,5);
        myNumbers.add(13,2022);
        System.out.println(myNumbers.size());
        System.out.println(myNumbers.get(4));
        System.out.println(myNumbers.get(6));
        System.out.println(myNumbers.remove(11));
        System.out.println(myNumbers.isEmpty());
        for(int i = 0; i < myNumbers.size(); i++){
           System.out.print(myNumbers.get(i) + ", ");
        }
   }
}

