package top.misec;


import lombok.extern.log4j.Log4j2;
import top.misec.login.ServerVerify;
import top.misec.login.Verify;
import top.misec.task.DailyTask;
import top.misec.utils.VersionInfo;

@Log4j2
public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            log.info("任务启动失败");
            log.warn("Cookies参数缺失，请检查是否在Github Secrets中配置Cookies参数");
        }
        VersionInfo.printVersionInfo();
        //读取环境变量
        Verify.verifyInit(args[0], args[1], args[2]);
        if (args.length > 4) {
            ServerVerify.verifyInit(args[3], args[4]);
        } else if (args.length > 3) {
            ServerVerify.verifyInit(args[3]);
        }
        DailyTask dailyTask=new DailyTask();
        dailyTask.doDailyTask();
    }
}
