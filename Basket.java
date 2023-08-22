package assignment1;

public class Basket {
    private Reservation[] res_array;
    public Basket(){
        this.res_array= new Reservation[1];
    }
    public Reservation[] getProducts(){
        Reservation[] copy_arr = new Reservation[this.res_array.length];
        for (int i=0;i<this.res_array.length;i++){
            copy_arr[i]=this.res_array[i];
        }
        return copy_arr;
    }
    public int add(Reservation res){
        if (this.res_array.length==1){
            if (this.res_array[0]==null){
                this.res_array[0] = res;
                return 1;
            }
        }
        Reservation[] new_arr = new Reservation[(this.res_array.length)+1];
        for (int i=0;i<this.res_array.length;i++){
            new_arr[i]= this.res_array[i];
        }
        new_arr[this.res_array.length]= res;
        this.res_array = new_arr;
        return new_arr.length;
    }
    public boolean remove(Reservation res){
        for (int i=0; i<this.res_array.length;i++){
            if (this.res_array[i].equals(res)){
                Reservation[] new_arr = new Reservation[(this.res_array.length)-1];
                for (int j=0;j<new_arr.length;j++){
                    if (i==j){
                        continue;
                    }
                    else{
                        new_arr[j]=this.res_array[j];
                    }
                }
                this.res_array=new_arr;
                return true;
            }
        }
        return false;
    }
    public void clear(){
        Reservation[] new_arr = new Reservation[0];
        this.res_array = new_arr;
    }
    public int getNumOfReservations(){
        if (this.res_array.length==1){
            if(this.res_array[0]==null){
                return 0;
            }
        }
        return this.res_array.length;
    }
    public int getTotalCost(){
        int total=0;
        for (int i=0; i<this.res_array.length;i++){
            total+=this.res_array[i].getCost();
        }
        return total;
    }
}
