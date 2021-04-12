package com.seventhtill.interceptor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dispatcher {
    private ArrayList<Interceptor> interceptors;

    public void registerInterceptor() {
    }

    public void removeInterceptor() {
    }

    public void dispatchCharacterCreateInterceptor(Character context) {
        ArrayList<Interceptor> interceptors = new ArrayList<>(this.interceptors);

        for (Interceptor interceptor : interceptors) {
            if (interceptor instanceof CharacterCreateInterceptor) {
                CharacterCreateInterceptor charIntercept = (CharacterCreateInterceptor) interceptor;
                charIntercept.onBeginning(context);
            }
        }
    }
}
