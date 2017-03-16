package myfirstswing;

import java.util.Random;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.ComThread;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

public class Word {
    public static String path;
    public static String fileName;
    public static ActiveXComponent com_wordApp;
    public Word() {
       com_wordApp = ActiveXComponent.connectToActiveInstance("Word.Application");
        Object oWordBasic = Dispatch.call(com_wordApp, "WordBasic").getDispatch(); 
        fileName = Long.toString(System.currentTimeMillis());
        path =  "C:\\Users\\Abhay\\Desktop";
        Dispatch.call((Dispatch) oWordBasic, "FileSaveAs", path+fileName+".doc", new Variant(8));
        
    }
    
    public static void closeFile()
    {
      Variant f = new Variant(false);
      com_wordApp.invoke("Quit", new Variant[]{});
      ComThread.Release();
    }
    



    

    
    
}
