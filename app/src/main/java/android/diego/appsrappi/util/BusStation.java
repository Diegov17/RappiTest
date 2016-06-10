package android.diego.appsrappi.util;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by Diego on 6/7/2016.
 */
public class BusStation {

    private static Bus bus;

    public synchronized static Bus getBus() {

        if (bus == null){
            bus = new Bus(ThreadEnforcer.ANY);
        }
        return bus;
    }
}
