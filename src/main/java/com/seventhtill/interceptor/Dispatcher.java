package com.seventhtill.interceptor;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Dispatcher {
    private ArrayList<Interceptor> interceptors;

    public void registerInterceptor() {
    }

    public void removeInterceptor() {
    }

    public void dispatchCharacterCreateInterceptor() {
        ArrayList<Interceptor> interceptors = new ArrayList<>(this.interceptors);

        for (Interceptor interceptor : interceptors) {
            if (interceptor instanceof CharacterCreateInterceptor) {
                CharacterCreateInterceptor charIntercept = (CharacterCreateInterceptor) interceptor;
                charIntercept.onBeginning();
            }
        }
    }

    public void dispatchCharacterCreateCompleteInterceptor(CharacterContext context) {
        ArrayList<Interceptor> interceptors = new ArrayList<>(this.interceptors);

        for (Interceptor interceptor : interceptors) {
            if (interceptor instanceof CharacterCreateInterceptor) {
                CharacterCreateInterceptor charIntercept = (CharacterCreateInterceptor) interceptor;
                charIntercept.onEnd(context);
            }
        }
    }
}
