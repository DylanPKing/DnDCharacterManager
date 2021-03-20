package com.seventhtill.Interceptor;

import java.util.ArrayList;

public class Dispatcher {
    private ArrayList<Interceptor> interceptors;

    public void registerInterceptor() {
    }

    public void removeInterceptor() {
    }

    public void dispatchCharacterCreateInterceptor(Character context) {
        ArrayList<Interceptor> interceptors = (ArrayList<Interceptor>) (this.interceptors.clone());

        for (Interceptor interceptor : interceptors) {
            if (interceptor instanceof CharacterCreateInterceptor) {
                CharacterCreateInterceptor charIntercept = (CharacterCreateInterceptor) interceptor;
                charIntercept.onBeginning(context);
            }
        }
    }
}
