package Reusable;

public class RemoveCharacter{

    public static String RemoveStringText(String TextToBeRemoved)
    {
        String rem_brac=TextToBeRemoved.replaceAll("\\(","%");
        String rem_coma=rem_brac.replaceAll(",","");
        String fs=rem_coma.substring(0,rem_coma.indexOf("%")+1);
        String RemovedText=fs.replace("%","");
        return RemovedText;
    }

}
