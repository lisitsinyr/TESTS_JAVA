import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import java.io.File;
import LUTools.TConst;
import LUTools.TVersionInfo;

public class Version {

    public static void main (String[] args) {
        //-------------------------------------------
        // Печать аргументов
        //-------------------------------------------
        System.out.println (args.length);
        for (int i = 0; i < args.length; i++) {
            //System.out.println (i == 0 ? args[i] : "->" + args[i]);
            System.out.println (String.format("Argument %d: %s", i, args[i]));
        }
        //-------------------------------------------

        //-------------------------------------------
        // Jcommander
        //-------------------------------------------
        P1Args jArgs = new P1Args();
        JCommander helloCmd = JCommander .newBuilder() .addObject(jArgs) .build();
        helloCmd.parse(args);

        System.out.println ("P1=" + jArgs.getP1());

        //=====================================================
        String FileName = jArgs.getP1();

        TConst MyConst = new TConst();
        System.out.println (MyConst.LogDir);

        File file = new File(FileName);
        if (file.exists() && !file.isDirectory()) {
            System.out.println ("File=" + file.getName());
            TVersionInfo VersionInfo = new TVersionInfo();
            VersionInfo.setFileName(FileName);
            System.out.println (String.format("FileName         : %s", VersionInfo.getFileName()));
            /*
            System.out.println (String.format("FileVersion      : %s", VersionInfo.FileVersion));
            System.out.println (String.format("FileDate         : %s", VersionInfo.FileDate));
            System.out.println (String.format("CompanyName      : %s", VersionInfo.CompanyName));
            System.out.println (String.format("FileDescription  : %s", VersionInfo.FileDescription));
            System.out.println (String.format("InternalName     : %s", VersionInfo.InternalName));
            System.out.println (String.format("LegalCopyright   : %s", VersionInfo.LegalCopyright));
            System.out.println (String.format("LegalTrademarks  : %s", VersionInfo.LegalTrademarks));
            System.out.println (String.format("OriginalFilename : %s", VersionInfo.OriginalFilename));
            System.out.println (String.format("ProductName      : %s", VersionInfo.ProductName));
            System.out.println (String.format("ProductVersion   : %s", VersionInfo.ProductVersion));
            System.out.println (String.format("Comments         : %s", VersionInfo.Comments));
            VersionInfo.free;
            */
            }
        else {
            System.out.println ("Hello Java!");
            System.out.println ("файл не задан");
        }
    }
}

class P1Args {
    @Parameter(names = "-P1",description = "User name",required = true)
    private String P1;
    public String getP1() {
        return P1;
    }
}
