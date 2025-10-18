class AtoI {
    public static void main(String[] args) {
        String s = "-42";
        System.out.println(AtoImethod(s));
    }

    public static int AtoImethod(String s){
        s = s.trim();
        boolean sign = true; 
        int i=0;
        long res = 0;

        if(s.length()==0) return 0;

        if(s.charAt(0) == '-'){
            sign = false;
            i++;
        }
        else if(s.charAt(0) == '+'){
            i++;
        }

        while(i<s.length()){
            char c = s.charAt(i);
            if(c<'0' || c>'9') break;

            res = res * 10 + (c - '0');

            if(sign && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(!sign &&  -1 * res < Integer.MIN_VALUE) return Integer.MIN_VALUE;

            i++;
        }

        return (int)(sign ? res : -res);
    }
}