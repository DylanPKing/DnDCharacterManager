package com.seventhtill.interceptor;

public interface Interceptor {
    void onBeginning(Character character);
    void onEnd(Character character);
}