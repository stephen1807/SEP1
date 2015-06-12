package proj.logic;

import proj.obj.LogCode;
import proj.service.LogCodeService;

/**
 * Created by Stephen on 2015/06/12.
 */
public class LogCodeLogic {

    public void deleteLogCode(int newLC) {

        LogCodeService lcs = LogCodeService.getInstance();

        LogCode lc = lcs.getLogCode(newLC);
        lc.setAvailable(false);
        lcs.editLogCode(lc);
    }
}
