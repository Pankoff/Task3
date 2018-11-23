
public class Main {
    public static void main(String[] args) {
    Store store = new Store();
    String filePath = "../cashOffice";

    store.getQueueAtStore(store.getCashOffice1(), filePath);
    store.getQueueAtStore(store.getCashOffice2(), filePath);
    store.getQueueAtStore(store.getCashOffice3(), filePath);
    store.getQueueAtStore(store.getCashOffice4(), filePath);
    store.getQueueAtStore(store.getCashOffice5(), filePath);

    store.FindPopularTime(store.getCashOffice1());
    store.FindPopularTime(store.getCashOffice2());
    store.FindPopularTime(store.getCashOffice3());
    store.FindPopularTime(store.getCashOffice4());
    store.FindPopularTime(store.getCashOffice5());

    store.printPopularTime();
    }

}
