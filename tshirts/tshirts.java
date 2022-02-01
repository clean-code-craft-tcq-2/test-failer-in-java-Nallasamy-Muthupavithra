public class Tshirts {
    static String size(int cms) {
        if(cms > 36 && cms <= 38) {
            return "S";
        } else if(cms > 38 && cms <= 40) {
            return "M";
        } else if(cms > 40 && cms <=42 {
            return "L";
        } else if(cms <= 36 || cms > 42){
            return "NA";
        }           
    }

    public static void main(String[] args) { 
        assert(size(37) == "S");
        assert(size(38) == "S");
        assert(size(40) == "M");
        assert(size(41) == "L");
        assert(size(43) == "NA");
        assert(size(20) == "NA");
        assert(size(100) == "NA");
        System.out.println("All is well (maybe!)");
    }
}
