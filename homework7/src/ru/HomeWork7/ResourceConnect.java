package ru.HomeWork7;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class ResourceConnect implements AutoCloseable{
    private int countAttempts;
    private int timeOutSec;
    ResourceConnect ()
    {
        this.countAttempts = 1;
        this.timeOutSec = 0;
    }
    ResourceConnect (int countArrempts, int secTimeOut) {
        this.countAttempts = countArrempts;
        this.timeOutSec = secTimeOut;
    }
    public void  connectResource(){
            int cnt = this.countAttempts;
            int sec = this.timeOutSec;

            boolean connect = false;
            int x = (int) (Math.random() * (cnt+1));
            for (int i = 0; i < cnt; i++) {
                if ( i== x )
                {
                    connect = true;
                    break;
                }
                System.out.println("Connect faild.Please wait...");
                try {
                    TimeUnit.SECONDS.sleep(sec);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (!connect) {
                System.out.println("Connect faild!!.Sorry!");
                throw new RuntimeException("FAILD!!!");
            } else {
                System.out.println("Connect yes!!!.The connection is established");
            }
        }
    public  void connectExecuteAction() {
        System.out.println("class ResourceConnect executing its action !!");
    }
    public HashMap<String,String[]> readStream() {
        HashMap<String, String[]> buff = new HashMap<>();
        String[] curList = new String[]{"RUB","USD","CNY"};
        String[][] strCurEnding = new String[][]{ {"рубль", "рубля", "рублей"},
                                                  {"доллар", "доллара", "долларов"},
                                                  {"юань","юаня","юаней"}
                                                };
        for (int i = 0; i < curList.length; i++) {
            buff.put(curList[i],strCurEnding[i]);
        }
        return buff;
    }

    @Override
    public void close() throws Exception{
        System.out.println("class ResourceConnect closed!!");
    }
}

