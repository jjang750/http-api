import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    private String logFilePath = "../";
    private static boolean DEBUG = false;
    
    public void debug(boolean debug) {
        DEBUG = debug;
    }

	public void setLogFilePath(String logFilePath) {
		this.logFilePath = logFilePath;
	}
	
    public void println(String log) throws IOException {
		System.out.println("[" + getDate("kk:mm:ss") + "] " + log);
    }

    public void debugln(String log) throws IOException {
        if (DEBUG) {
            println(log);
        }
    }

    static private String getDate(String format) {
        try {
            Date date = new Date();
            SimpleDateFormat simpledateformat = new SimpleDateFormat(format);
            return simpledateformat.format(date);
        } catch(Exception ex) {
            return "000000000000";
        }
    }

	public void printStackTrace(Exception exception) {
		try{
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			FileWriter fw = new FileWriter(logFilePath + getDate("yyyyMMdd") + ".log", true);
			PrintWriter fpw = new PrintWriter(fw);
			PrintWriter ospw = new PrintWriter(os, true);
			exception.printStackTrace(ospw);
			fpw.println("[" + getDate("kk:mm:ss") + "] " + os.toString());
			if (DEBUG)
				System.out.println("[" + getDate("kk:mm:ss") + "] " + os.toString());
			fpw.flush();
			ospw.flush();
			fw.close();
			fpw.close();
			ospw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
