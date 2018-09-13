class BSTtest {

    public static int[] tallrekke(int antall) {
        java.util.Random tilf = new java.util.Random(20102018);
        int[] tall = new int[antall];
        for ( int i=0; i<antall; i++) {
            tall[i] = tilf.nextInt();
        }
        return tall;
    }
    
    public static void main(String[] args) {

        int antall = Integer.parseInt(args[0]);

        int[] intarr = tallrekke(antall);
        BSTree testtre = null;
        if (antall == 0 ) {
        
            System.out.println("n         antall         findNearestSmallerThan(2000000000)\n");
            for (int ant=1; ant <= 1000000; ant=ant*10) {
                testtre = new BSTree();

                intarr = tallrekke(ant);
                for (int i : intarr) { 
                    testtre.add(i); 
                }
                System.out.printf("%1s", ant);    // n
                System.out.printf("%10s", testtre.size());  // antall
                //System.out.print(" " + testtre.height());
                System.out.printf("%16s", testtre.findNearestSmallerThan(2000000000)+ "\n");    // findNearestSmallerThan
            }

        }

        else {

            testtre = new BSTree();
            for (int i : intarr) { 
                testtre.add(i);
            }
            intarr = testtre.sortedArray();
            for (int i : intarr) { 
                System.out.println("Sorted: " + i); 
        }

            // EGNE TESTER:

            int tall = 1438708838;
            int nearestSmallest = testtre.findNearestSmallerThan(tall);
            System.out.println("In range of: " + testtre.findInRange(-1577698714, 1690759767));
            System.out.println("'" +tall + "' Exists in tree: " + testtre.existsInTree(tall));
            System.out.println(nearestSmallest + " is nearest smallest than: " + tall);

            System.out.println("Size: " + testtre.size());
            System.out.println("Remove: " +testtre.remove(tall) + " (" + tall + ")");
            System.out.println("Size: " + testtre.size());
            System.out.println("'" +tall + "' Exists in tree: " + testtre.existsInTree(tall));


            System.out.println("In range of: " + testtre.findInRange(-1577698714, 1665674363));

        }
    }
}