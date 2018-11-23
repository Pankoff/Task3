import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Double> cashOffice1 = new ArrayList<>();
    private List<Double> cashOffice2 = new ArrayList<>();
    private List<Double> cashOffice3 = new ArrayList<>();
    private List<Double> cashOffice4 = new ArrayList<>();
    private List<Double> cashOffice5 = new ArrayList<>();
    private List <Double> sumQueueAtCashOffice = new ArrayList<>();

    {
        for (int i = 0; i <16 ; i++)sumQueueAtCashOffice.add((double) 0);
    }

    private double maxPeople = 0;
    private List<Integer> hour = new ArrayList<>();
    private int counter=1;

    public List<Double> getCashOffice1() {return cashOffice1;}

    public List<Double> getCashOffice2() {return cashOffice2;}

    public List<Double> getCashOffice3() {return cashOffice3;}

    public List<Double> getCashOffice4() {return cashOffice4; }

    public List<Double> getCashOffice5() {return cashOffice5; }

    public void getQueueAtStore(List<Double> cashOffice, String path){
            String tmp;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader
                    (new FileInputStream(new File(path+counter)), "utf-8"))) {
                while ((tmp=reader.readLine())!=null){
                cashOffice.add(Double.parseDouble(tmp));}
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            counter++;
    }

    public void FindPopularTime(List<Double> cashOffice){
        for (int i = 0; i <cashOffice.size(); i++) {
            sumQueueAtCashOffice.set(i,sumQueueAtCashOffice.get(i)+cashOffice.get(i));
            if(sumQueueAtCashOffice.get(i)>maxPeople)maxPeople=sumQueueAtCashOffice.get(i);
        }
    }

    private void findCountSpanOfTime(){
        for (int i = 0; i <sumQueueAtCashOffice.size() ; i++) if(sumQueueAtCashOffice.get(i)==maxPeople)hour.add(i+1);
    }

    public void printPopularTime(){
        findCountSpanOfTime();
        if(hour.isEmpty()) System.out.println("Очереди отсутвуют");
        if(hour.size()>1)System.out.println("Пик очередей в магазине приходился на:"+printHour()+" получаса, промежутков времени");
        if(hour.size()==1)System.out.println("Пик очередей в магазине приходился на:"+printHour()+" получаса, промежутка времени");

    }

    private String printHour(){
        String tmp="";
        for (int i = 0; i <hour.size() ; i++) {
            tmp+=" c " +(hour.get(i)-1)+"го по "+(hour.get(i)+"й");
        if (hour.size()>1)tmp+=",";
        }
    return tmp;
    }
}
