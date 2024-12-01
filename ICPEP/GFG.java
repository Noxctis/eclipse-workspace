import java.util.HashMap;

public class GFG {
    public static void main(String[] args){

        /* HashSet<String> hs = new HashSet<String>();

        hs.add("geeks");
        hs.add("practice");
        hs.add("contribute");

        System.out.println("Before adding duplicate values \n\n" + hs);
        hs.add("geeks");
        hs.add("practice");

        hs.add(null);
        hs.add(null);

        System.out.println("After adding duplicate values \n\n" + hs); */
        
        HashMap<Integer,String> hm = new HashMap<Integer,String>();
        hm.put(12, "geeks");
        hm.put(2, "practice");
        hm.put(7, "contribute");
        System.out.println("HashMap oiobject output \n\n" + hm);

        hm.put(7, "geeks");
        hm.put(12, "contribute");

        System.out.println("\n AFter Insertion output \n\n" + hm);



    }
}
