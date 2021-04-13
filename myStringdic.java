/*********************** 
大文字,小文字を無視した文字列の辞書順並べ替えメソッドです.
並び替えたい文字列群をリスト型で保持し,
それを第一引数に与え,
第二引数に0を与えます.
返り値は,それぞれの語が改行文字で区切られた
String型で返します.
つまり

"red""blue""green""black""RE""BL""bL"

という入力の場合

"BL"+"\n"+"bL"+"\n"+"black"+"\n"+"blue"+"\n"+"green"+"\n"+"RE"+"\n"+"red"

を返します.
呼び出しの場合は

String ans = jishort(list,0);

などで呼び出してください.
***********************/

import java.util.*;

class myStringdic{
    public static String jishort(List<String> list,int n){
        List<String> nowlist = new ArrayList<String>(list);
        String ans = new String();
        char dec[] = {'A','a','B','b','C','c','D','d','E','e','F','f','G','g','H','h','I','i','J','j','K','k','L','l','M','m','N','n','O','o','P','p','Q','q','R','r','S','s','T','t','U','u','V','v','W','w','X','x','Y','y','Z','z'};
        int nextshort[] = new int[nowlist.size()];
        int dex=0;
        for(int i=0;i<52;i++){                              //'A','a','B','b', ... ,'Z','z'の順で見ていく
            if(nowlist.size()==0) break;                    //要素を全て処理すれば終了
            for(int j=0;j<nowlist.size();j++){              //リストを順に参照
                if(nowlist.get(j).length()<=n){             //全く同じ文字列や文字があった場合の処理
                    ans=ans+nowlist.get(j) + "\n";
                    nowlist.remove(j);
                }else{
                    if(nowlist.get(j).charAt(n)==dec[i]){   //n番目の文字が同じ場合,リストの何番目かを記憶する
                        nextshort[dex]=j;
                        dex++;
                    }
                }
            }
            if(dex>0){
                if(dex>1){                                  //n番目の文字が同じ文字列が複数ある場合
                    List<String> nextlist = new ArrayList<String>();
                    for(int k=0;k<dex;k++){
                        nextlist.add(nowlist.get(nextshort[k]));
                    }
                    ans = ans + jishort(nextlist,n+1);      //再帰的に処理する
                }else{
                    ans=ans+nowlist.get(nextshort[0]) + "\n";
                    nowlist.remove(nextshort[0]);
                }
                dex=0;
            }

        }
        return ans;
    }




    public static void main(String[] args){
        List<String> list = new ArrayList<String>();
        list.add("red");
        list.add("blue");
        list.add("green");
        list.add("black");
        list.add("RE");
        list.add("BL");
        list.add("bL");

        String ans = jishort(list,0);
        
        System.out.print(ans);
       
    
    
    }
}

