package com.jga.util.ads;

import com.badlogic.gdx.utils.Logger;
import com.badlogic.gdx.utils.Null;

public final class NullAdController implements AdController {

    public static final AdController INSTANCE = new NullAdController();

    private static final Logger log = new Logger("NullADController",Logger.DEBUG);


    public void showBanner() {
        log.debug("showBanner");
    }


    public void showInterstitial() {
        log.debug("showIntersitial");
    }


    public boolean isNetworkConnected() {
        return false;
    }
}
