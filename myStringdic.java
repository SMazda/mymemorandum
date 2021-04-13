import java.util.*;

class myStringdic{
    public static String jishort(List<String> list,int n){
        List<String> nowlist = new ArrayList<String>(list);
        String ans = new String();
        char dec[] = {'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z'};
        int nextshort[] = new int[nowlist.size()];
        int dex=0;
        for(int i=0;i<52;i++){
            if(nowlist.size()==0) break;
            for(int j=0;j<nowlist.size();j++){
                if(nowlist.get(j).length()<=n){
                    ans=ans+nowlist.get(j);
                    nowlist.remove(j);
                }else{
                    if(nowlist.get(j).charAt(n)==dec[i]){
                        nextshort[dex]=j;
                        dex++;
                    }
                }
            }
            if(dex>0){
                if(dex>1){
                    List<String> nextlist = new ArrayList<String>();
                    for(int k=0;k<dex;k++){
                        nextlist.add(nowlist.get(nextshort[k]));
                    }
                    ans = ans + jishort(nextlist,n+1);
                }else{
                    ans=ans+nowlist.get(nextshort[0]);
                    nowlist.remove(nextshort[0]);
                }
                dex=0;
            }

        }
        return ans;
    }




    public static void main(String[] args){
        Scanner sc0 = new Scanner( System.in );
        String S  = sc0.nextLine();
        int N = S.length();
        List<String> list = new ArrayList<String>();
        char word[] = S.toCharArray();
        int n=1;

        for(int i=1;i<N;i++){
            if(Character.isUpperCase(word[i])){
                String moji = String.valueOf(word[n-1]);
                for(int j=n;j<=i;j++){
                    moji=moji+word[j];
                }
                list.add(moji);
                i++;
                n=i+1;
            }

        }

        String ans = jishort(list,0);
        
        System.out.println(ans);
       
    
    
    }
}

