package srki2k.tweakedpetroleum.util.errorloggingutil.startup;

public class ServerSideStartup extends StartupErrorLoggingUtil {

    public void validateScripts() {
        super.validateScripts();

        markStartupInstanceNull();
    }

}
