package com.seventhtill.interceptor;

public interface Interceptor {
    void onBeginning();
    void onEnd(CharacterContext character);
}